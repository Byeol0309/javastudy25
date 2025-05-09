package ch01;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		System.out.print("키를 입력해주세요 :");
		
		int height = input.nextInt() ;
		if ( (height >= 130)  && (height <=150) ) {
			System.out.println("통과");
		}else {
			System.out.println("죄송합니다.");
		}
	
		
		
	} // 메인메소드 종료

} // 클래스 종료
