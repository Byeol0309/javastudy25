package ch01;

import java.util.Scanner;

public class LogicalAndExam {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		System.out.println("������� ������ �Է����ּ��� . ");
		System.out.print("�Է� : ");
		
		int height = input.nextInt();
		
		if ( (height > 130) && (height < 150)  ) {
			System.out.println("���� : " + height +"cm " + "�Ķ������� "
					+ "�̵����ּ���. "); 
			// 130 ���� ũ�� 150���� ����Ű
		} else if ( (height <= 130) && (height >100) ) { 
			System.out.println("���� : " + height +"cm " + "�̵� �� "
					+ "���� ��ġ�� �޾��ּ���."); 
			// 130���� �۰ų� ���� 100���� ūŰ 
		} else if ( height >=150  )  {
			System.out.println("���� 150cm �̻��� �̿��� ���ѵ˴ϴ�." );
			System.out.println("���� ������� ������ : " + height +" cm �Դϴ�.");
		} else {
			System.out.println("�������� ������ �̿��� �Ұ��մϴ�.");
		}

	} // ���θ޼ҵ� ����

} // Ŭ���� ����
