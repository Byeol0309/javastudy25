package ch01;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		System.out.print("Ű�� �Է����ּ��� :");
		
		int height = input.nextInt() ;
		if ( (height >= 130)  && (height <=150) ) {
			System.out.println("���");
		}else {
			System.out.println("�˼��մϴ�.");
		}
	
		
		
	} // ���θ޼ҵ� ����

} // Ŭ���� ����
