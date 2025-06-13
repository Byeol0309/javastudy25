package memberTest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import memberTest.dto.MemberDTO;

public class MemberDAO {
	// 필드
	public MemberDTO memberDTO = new MemberDTO();
	public Connection connection = null;
	public Statement statement = null; 
	public PreparedStatement preparedStatement = null ;
	public ResultSet resultSet = null ;
	public int result = 0 ;
	
	// 기본생성자
	public MemberDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.163:1521:xe", "membertest",
					"membertest");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 이름이나, ojdbc6.jar 파일이 잘못되었습니다.");
			e.printStackTrace();
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("url, id, pw가 잘못되었습니다. MemberDAO의 기본생성자를 확인하세요");
			e.printStackTrace();
			System.exit(0);
		} 
		
	} // MemberDAO 기본생성자 종료
	
	public boolean verificationPw(String loginId, String inputPw) throws SQLException {
		try {
			// boolean 타입을 반환하는 pw검증 메서드
			String sql = "select pw from member where id = ? and pw = ? and use_yn = 'Y'";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, inputPw);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next() != false) {
				return true ; 
			}else {
				System.out.println("비밀번호가 일치하지 않습니다");
				return false ;
			}
			
		} catch (SQLException e) {
			System.out.println("verificationPw()의 쿼리문을 확인하세요");
			e.printStackTrace();
		}finally {
			resultSet.close();
			preparedStatement.close();
			
		}
		return false;
	}
	

	public boolean verificationId(String inputId) throws SQLException {
		try {
			// id 검증 코드
			// 입력받은 id를 검증하여 일치하는 id가 있으면 T , 일치하는 id가 없으면 F로 반환한다.
			String sql = "select id from member where id =? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, inputId);
			//System.out.println("쿼리 확인 : " + sql);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next() != false ) {
				//System.out.println("일치하는 아이디가 있습니다.");
				return true ; 
			} else {
				System.out.println("일치하는 아이디가 없습니다");
				return false ; 
			}
			
		} catch (SQLException e) {
			System.out.println("verification() 쿼리문을 확인하세요");
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
		}
		
		
		return false;
	}//id 검증 verification()메서드종료

	public void memberAdd(MemberDTO memberDTO) throws SQLException {
		// 회원가입 용메서드 가입용 데이터를 memberDTO로 전달받았다.
		// PreparedStatment : 동적 쿼리문을 사용하여 setter로 입력하겠다.
		
		try {
			String sql = "insert into member(mno, mname, id, pw, memail)"
				      + " values (member_seq.nextval, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql); // sql컴파일 후 반환하여 preparedStatement객체에 넣는다.
			preparedStatement.setString(1, memberDTO.getMname());
			preparedStatement.setString(2, memberDTO.getId());
			preparedStatement.setString(3, memberDTO.getPw());
			preparedStatement.setString(4, memberDTO.getMemail());
			//System.out.println("쿼리 확인 : " + sql);
			result = preparedStatement.executeUpdate() ; //executeUpdate()는 변경된 내용을 정수로 반환한다.
			if(result > 0 ) {
				System.out.println("가입이 완료되었습니다");
				connection.commit();
				
			}else {
				System.out.println("가입에 실패하셨습니다.");
				System.out.println("쿼리 실행 결과 : " + result);
				connection.rollback();
			} // result if-else문 종료
			
			
		} catch (SQLException e) {
			System.out.println("memberDAO memberAdd()의 쿼리문을 확인해주세요.");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
		
	} // 회원가입용 memberAdd()메서드 종료

	public MemberDTO memberLogin(MemberDTO memberDTO) throws SQLException {
		MemberDTO session = new MemberDTO();
		String user = "Y";
		String id ;
		try {
			// loginSession 데이터 반환용 로그인 메서드
			String sql = "select * from member where id = ? and pw = ? and use_yn = 'Y'";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			preparedStatement.setString(2, memberDTO.getPw());
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				session.setMno(resultSet.getInt("mno"));
				session.setMname(resultSet.getString("mname"));
				session.setId(resultSet.getString("id"));
				session.setPw(resultSet.getString("pw"));
				session.setMemail(resultSet.getString("memail"));
				session.setRegidate(resultSet.getDate("regidate"));
				session.setUse_yn("Y");
				id = resultSet.getString("id") ;
						
				if (id.equals("admin")) {
					session.setAdmin("Y");
				}else {
					session.setAdmin("N");
				}
				
			} else {
				System.out.println("로그인에 실패하셨습니다");
			}
			
		} catch (SQLException e) {
			System.out.println("예외발생 : memberLogin()를 확인하세요.");
			e.printStackTrace();
		}finally {
			resultSet.close();
			preparedStatement.close();
		}
		
		return session;
	} //memberLogin()메서드종료

	public void readAll() throws SQLException {
		
		try {
			// 관리자용 readAll member테이블의 전체 정보를 조회한다.
			String sql = "select mno, mname, id, pw, memail, regidate, use_yn from member order by mno";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println("회원번호 : "+resultSet.getInt("mno") +"\t");
				System.out.println("회원이름 : "+resultSet.getString("mname") +"\t");
				System.out.println("회원ID : "+resultSet.getString("id") +"\t");
				System.out.println("회원PW : "+resultSet.getString("pw") +"\t");
				System.out.println("회원메일 : "+resultSet.getString("memail") +"\t");
				System.out.println("가입일자 : "+resultSet.getDate("regidate") +"\t");
				System.out.println("회원상태 : "+resultSet.getString("use_yn").charAt(0) +"\t");
				System.out.println("===================");
			} //while문종료
			
			
		} catch (SQLException e) {
			// SQLException : SQL의 예외 발생시
						System.out.println("readAll()메서드에 쿼리문이 잘못 되었습니다.");
						e.printStackTrace(); // 오류 발생 로그를 출력한다.
		}finally {
			resultSet.close();
			preparedStatement.close();
		}
		
	} // readAll()메서드종료


	
	public void selectAll(MemberDTO loginSession) throws SQLException {
		try {
			// 회원용 정보보기 메서드
			String sql = "select mno, mname, id, pw, memail, regidate from member where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginSession.getId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("===================");
				System.out.println("회원번호 : " + resultSet.getInt("mno") + "\t");
				System.out.println("회원이름 : " + resultSet.getString("mname") + "\t");
				System.out.println("회원ID : " + resultSet.getString("id") + "\t");
				System.out.println("회원PW : " + resultSet.getString("pw") + "\t");
				System.out.println("회원메일 : " + resultSet.getString("memail") + "\t");
				System.out.println("가입일자 : " + resultSet.getDate("regidate") + "\t");

			} 
		} catch (SQLException e) {
			System.out.println("예외발생 : selectAll() 메서드를 확인하세요");
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
			
		}
		
	} //selectAll()종료

	

	public MemberDTO updateOne(MemberDTO loginSession, String values, String modifyStr) throws SQLException {
		// 회원용 정보수정메서드
		//
		try {
			String sql = "update member set "+ values + "= ? where id = ?";
			preparedStatement = connection.prepareStatement(sql) ;
			preparedStatement.setString(1, modifyStr);
			preparedStatement.setString(2, loginSession.getId());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "개의 정보가 수정되었습니다.");
				connection.commit();
			}else {
				System.out.println("정보가 수정되지 않았습니다. 다시 시도해주세요");
				connection.rollback();
			}
			
		} catch (SQLException e) {
			System.out.println("updateOne()를 확인해주세요");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
		
		
		return loginSession;
	} //updateOne()메서드종료

	public void delete(MemberDTO memberDTO) throws SQLException {
		try {
			// 회원탈퇴메서드
			String sql = "delete from member where id= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			result = preparedStatement.executeUpdate();
			
			if (result > 0) {
				System.out.println("회원 삭제가 완료되었습니다.");
				connection.commit();
				
			} else {
				System.out.println("삭제에 실패했습니다");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("delete의 쿼리문을 확인해주세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
			
		}
	} //delete()메서드종료
	
	
	public MemberDTO softDelete(MemberDTO loginSession) throws SQLException {
		try {
			// 회원탈퇴메서드
			// getChar없음 setChar 없음 getString으로 가져온뒤 charAt(0)으로 변환한다.
			char deleted = 'N';
			String sql = "update member set use_yn = ?  where id= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, String.valueOf(deleted));
			preparedStatement.setString(2, loginSession.getId());
			result = preparedStatement.executeUpdate();
			
			if (result > 0) {
				System.out.println("탈퇴가 완료되었습니다.");
				connection.commit();
				
			} else {
				System.out.println("탈퇴에 실패했습니다");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("delete의 쿼리문을 확인해주세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
			
		}
		return loginSession;
	} //delete()메서드종료
	
	
	
	

	public void updateAll(Scanner inputStr) {
		// 관리자용 전체 정보 수정 메서드
		MemberDTO memberDTO = new MemberDTO();
		
		System.out.println("관리자용 DB수정 ");
		System.out.println("수정하실 회원의 ID 입력하세요");
		System.out.print(" : ");
		memberDTO.setId(inputStr.next());
		
		System.out.println("회원이름 : ");
		System.out.println("회원ID : ");
		System.out.println("회원PW : ");
		System.out.println("회원메일 : ");
		System.out.println("가입일자 : ");
		System.out.println("회원상태 : ");
		System.out.println("===================");
		
	}

	
	
	
	
	
	
	
} //MemberDAO class종료
