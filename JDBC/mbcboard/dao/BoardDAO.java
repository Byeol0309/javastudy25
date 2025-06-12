package mbcboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	public PreparedStatement prepatedStatment = null; // 3단계에서 사용하는 객체(신형), ?(인파라미터)
	public ResultSet resultSet = null ;				  // 4단계에서 결과 받는 표 객체 executeQuery(select 결과)
	public int result = 0 ;							  // 4단계에서 결과 받는 정수 execyteUpdate(insert, update, delete)
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
			System.out.println("url, id, pw가 잘못 되었습니다. BoardDAO에 기본생성자를 확인하세요");
			e.printStackTrace();
			System.exit(0); // 강제종료
		}
		
		
	} // 기본생성자 종료


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
		
		
	} //selectAll()메서드종료


	public void insertBoard(BoardDTO boardDTO) {
		// BoardService에서 호출되는 insertBoard();
		// 게시글 작성하기.  JDBC를 이용하여 DB와 연동후 DB에 insert쿼리문을 처리하겠다.
		// PreparedStatement문을 사용해보자. 
		// PreparedStatemnet : 동적 쿼리문 ?(인파라미터)를 사용해서 setter로 입력한다.		
		
		// 3단계
		// 쿼리문 작성
		//String sql = "insert into board(bno, bti)"
		// 작성한 쿼리문 PreparedStatment 객체에 넣기 ( Connection.prepareStatment()메서드 활용 )
		
		
	}
	
	
	
	//메서드
}
