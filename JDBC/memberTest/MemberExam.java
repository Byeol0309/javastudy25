package memberTest;

import java.sql.SQLException;
import java.util.Scanner;

import memberTest.dto.MemberDTO;
import memberTest.service.MemberService;

public class MemberExam {
	// 2025.06.13 JDBC memberTest
	// �ʵ�
	public static Scanner inputStr = new Scanner(System.in);
	public static MemberDTO loginSession = null;

	// ������
	
	// �޼���
	public static void main(String[] args) throws SQLException{
		boolean run = true ; 
		
		while (run) {
			System.out.println("===================");
			System.out.println(" MBC ȸ���� ���� �Խ��� ");
			System.out.println("===================");
			System.out.println(" 1 : ȸ�� \n 2 : �Խ���");
			System.out.print("   : ");
			String select = inputStr.next();
			
			switch(select) {
			case "1" :
				System.out.println("===================");
				System.out.println("ȸ���� ���񽺷� �����մϴ�");
				MemberService memberService = new MemberService();
				loginSession = memberService.subMenu(loginSession, inputStr);
				break ;
			case "2" :
				System.out.println("===================");
				System.out.println("�Խ��� ���񽺷� �����մϴ�");
				break ;
			default :
				System.out.println("1�Ǵ� 2��ư�� �����ּ���");
				break ;
			}
			
		} // while������
		
		

	} // main�޼��� ����

} // class ����
