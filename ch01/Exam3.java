package ch01;

import java.util.Scanner;

public class Exam3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("************");
		System.out.print("이름 : ");
		String name = input.next();  // 문자열 입력용 
		
		System.out.print("나이 : ");
		int age = input.nextInt(); // 정수 입력용
		
		System.out.print("평균 : ");
		double ave = input.nextDouble(); // 실수 입력용
		
		System.out.printf("현재 당신의 이름은 %s\n 당신의 나이는 %d\n 평균은 %5.2f\n 입니다.", name, age, ave);

	} // 메인메소드 종료

} // 클래스 종료
