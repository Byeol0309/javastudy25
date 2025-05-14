package ch01;

import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		
		double w, h, area ;
		Scanner in = new Scanner(System.in);
		System.out.println("직사각형의 가로 길이를 입력하세요.");
		w = in.nextDouble();
		System.out.println("직사각형의 세로 길이를 입력하세요.");
		h = in.nextDouble();
		area = w * h ;
		System.out.println("직사각형의 넓이는" + area + "입니다.");

	} // 메인메소드 종료

} // 클래스 종료
