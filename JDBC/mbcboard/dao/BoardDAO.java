package mbcboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import mbcboard.dto.BoardDTO;

public class BoardDAO {
	// 2025.06.10
	// java와 Oracle
	// JDBC를 활용하여 게시판을 구현해보자.
	
	// DAO : JDBC를 담당하는 클래스이다. 게시판의 db와 연동을 담당한다.
	// 오라클과 쿼리를 작성하여 CRUD를 제공하자.
	// JDBC 5단계
	// 1단계 : Connection 객체를 사용하여 ojdbc6.jar를 생성한다. (Class.forName()로 호출하여 연결한다.)
	// 2단계 : Statement / PreparedStatement 
	// 3단계 : 쿼리문을 실행한다.
	// 4단계 : 쿼리문 실행 결과를 받는다.
	// 5단계 : 연결을 종료한다.

	// 필드
	public BoardDTO boardDTO = new BoardDTO();
	public Connection connection = null;  		// 1단계에서 사용하는 객체
	public Statement statement = null ;			// 3단계에서 사용하는 객체 (구형), 변수 직접처리 '"+name+"'
	public PreparedStatement preparedStatment = null; // 3단계에서 사용하는 객체(신형), ?(인파라미터)
	public ResultSet resultSet = null ;				  // 4단계에서 결과 받는 표 객체 executeQuery(select 결과)
	public int result = 0 ;							  // 4단계에서 결과 받는 정수 executeUpdate(insert, update, delete)
	// 1개의 행이 삽입 | 수정 | 삭제 되었습니다. (정상처리 -> commit)
	// 0개의 행이 삽입 | 수정 | 삭제 되었습니다. (비정상처리 -> rollback)
	
	
	// 기본 생성자 : BoardDAO 객체를 생성할 때, 기본생성자가 먼저 실행된다. 생성자(constructor)
	//			  기본 생성자에서 DB연결된 상태로 준비된다. 작업 후에는 커넥션을 꼭 close();
	public BoardDAO() {
		try { // 예외가 발생할 수 있는 실행문
			  // 프로그램 강제종료 처리용
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			// 1단계 Class.forName()으로 JDBC드라이버(ojdbc6.jar를 호출하여)를 로딩한다.
			// JDBC드라이버가 로딩되면 자동으로 객체가 생성되고 DriverManager 클래스에 등록된다.
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "boardtest", "boardtest");
			// DriverManager객체의 getConnection을 활용하여 java와 db를 연결한다.
			// Connection 객체를 생성할 때 JDBC드라이버를 검색하고 검색된 드라이버를 활용하여 Connection 객체를 생성한 후 반환한다.
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 이름이나, ojdbc6.jar 파일이 잘못 되었습니다.");
			e.printStackTrace();
			System.exit(0); // 강제종료
			
		} catch (SQLException e) {
			System.out.println("url, id, pw가 잘못 되었습니다. BoardDAO의 기본생성자를 확인하세요");
			e.printStackTrace();
			System.exit(0); // 강제종료
		}
		
		
	} // 기본생성자 종료


	// 메서드
	public void selectAll() throws SQLException {
		// Service에서 selectAll()를 받는다.
		// 게시판 목록 전체보기 
		// 1단계와 2단계는 기본생성자에서 완료되었다.
		// 3단계 : 쿼리문 실행
		// 4단계 : 쿼리문 결과 받기
		// 5단계 : close로 연결 닫기
		
		try { // 예외가 발생할 수 있는 실행문을 try {}에 넣는다.
			// 3단계 : 쿼리문 실행
			String sql = "select bno, btitle, bwriter, bdate from board order by bdate desc";
			// String sql 변수에 "쿼리문"을 넣는다.
			
			statement = connection.createStatement(); 
						// connection객체의 createStatement()메서드를 호출하여 쿼리문을 실행할 객체(Statement)를 생성.
						// Statement 객체의 statement에 쿼리문을 실행할 객체(Statement) 넣는다.
			
			resultSet = statement.executeQuery(sql); // sql을 DB에 실행시키고 결과를 resultSet에 반환한다.
						// statement(SQL문을 실행하는 역할임.)객체의 executeQuery()메서드를 실행하여 (sql)문자열로 담은 실행문을 실행한다.
																						// 쿼리실행문은 sql에 담겨있음.
						// ececuteQuery(sql);로 SQL문을 DB에 전송하고 실행한다.
						// 실행된 결과를 resultSet로 반환한다.  ResultSet(표로 반환.)
			System.out.println("번호\t 제목\t 작성자\t 작성일\t");
			while(resultSet.next()) {
				 // resultSet.next()은 값이 들어있으면 T, 값이 들어있지 않으면 F로 반환한다.
				 // 결과 표를 위에서부터 아래까지 내려오면서 출력한다.
				System.out.print( resultSet.getInt("bno") + "\t");
				System.out.print( resultSet.getString("btitle") + "\t");
				System.out.print( resultSet.getString("bwriter") + "\t");
				System.out.println( resultSet.getDate("bdate") + "\t");
			} // while문 종료 
			System.out.println("==========끝==========");
			
		} catch (SQLException e) { // 예외 발생 시 실행ㄷ문을 catch{}에 넣는다. 
			// SQLException : SQL의 예외 발생시
			System.out.println("selectAll()메서드에 쿼리문이 잘못 되었습니다.");
			e.printStackTrace(); // 오류 발생 로그를 출력한다.
		} finally {
			// 항상 실행되는 구문이다.
			resultSet.close();
			statement.close();
			// 열어준 객체를 다른 메서드도 정상 작동할 수 있다.
		}
		
		
	} //selectAll()게시판 목록 모두보기 메서드종료


	public void insertBoard(BoardDTO boardDTO) throws SQLException {
		// BoardService에서 호출되는 insertBoard();
		// 게시글 작성하기.  JDBC를 이용하여 DB와 연동후 DB에 insert쿼리문을 처리하겠다.
		// PreparedStatement문을 사용해보자. 
		// PreparedStatemnet : 동적 쿼리문 ?(인파라미터)를 사용해서 setter로 입력한다.		
		
		// 3단계
		// 쿼리문 작성
		try { // 예외가 발생될 수 있는 실행문.
			String sql = "insert into board(bno, btitle, bcontent, bwriter, bdate )" 
			              + "values(board_seq.nextval, ?, ?, ?, sysdate)";
			preparedStatment = connection.prepareStatement(sql); 
			 				  // connection 객체의 prepatedStatment메서드를 활용하여 SQL문을 컴파일한다.
							  // 컴파일 후 반환된 SQL문을 prepatedStatment객체에 넣는다.
			// prepatedStatment객체에 DB에 입력할 데이터를 넣는다.
			preparedStatment.setString(1, boardDTO.getBtitle()); // 1번째 인파라미터에 boardDTO의 gettr로 가져온 btitle 값을 넣는다.
																 // Service부메뉴에서 키보드로 입력받은 후 boardDTO.btitle변수에 넣은 데이터이다.
			preparedStatment.setString(2, boardDTO.getBcontent()); // 2번째 인파라미터에 boardDTO의 필드 bcontent 값을 넣는다.
			preparedStatment.setString(3, boardDTO.getBwiter());   // 3번째 인파라미터에 boardDTO의 필드 bwriter 값을 넣는다.
			System.out.println("쿼리 확인 : " + sql); // 쿼리문 완성본 확인용 (테스트)
			
			result = preparedStatment.executeUpdate();
									// executeUpdate() : 삽입, 수정, 삭제와 관련된 SQL문 실행에 사용한다.
			if (result > 0) {
				// prepatedStatment.executeUpdate();가 실행되면 result에 정수값을 반환한다.
				System.out.println(result + "개의 게시물이 등록 되어 있습니다.");
				connection.commit(); // 영구저장 트랜잭션을 관리하는 주체는 Connection이기때문에 Connection객체로 commit()
				
				// preparedStatement = connection.prepareStatment(sql) 코드를 실행하는 순간
				// PreparedStatement는 Connection과 연결된 내부 객체가 된다.
				// executeUpdate()가 실행될 때, 자동으로 Connection의 트랜잭션에 포함된다.
				// connection.commit()을 호출하면 그 안에서 실행된 모든 SQL작업이 확정(commit)되는것이다.
			} else {
				System.out.println("쿼리 실행 결과 : " + result);
				System.out.println("입력실패");
				connection.rollback(); // 롤백. 저장취소
			} // result if-else문 종료
					
		} catch (SQLException e) {
			// 예외 처리 실행문
			System.out.println("예외발생 : insertBoard()메서드에 쿼리문을 확인하세요 ");
			e.printStackTrace(); // 오류발생로그출력
		} finally {
			// 예외발생 및 정상 실행 후 무조건 처리되는 실행문.
			preparedStatment.close();
		}
		
		
		
	} //insertBoard() 게시글 작성 메서드종료


	public void readOne(String btitle) throws SQLException {
		// Service에서 검색할 bwriter를 매개변수 통해 받았음.
		// String sql 에 쿼리문 넣기. "select bno, btitle, bcontent, bwriter, bdate where bwriter = ?"
		// preparedStatment = preparedStatment.connection(sql)
		// preparedStatment.setString(1, )
		
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate from board where btitle = ?";
			preparedStatment = connection.prepareStatement(sql);
			preparedStatment.setString(1, btitle);
			
			//resultSet (결과값 표로 반환) 
			resultSet = preparedStatment.executeQuery(); // 쿼리문 실행 후 결과를 표로 받는다.
			
			if(resultSet.next()) {
			// resultSet.next() 값이 있으면 T, 값이 없으면 F로 반환.
				
			// resultSet으로 반환된 데이터를 출력하기 위해 boardDTO 객체를 생성하겠다.
				BoardDTO boardDTO = new BoardDTO(); // DB에서 반환된 데이터가 담긴 resultSet의 데이터를
													// boardDTO에 반환한 뒤 출력하겠다.
				
				// DB에서 반환된 데이터를 boardDTO에 넣겠다. (setter활용)
				boardDTO.setBno(resultSet.getInt("bno"));
				boardDTO.setBtitle(resultSet.getString("btitle"));
				boardDTO.setBcontent(resultSet.getString("bcontent"));
				boardDTO.setBdate(resultSet.getDate("bdate"));
				boardDTO.setBwiter(resultSet.getString("bwriter"));
				
				// boardDTO에 반환된 데이터를 출력하겠다.
				System.out.println("======================");
				System.out.println(" 작성일 : " + boardDTO.getBdate() + "\n 작성자 : " + boardDTO.getBwiter());
				System.out.println("[ " + boardDTO.getBtitle() +" ]");
				System.out.println("======================");
				System.out.println(boardDTO.getBcontent());
				System.out.println("======================");
				
			}else {
				// 입력한 값과 일치하는 데이터가 없을 시 출력된다.
				System.out.println("해당하는 게시물이 존재하지 않습니다.");
			} // if-else문 종료
			
		} catch (SQLException e) {
			System.out.println("예외발생 : readOne() 메서드를 확인하세요");
			e.printStackTrace();
		}finally {
			resultSet.close();
			preparedStatment.close();
		
		}
		
		
		
	} // readOne() 작성자 검색하여 게시판 열람하기 메서드 종료


	public void modify(String title, Scanner inputStr) throws SQLException {
		// title
		BoardDTO boardDTO = new BoardDTO();
		System.out.println("[수정하실 내용을 입력하세요]");
		System.out.print("제목 : ");
		boardDTO.setBtitle(inputStr.next());
		
		Scanner inputLine = new Scanner(System.in);
		System.out.print("내용 : ");
		boardDTO.setBcontent(inputLine.nextLine());
		
		try {
			String sql = "update board set btitle = ?, bcontent = ?, bdate = sysdate where btitle = ?";
			preparedStatment = connection.prepareStatement(sql) ;
			preparedStatment.setString(1, boardDTO.getBtitle());
			preparedStatment.setString(2, boardDTO.getBcontent());
			preparedStatment.setString(3, title); // Service부메뉴의 modify()에서 전달받은 입력값.
			
			result = preparedStatment.executeUpdate(); // 쿼리문 실행 후 결과를 정수로 반환한다.
			
			if(result > 0) {
				System.out.println(result + "개의 데이터가 수정 되었습니다. ");
				connection.commit();
			} else {
				System.out.println("수정이 되지 않았습니다.");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("예외발생 : modify() 메서드와 sql문을 확인하세요");
			e.printStackTrace();
		} finally {
			preparedStatment.close();
		}
		
		
	} // modify()메서드 종료


	public void deleteOne(int selectBno) throws SQLException {
		// Service에서 전달받은 selectBno를 이용하여 데이터를 삭제한다.
		// SQL : delete from board where bno = ?
		
		try {
			String sql = "delete from board where = ?";
			preparedStatment = connection.prepareStatement(sql);
			preparedStatment.setInt(1, selectBno);
			result = preparedStatment.executeUpdate(); //쿼리문 실행 후 결과를 정수로 반환한다.
			
			if(result > 0) {
				System.out.println(result + "게시물이 삭제 되었습니다.");
				connection.commit();
			}else {
				System.out.println("게시물이 삭제되지 않았습니다.");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("예외발생 : deleteOne() 메서드와 sql문을 확인하세요!!!");
			e.printStackTrace();
		} finally {
			preparedStatment.close();
		}
		
		
	} //deleteOne()메서드 종료
	
	
	
	
}
