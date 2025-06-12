package mbcmember.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import mbcmember.dto.MemberDTO;

public class MemberDAO {
	// 2025.06.11
	// DAO : JDBC를 담당하는 클래스이다. 회원의 DB와 연동을 담당한다.
	// JDBC 5단계
	// 2025.06.12 
	// 탈퇴메서드를 제외한 CRU 완료. (D추가해야함.)
	
	// 필드
	public MemberDTO memberDTO = new MemberDTO();
	public Connection connection = null ;
	public Statement statement = null;    // 쿼리문을 실행하는 객체 (구형)
	public PreparedStatement preparedStatement = null; // 쿼리문을 실행하는 객체 (신형) ? 인파라미터 사용
	public ResultSet resultSet = null ; 			   // 결과값을 표로 받는 객체 (executeQuery)(select 결과)
	public int result = 0 ;							   // 결과값을 정수로 받을때 반환받을 변수 executeUpdate(insert, update, delete)
	
	// 기본 생성자 : MemberDAO 객체를 생성할 때, 기본 생성자가 먼저 실행된다. (constructor)
	public MemberDAO() {
	// 기본 생성자에서 DB연결된 상태로 준비된다. 따라서 작업 후에는 꼭 커넥션을 close(); 해주어야함.
	// MemberDAO의 기본생성자에서 1단계, 2단계를 수행한다.
	// Class.forName으로 드라이버 로딩
	// DriverManager.getConnection으로 로딩된 드라이버를
	// Connection 객체로 반환 (DB와 연결)
	// 필드에서 public으로 MemberDAO 객체를 생성하여 메서드에서 DAO객체를 활용하겠다.
		
		try {
			// 1단계 : JDBC드라이버 호출하여 로딩한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class.forName()으로 JDBC드라이버(ojdbc6.jar를 호출하여)로딩한다.
			// JDBC드라이버가 로딩되면 자동으로 객체가 생성되고 DriverManager클래스에 등록된다.
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "boardtest", "boardtest");
			// DriverManager객체의 getConnection()을 활용하여 java와 db를 연결한다.
			// Connection 객체를 생성할 때 JDBC드라이버를 검색하고 검색된 드라이버를 활용하여 Connection 객체를 생성한 후 반환한다
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 이름이나, ojdbc6.jar 파일이 잘못 되었습니다.");
			e.printStackTrace(); // 오류발생로그출력
			System.exit(0); // 강제종료
		} catch (SQLException e) {
			System.out.println("url, id, pw가 잘못 되었습니다. MemberDAO의 기본생성자를 확인하세요");
			e.printStackTrace(); // 오류발생로그출력
			System.exit(0); // 강제종료
		}
	
	} // MemberDAO 기본생성자 종료
	
	// 메서드
	public boolean verificationPw(String loginId, String inputPw) throws SQLException {
		try {
			// loginSession.getId 데이터가 담긴 열의 pw열 값이 inputPw와 일치하면 T반환 / 불일치 F반환
			// SQL : select pw from member where id = loginSession.getId and pw = 'inputPw'
			//String sql = "select pw from member where id ="+" '" + loginSession.getId() +"' " 
			//+ "and pw = '" + inputPw +"'";
			String sql = "select pw from member where id = '"+loginId +"' and pw = '"+ inputPw +"'";
			statement = connection.createStatement() ;
			System.out.println("쿼리문확인 : " + sql); //테스트용
			resultSet = statement.executeQuery(sql); //쿼리문 실행 결과를 표로 받는다.
			
			if (resultSet.next() != false) { // resultSet에 pw 값이 들어있으면 True (입력값과 일치)
				return true; 
			} else{
				System.out.println("비밀번호가 일치하지 않습니다.");
				return false ;
			}
			
		} catch (SQLException e) {
			System.out.println("verificationPw()의 쿼리문을 확인하세요");
			e.printStackTrace();
			
		} finally {
			resultSet.close();
			statement.close();
			
		}
		
		return false;
	}//verificationPw()메서드종료
	

	public boolean verificationId(String inputId) throws SQLException {
		// id검증코드
		// 입력받은 id를 검증하여 일치하는 id가 있으면 T , 일치하는 id가 없으면 F로 반환한다.
		try {
			// id검증 메서드
			String sql = "select id from member where id  = "+ "'" + inputId +"'";
			statement = connection.createStatement() ;
			//System.out.println("쿼리문 확인 " + sql); (테스트용)
			resultSet = statement.executeQuery(sql);
			
			if (resultSet.next() != false) {
				System.out.println("일치하는 아이디가 있습니다.");
				return true;
				
			} else {
				System.out.println("일치하는 아이디가 없습니다.");
				return false;
			} 
		} catch (SQLException e) {
			System.out.println("verification() 쿼리문을 확인하세요");
			e.printStackTrace();
		} finally {
			resultSet.close();
		    statement.close();
		}
		return false;
	} //id 검증 verification()메서드종료

	public void memberAdd(MemberDTO memberDTO) throws SQLException {
		try {
			// 회원가입 메서드 
			// PreparedStatment : 동적 쿼리문을 사용하여 setter로 입력하겠다.
			// service에서 입력받은 id, pw, 이름을 memberDTO객체로 전달받았음.
			// SQL : insert into mno, bwirter, id, pw values (board_seq.nextval, '이름', 'id', 'pw') ;
			// preparedStatment = connection.preparedStatment(sql)
			String sql = "insert into member( mno, bwriter, id, pw, regidate )" + "values(board_seq.nextval, ?, ?, ?, sysdate)";
			preparedStatement = connection.prepareStatement(sql); // sql을 컴파일후 반환하여 preparedStatement객체에 넣는다.
			preparedStatement.setString(1, memberDTO.getBwriter());
			preparedStatement.setString(2, memberDTO.getId());
			preparedStatement.setString(3, memberDTO.getPw());
			System.out.println("쿼리 확인 : " + sql); // 쿼리문 완성본 확인용 (테스트)
			result = preparedStatement.executeUpdate(); // executeUpdate()는 변경된 내용을 정수로 반환한다.
			if (result > 0) {
				System.out.println("가입이 완료되었습니다.");
				connection.commit();
			} else {
				System.out.println("가입에 실패하셨습니다");
				System.out.println("쿼리 실행 결과 : " + result);
				connection.rollback();
			} // result if-else문 종료
			
		} catch (SQLException e) {
			System.out.println("memberDAO memberAdd()의 쿼리문을 확인해주세요.");
			e.printStackTrace();
			
		}finally {
			preparedStatement.close();
		}
			
	} //memberAdd()회원가입 메서드 종료

	public void readOne(MemberDTO loginSession, MemberDAO memberDAO) throws SQLException {
		try {
			// 내 정보 페이지
			String sql = "select * from member where id= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginSession.getId() );
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("가입 일자 : " + resultSet.getDate("regidate"));
				System.out.println("회원 번호 : " + resultSet.getInt("mno"));
				System.out.println("회원 이름 : " + resultSet.getString("bwriter"));
				System.out.println("회원 ID : " + resultSet.getString("id"));
				System.out.println("회원 PW : " + resultSet.getString("pw"));
				System.out.println("======================");
			}
			
			// if(resultSet.getString("id").equals(loginSession.getId()))
			// resultSet.next() 메서드를 호출해야 결과값을 출력할 수 있음.
			// 이미 where로 조건을 걸었기때문에 이퀄스안해도됨
			
		} catch (SQLException e) {
			System.out.println("예외발생 : readOne()메서드를 확인해주세요");
			e.printStackTrace();
			
		}finally {
			resultSet.close();
			preparedStatement.close();
		}
		
	} //readOne() 메서드

	public MemberDTO memberLogin(MemberDTO memberDTO) throws SQLException {
		MemberDTO session = new MemberDTO();
		try {
			// loginid, loginpw와 일치하는 데이터열을 반환받아 loginSession에 넣는다.
			// SQL : "select * from member where id = memberDTO.getId pw = memberDTO.getPw";
			String sql = "select * from member where id= ? and pw= ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			preparedStatement.setString(2, memberDTO.getPw());
			//System.out.println("쿼리문 확인용 :" +sql);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				session.setMno(resultSet.getInt("mno"));
				session.setId(resultSet.getString("id"));
				session.setPw(resultSet.getString("pw"));
				session.setBwriter(resultSet.getString("bwriter"));
				session.setRegidate(resultSet.getDate("regidate"));
				System.out.println("======================");
//				System.out.println("번호 : " + session.getMno());
//				System.out.println("ID : " + session.getId());
//				System.out.println("PW : " + session.getPw());
//				System.out.println("이름 : " + session.getBwriter());
//				System.out.println("가입날짜 : " + session.getRegidate());
			} else {
				System.out.println("로그인에 실패하셨습니다.");
			}
		} catch (SQLException e) {
			System.out.println("예외발생 : memberLogin()를 확인하세요.");
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
		}
		
		return session;
	} // memberLogin()로그인 메서드종료

	public MemberDTO remove(MemberDTO loginSession, MemberDAO memberDAO, String input, String reInput) throws SQLException {
		try {
			// 정보수정페이지입니다
			// SQL : update member set ? = ? 
			String sql = "update member set " + input + " = '" + reInput + "' where " + "id" + " = '"
					+ loginSession.getId() + "'" ;
			
//			String sql = "update member set ? = ? where ? = ? ";
//			System.out.println(input + reInput );
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, input);
//			preparedStatement.setString(2, reInput);
//			preparedStatement.setString(3, "id");
//			preparedStatement.setString(4, loginSession.getId() );
//			
//			result = preparedStatement.executeUpdate();
			
			statement = connection.createStatement();
			System.out.println("쿼리문 확인 : " + sql);
			result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println(result + "개의 정보가 수정되었습니다.");
				connection.commit();
			} else {
				System.out.println("정보가 수정되지 않았습니다. 다시 시도해주세요");
				connection.rollback();
			} 
		} catch (Exception e) {
			System.out.println("remove()를 확인해주세요");
			e.printStackTrace();
		}finally {
			statement.close();
			
		}
		return loginSession;
	}
	
	

	
	
	
	
	

}// MemberDAO class종료
