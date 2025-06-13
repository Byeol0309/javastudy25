package memberTest.service;

import java.sql.SQLException;
import java.util.Scanner;

import memberTest.dao.MemberDAO;
import memberTest.dto.MemberDTO;

public class MemberService {
	// �ʵ�
	MemberDTO memberDTO = new MemberDTO();
	MemberDAO memberDAO = new MemberDAO();

	public MemberDTO subMenu(MemberDTO loginSession, Scanner inputStr) throws SQLException {
		boolean subRun = true;
		while (subRun) {
			System.out.println("ȸ���� ���� �Դϴ�");
			System.out.println("==================");
			System.out.println("1 : ȸ������");
			System.out.println("2 : �α���");
			System.out.println("3 : ������ȸ");
			System.out.println("4 : ��������");
			System.out.println("5 : ȸ��Ż��");
			System.out.println("6 : �α׾ƿ�");
			System.out.println("7 : ������");
			System.out.print(">>>");
			String subSelect = inputStr.next();
			switch (subSelect) {
			case "1":
				System.out.println("==================\n\tȸ��\n\t����\n==================");
				memberAdd(loginSession,memberDAO, inputStr);
				break;
			case "2":
				System.out.println("==================\n\t�α���\n\t������\n==================");
				loginSession = memberLogin(loginSession,memberDAO,inputStr);
				break;
			case "3":
				System.out.println("==================\n\t������ȸ\n\t������\n==================");
				readAll(loginSession,memberDAO,inputStr);
				break;
			case "4":
				System.out.println("==================\n\t��������\n\t������\n==================");
				loginSession = update(loginSession,memberDAO,inputStr);
				break;
				
			case "5":
				System.out.println("==================\n\tȸ��Ż��\n\t������\n==================");
				loginSession = softDelete(loginSession, memberDAO);
				break;
			case "6":
				System.out.println("==================\n\t�α�\n\t�ƿ�\n==================");
				loginSession = logout(loginSession);
				break;
			case "7":
				System.out.println("==================\n\t����\n\t������\n==================");
				subRun = false;
				break;
			case "7777":
				System.out.println("==================\n\t������\n\t������\n==================");
				loginSession = adminPage(loginSession, memberDAO, inputStr);

				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�");
				break;

			}

		}

		return loginSession;
	} // subMenu()�޼��� ����

	private MemberDTO adminPage(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr ) throws SQLException {
		// �����ڿ� �޼���
		boolean proveAdmin = false ;
		boolean prove = false;
		proveAdmin = proveAdmin(loginSession);
		while (proveAdmin) {
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ����������"); // �����ڿ� ��������
			System.out.println("3. ȸ������");
			System.out.println("4. ������");
			System.out.print(" : ");
			String select = inputStr.next();
			System.out.println("===================");
			switch (select) {
			case "1" :
				System.out.println("");
				memberDAO.readAll();
				break; 
				
			case "2" :
				memberDAO.updateAll(inputStr);
				break; 
				
			case "3" :
				MemberDTO memberDTO = new MemberDTO();
				System.out.println("�����Ͻ� ȸ������ \n  ID�� �Է����ּ���");
				System.out.print("ID : ");
				String inputId = inputStr.next();
						prove = memberDAO.verificationId(inputId);
				if (prove != false) {
					memberDTO.setId(inputId);
					memberDAO.delete(memberDTO);
				}
				proveAdmin = false;
				break; 
			case "4" :
				proveAdmin = false; 
				break; 
			default :
				
				break; 
			}
		}
		return loginSession;
		
	} //adminPage
	
		
	private MemberDTO softDelete(MemberDTO loginSession, MemberDAO memberDAO) throws SQLException {
		// ȸ���� Ż��޼���
		boolean session = false;
		session = session(loginSession);
		while (session) {
			System.out.println("ȸ��Ż��޼���");
			memberDTO = memberDAO.softDelete(loginSession);
			
			//loginSession = memberDAO.delete(loginSession); -- ��¥�� ������ ���� �����ڿ뿡 �־��
			session = false;
		}
		
		return loginSession;
	} //softDelete()�޼�������

	

	private MemberDTO update(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		// ȸ�����������޼���
		boolean session = false; 
		session = session(loginSession);
		String values = null ;
		String modifyStr = null ;
		
		while (session) {
			System.out.println(loginSession.getId() + "�� �������� �������Դϴ�.");
			System.out.println(" 1. �̸�����\n 2. PW���� \n 3. Email����");
			System.out.print(">>>");
			String select = inputStr.next();
			
			switch(select) {
			case "1" :
				values = "mname" ;
				System.out.print("���� ������ �Է����ּ��� \n :");
				modifyStr = inputStr.next();
				loginSession = memberDAO.updateOne(loginSession, values, modifyStr);
				session = false;
				break ;
				
			case "2" :
				values = "pw" ;
				System.out.print("���� ������ �Է����ּ��� \n :");
				modifyStr = inputStr.next();
				loginSession = memberDAO.updateOne(loginSession, values, modifyStr);
				session = false;
				break ;
				
			case "3" :
				values = "memail" ;
				System.out.print("���� ������ �Է����ּ��� \n :");
				modifyStr = inputStr.next();
				loginSession = memberDAO.updateOne(loginSession, values, modifyStr);
				session = false;
				break ;
				
			case "77":
				System.out.println("�����ڿ� �������Դϴ�");
				session = false;
				break ;
				
			default :
				System.out.println("�߸��Է��ϼ̽��ϴ� \n �̸�, PW, Email�� �����Ͻ� �� �ֽ��ϴ�");
				session = false;
				break ;
			
			}
		}
		
		return loginSession;
		
	} //update()�޼�������

	

	

	private void readAll(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		// ������ȸ �޼���
		boolean session = false ;
	
		session = session(loginSession); // �α��λ���Ȯ�ο�޼���
		while (session) { 
			System.out.println(" ������ ��ȸ�մϴ�");
			System.out.println("===================");
			System.out.println(" ȸ�� \t ����");
			memberDAO.selectAll(loginSession);
			session = false ;
		} //while������
		
	} // readAll()�޼�������

	

	private MemberDTO memberLogin(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		// �α��θ޼���
		// id ���� �޼��忡�� ��ġ�ϴ� id�� ������(T��ȯ), -> pw�Է� pw�����޼��忡�� ��ġ�ϴ� pw�� ���� �� T��ȯ 
		// loginSession�� ���ֱ�.
		boolean proveId = true ; 
		boolean provePw = false ;
		MemberDTO memberDTO = new MemberDTO();
		if ( loginSession != null ) {
			System.out.println("���� �α��� �����Դϴ�");
			System.out.println("===================");
			proveId = false ;
		}
		while (proveId) {
			// id��ġ�� proveId�� True��ȯ ���� 
			System.out.println("ID : ");
			String inputId = inputStr.next();
			proveId = memberDAO.verificationId(inputId);
			if (proveId != false) { memberDTO.setId(inputId); }
			
			while (proveId) {
				// id ��ġ�� proveId�� True��ȯ ����
				// id ����ġ�� proveId False��ȯ ����
				System.out.println("PW : ");
				String inputPw = inputStr.next();
				String loginId = memberDTO.getId();
				provePw = memberDAO.verificationPw(loginId, inputPw);
				proveId = false ; // id�Է� while�� ����
				
				if (provePw != false) {
					
					memberDTO.setId(loginId);
					memberDTO.setPw(inputPw);
					//id,pw ��ġ�� loginSession�� ������ ��ȯ�޴´�.
					loginSession = memberDAO.memberLogin(memberDTO);
					if (loginSession != null) {
						System.out.println( loginSession.getId()+" �� �α��� �Ǽ̽��ϴ�.");
						
					}
				}
				
			} // proveId while��
			
		}
		
		
		return loginSession;
	}

	private void memberAdd(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		// ȸ�����Կ�޼���
		MemberDTO memberDTO = new MemberDTO();
		boolean prove = false ; 
		boolean run = true ;

		while(run) {
			System.out.println("�����Ͻ� ȸ������ \n ������ �Է����ּ���");
			System.out.print("ID : ");
			String inputId = inputStr.next();
					prove = memberDAO.verificationId(inputId);
					// DB�� �Է��� ID�� ��ġ�ϴ� ���� �����ϸ� T�� ��ȯ�Ѵ�. / �������� ������ F�� ��ȯ�Ѵ�.
			if (prove != true) {
				//�ߺ�id�� ������ ����
				System.out.println("==================\n\t����������\n\t�Է����ּ���\n==================");
				System.out.print("ID : ");
				memberDTO.setId(inputStr.next());
				System.out.print("PW : ");
				memberDTO.setPw(inputStr.next());
				System.out.print("�̸� : ");
				memberDTO.setMname(inputStr.next());
				System.out.print("Email : ");
				memberDTO.setMemail(inputStr.next());
				memberDTO.setUse_yn("Y");
				memberDTO.setAdmin("N");
				memberDAO.memberAdd(memberDTO);
				run= false ;
				
			} else if (prove = true) {
				run = false ;
				System.out.println("�ߺ��Ǵ� ���̵� �ֽ��ϴ�");
			}
		} // while�� ����
		
	} // memberAdd()�޼�������
	
	
	private boolean session(MemberDTO loginSession) {
		if(loginSession == null) {
			System.out.println("\t�α��� ��\n\t�̿����ּ���\n===================");
			return false ;
		}
		
		return true ;
	} // session�޼�������
	
	private boolean proveAdmin(MemberDTO loginSession) {
		boolean session = false ; 
		session = session(loginSession) ;
		while (session) {
		String ad = "Y" ;
		if(loginSession.getAdmin() == ad) {
			System.out.println("������ ���");
			System.out.println("==================");
			return true ;
		}
		} // while������
		return false ;
	} // session�޼�������
	
	
	
	private MemberDTO logout(MemberDTO loginSession) {
		// �α׾ƿ� �޼���
		boolean session = false ; 
		session = session(loginSession);
		while (session) {
			System.out.println("�α׾ƿ��Ǿ����ϴ�");
			loginSession = null;
			session = false;
		}
		
		
		return loginSession;
	} // logout()�޼�������
	
	

} // class����
