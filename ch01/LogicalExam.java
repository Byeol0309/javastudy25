package ch01;

import java.util.Scanner;

public class LogicalExam {

	public static void main(String[] args) {
		
		String gender = "��" ;
		String agreed = "Y" ;
		
		Scanner input = new Scanner(System.in) ;
		System.out.println("������ �Է��� �ּ��� �ѱ��ڷ� �Է� ��) ��, �� : ");
		String G = input.nextLine();
		System.out.println("�Է��Ͻ� ������ : " + G + "�Դϴ�." );
		
		System.out.println("���� ���θ� �ۼ����ּ��� : ");
		String A = input.nextLine();
		System.out.println("***Ȯ�����Դϴ�.");
		
		if((gender.equals(G)) & agreed.equals(A)) {
			System.out.println("������ �����մϴ�");
			System.out.println("��û �Ϸ�!!!!!!");
		} else { //if ������ else ó����
			System.out.println("��û�� �Ұ��մϴ�.");
			System.out.println("�ٽ� Ȯ�����ּ���.");
		}

	
		
		

	} // ���θ޼ҵ� ����

} // Ŭ���� ����
