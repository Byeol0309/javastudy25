package ch01;

import java.util.Scanner;

public class Exam3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("************");
		System.out.print("�̸� : ");
		String name = input.next();  // ���ڿ� �Է¿� 
		
		System.out.print("���� : ");
		int age = input.nextInt(); // ���� �Է¿�
		
		System.out.print("��� : ");
		double ave = input.nextDouble(); // �Ǽ� �Է¿�
		
		System.out.printf("���� ����� �̸��� %s\n ����� ���̴� %d\n ����� %5.2f\n �Դϴ�.", name, age, ave);

	} // ���θ޼ҵ� ����

} // Ŭ���� ����
