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
	// �ʵ�
	public MemberDTO memberDTO = new MemberDTO();
	public Connection connection = null;
	public Statement statement = null; 
	public PreparedStatement preparedStatement = null ;
	public ResultSet resultSet = null ;
	public int result = 0 ;
	
	// �⺻������
	public MemberDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.163:1521:xe", "membertest",
					"membertest");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �̸��̳�, ojdbc6.jar ������ �߸��Ǿ����ϴ�.");
			e.printStackTrace();
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("url, id, pw�� �߸��Ǿ����ϴ�. MemberDAO�� �⺻�����ڸ� Ȯ���ϼ���");
			e.printStackTrace();
			System.exit(0);
		} 
		
	} // MemberDAO �⺻������ ����
	
	public boolean verificationPw(String loginId, String inputPw) throws SQLException {
		try {
			// boolean Ÿ���� ��ȯ�ϴ� pw���� �޼���
			String sql = "select pw from member where id = ? and pw = ? and use_yn = 'Y'";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, inputPw);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next() != false) {
				return true ; 
			}else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
				return false ;
			}
			
		} catch (SQLException e) {
			System.out.println("verificationPw()�� �������� Ȯ���ϼ���");
			e.printStackTrace();
		}finally {
			resultSet.close();
			preparedStatement.close();
			
		}
		return false;
	}
	

	public boolean verificationId(String inputId) throws SQLException {
		try {
			// id ���� �ڵ�
			// �Է¹��� id�� �����Ͽ� ��ġ�ϴ� id�� ������ T , ��ġ�ϴ� id�� ������ F�� ��ȯ�Ѵ�.
			String sql = "select id from member where id =? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, inputId);
			//System.out.println("���� Ȯ�� : " + sql);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next() != false ) {
				//System.out.println("��ġ�ϴ� ���̵� �ֽ��ϴ�.");
				return true ; 
			} else {
				System.out.println("��ġ�ϴ� ���̵� �����ϴ�");
				return false ; 
			}
			
		} catch (SQLException e) {
			System.out.println("verification() �������� Ȯ���ϼ���");
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
		}
		
		
		return false;
	}//id ���� verification()�޼�������

	public void memberAdd(MemberDTO memberDTO) throws SQLException {
		// ȸ������ ��޼��� ���Կ� �����͸� memberDTO�� ���޹޾Ҵ�.
		// PreparedStatment : ���� �������� ����Ͽ� setter�� �Է��ϰڴ�.
		
		try {
			String sql = "insert into member(mno, mname, id, pw, memail)"
				      + " values (member_seq.nextval, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql); // sql������ �� ��ȯ�Ͽ� preparedStatement��ü�� �ִ´�.
			preparedStatement.setString(1, memberDTO.getMname());
			preparedStatement.setString(2, memberDTO.getId());
			preparedStatement.setString(3, memberDTO.getPw());
			preparedStatement.setString(4, memberDTO.getMemail());
			//System.out.println("���� Ȯ�� : " + sql);
			result = preparedStatement.executeUpdate() ; //executeUpdate()�� ����� ������ ������ ��ȯ�Ѵ�.
			if(result > 0 ) {
				System.out.println("������ �Ϸ�Ǿ����ϴ�");
				connection.commit();
				
			}else {
				System.out.println("���Կ� �����ϼ̽��ϴ�.");
				System.out.println("���� ���� ��� : " + result);
				connection.rollback();
			} // result if-else�� ����
			
			
		} catch (SQLException e) {
			System.out.println("memberDAO memberAdd()�� �������� Ȯ�����ּ���.");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
		
	} // ȸ�����Կ� memberAdd()�޼��� ����

	public MemberDTO memberLogin(MemberDTO memberDTO) throws SQLException {
		MemberDTO session = new MemberDTO();
		String user = "Y";
		String id ;
		try {
			// loginSession ������ ��ȯ�� �α��� �޼���
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
				System.out.println("�α��ο� �����ϼ̽��ϴ�");
			}
			
		} catch (SQLException e) {
			System.out.println("���ܹ߻� : memberLogin()�� Ȯ���ϼ���.");
			e.printStackTrace();
		}finally {
			resultSet.close();
			preparedStatement.close();
		}
		
		return session;
	} //memberLogin()�޼�������

	public void readAll() throws SQLException {
		
		try {
			// �����ڿ� readAll member���̺��� ��ü ������ ��ȸ�Ѵ�.
			String sql = "select mno, mname, id, pw, memail, regidate, use_yn from member order by mno";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println("ȸ����ȣ : "+resultSet.getInt("mno") +"\t");
				System.out.println("ȸ���̸� : "+resultSet.getString("mname") +"\t");
				System.out.println("ȸ��ID : "+resultSet.getString("id") +"\t");
				System.out.println("ȸ��PW : "+resultSet.getString("pw") +"\t");
				System.out.println("ȸ������ : "+resultSet.getString("memail") +"\t");
				System.out.println("�������� : "+resultSet.getDate("regidate") +"\t");
				System.out.println("ȸ������ : "+resultSet.getString("use_yn").charAt(0) +"\t");
				System.out.println("===================");
			} //while������
			
			
		} catch (SQLException e) {
			// SQLException : SQL�� ���� �߻���
						System.out.println("readAll()�޼��忡 �������� �߸� �Ǿ����ϴ�.");
						e.printStackTrace(); // ���� �߻� �α׸� ����Ѵ�.
		}finally {
			resultSet.close();
			preparedStatement.close();
		}
		
	} // readAll()�޼�������


	
	public void selectAll(MemberDTO loginSession) throws SQLException {
		try {
			// ȸ���� �������� �޼���
			String sql = "select mno, mname, id, pw, memail, regidate from member where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginSession.getId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("===================");
				System.out.println("ȸ����ȣ : " + resultSet.getInt("mno") + "\t");
				System.out.println("ȸ���̸� : " + resultSet.getString("mname") + "\t");
				System.out.println("ȸ��ID : " + resultSet.getString("id") + "\t");
				System.out.println("ȸ��PW : " + resultSet.getString("pw") + "\t");
				System.out.println("ȸ������ : " + resultSet.getString("memail") + "\t");
				System.out.println("�������� : " + resultSet.getDate("regidate") + "\t");

			} 
		} catch (SQLException e) {
			System.out.println("���ܹ߻� : selectAll() �޼��带 Ȯ���ϼ���");
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
			
		}
		
	} //selectAll()����

	

	public MemberDTO updateOne(MemberDTO loginSession, String values, String modifyStr) throws SQLException {
		// ȸ���� ���������޼���
		//
		try {
			String sql = "update member set "+ values + "= ? where id = ?";
			preparedStatement = connection.prepareStatement(sql) ;
			preparedStatement.setString(1, modifyStr);
			preparedStatement.setString(2, loginSession.getId());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "���� ������ �����Ǿ����ϴ�.");
				connection.commit();
			}else {
				System.out.println("������ �������� �ʾҽ��ϴ�. �ٽ� �õ����ּ���");
				connection.rollback();
			}
			
		} catch (SQLException e) {
			System.out.println("updateOne()�� Ȯ�����ּ���");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
		
		
		return loginSession;
	} //updateOne()�޼�������

	public void delete(MemberDTO memberDTO) throws SQLException {
		try {
			// ȸ��Ż��޼���
			String sql = "delete from member where id= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			result = preparedStatement.executeUpdate();
			
			if (result > 0) {
				System.out.println("ȸ�� ������ �Ϸ�Ǿ����ϴ�.");
				connection.commit();
				
			} else {
				System.out.println("������ �����߽��ϴ�");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("delete�� �������� Ȯ�����ּ���.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
			
		}
	} //delete()�޼�������
	
	
	public MemberDTO softDelete(MemberDTO loginSession) throws SQLException {
		try {
			// ȸ��Ż��޼���
			// getChar���� setChar ���� getString���� �����µ� charAt(0)���� ��ȯ�Ѵ�.
			char deleted = 'N';
			String sql = "update member set use_yn = ?  where id= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, String.valueOf(deleted));
			preparedStatement.setString(2, loginSession.getId());
			result = preparedStatement.executeUpdate();
			
			if (result > 0) {
				System.out.println("Ż�� �Ϸ�Ǿ����ϴ�.");
				connection.commit();
				
			} else {
				System.out.println("Ż�� �����߽��ϴ�");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("delete�� �������� Ȯ�����ּ���.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
			
		}
		return loginSession;
	} //delete()�޼�������
	
	
	
	

	public void updateAll(Scanner inputStr) {
		// �����ڿ� ��ü ���� ���� �޼���
		MemberDTO memberDTO = new MemberDTO();
		
		System.out.println("�����ڿ� DB���� ");
		System.out.println("�����Ͻ� ȸ���� ID �Է��ϼ���");
		System.out.print(" : ");
		memberDTO.setId(inputStr.next());
		
		System.out.println("ȸ���̸� : ");
		System.out.println("ȸ��ID : ");
		System.out.println("ȸ��PW : ");
		System.out.println("ȸ������ : ");
		System.out.println("�������� : ");
		System.out.println("ȸ������ : ");
		System.out.println("===================");
		
	}

	
	
	
	
	
	
	
} //MemberDAO class����
