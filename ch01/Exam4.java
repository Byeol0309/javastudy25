package ch01;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = in.nextLine();
		System.out.println("���̸� �Է��ϼ��� : ");
		String age = in.nextLine();
		System.out.println("�̸����� �Է��ϼ��� : ");
		String email = in.nextLine();
		
		System.out.println(name + "�� ��ŷ ���Ͻ� ���� ���ϵ帳�ϴ�.");
		System.out.println(" ����� ���̰� " + age + "�̱���");
		System.out.println(email + "�ּ� �� ����ϰڽ��ϴ�. �����մϴ�.");
		

	} // ���θ޼ҵ� ����

} // Ŭ���� ����
