package ch02;

import java.util.Scanner;

public class IfSsnExam1 {

	public static void main(String[] args) {
		// �ֹε�Ϲ�ȣ�� Ȱ���Ͽ� ����⵵, ����, ���� ���ϱ�
		System.out.println("�� ���� Ȯ���� ���ϽŴٸ�");
		System.out.println("�ֹε�Ϲ�ȣ�� �Է��ϼ���(-����) : ");
		System.out.print(">>>");
		Scanner in = new Scanner(System.in);
		
		String ssn = in.next(); 
		char gender = ssn.charAt(7); //ssn2�� ssn 6��° �ڸ� ���� �̱�. (����)
		// 123456-12345678
		int year = Integer.parseInt(ssn.substring(0, 2)); // ssn���� 1,2��° �ڸ� ���� �̱� (����)
		

		// ���̱��ϱ� 2025-(1900+(year)) 7��°�ڸ�(8)�� 1�Ǵ�2 
		//         2025-(2000+(year)) 7��° �ڸ��� 3�Ǵ�4
		int age ; // (2025-(1990+year));
		
		String gender2 = "" ;
		int ssn2 = Character.getNumericValue(gender) ; // gender�� �� (ssn.charAt(7))���ڸ� int������ ��ȯ
		if (ssn2 %2 == 0) {
			gender2 = "����" ;
		}else {
			gender2 = "����" ;
		} // ���� if else�� ����
		
		int birthYear = 0;
		if (ssn2 == 1 || ssn2 == 2 || ssn2 == 5 || ssn2 == 6) {
			birthYear = 1900 + year ;
		} else if (ssn2 == 3 || ssn2 == 4 || ssn2 == 7 || ssn2 == 8 ) {
			birthYear = 2000 + year ;
		}
		//System.out.println(birthYear);
		// �׽�Ʈ �ȵƴ� ���� ���ڸ��� ��� 2�γ־��� 
		
		
		if (ssn2 == 1 || ssn2 == 2 || ssn2 == 5 || ssn2 == 6) {
			// System.out.println(1900+year);
			age = 2025-birthYear; 
		}else if (ssn2 == 3 || ssn2 == 4 || ssn2 == 7 || ssn2 == 8 ) {
			age = 2025-birthYear;
		} else {
			age = 0; 
			System.out.println("�ٽ� �Է����ּ���.");
		} // ���� if-else�� ����
		
		if (age > 19) {
			System.out.println("�����Դϴ�. Ȯ���� �����մϴ�.");
			System.out.println("============================");
			System.out.println("Ȯ���Ͻðڽ��ϱ�?");
			System.out.println(" 'Y' ��ư�� �����ø� ���α׷��� ����˴ϴ�.");
			System.out.println("=============================");
			System.out.print(">>>>>");
			//Scanner input = new Scanner(System.in);
			char agreed = in.next().charAt(0);
			
			switch(agreed) {
			case 'Y' :
			case 'y' :
				System.out.println("�������� Ȯ���մϴ�.");
				System.out.println("1. ����⵵Ȯ��");
				System.out.println("2. ����Ȯ��");
				System.out.println("3. ����Ȯ��" );
				System.out.print("1~3�Է�>>>");
				int check = in.nextInt();
				
				switch(check) {
				case 1 :
					System.out.println("����⵵ : " + birthYear +"��" );
					break ;
				case 2 : 
					System.out.println("���� : " + age + "��");
					break ;
				case 3 :
					System.out.println("���� : " + gender2);
					break ;
				default :
					System.out.println("1~3���� �Է��ϼ���.");
					System.out.println("���α׷��� �ٽ� �����ϼ���");
				}
			} //switch�� ����
		}else {
			System.out.println("�̼����ڴ� Ȯ���� �Ұ��մϴ�.");
		}
		
		
		//System.out.println("����" + gender + Gender);
		//System.out.println("���� " + year + "���� : " + age);

	} // main �޼��� ����

} // class ����
