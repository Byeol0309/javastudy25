package ch01;

import java.util.Scanner;

public class LogicalAndExam {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		System.out.println("사용자의 신장을 입력해주세요 . ");
		System.out.print("입력 : ");
		
		int height = input.nextInt();
		
		if ( (height > 130) && (height < 150)  ) {
			System.out.println("신장 : " + height +"cm " + "파란색으로 "
					+ "이동해주세요. "); 
			// 130 보다 크고 150보다 작은키
		} else if ( (height <= 130) && (height >100) ) { 
			System.out.println("신장 : " + height +"cm " + "이동 전 "
					+ "안전 장치를 받아주세요."); 
			// 130보다 작거나 같고 100보다 큰키 
		} else if ( height >=150  )  {
			System.out.println("신장 150cm 이상은 이용이 제한됩니다." );
			System.out.println("현재 사용자의 신장은 : " + height +" cm 입니다.");
		} else {
			System.out.println("안전상의 이유로 이용이 불가합니다.");
		}

	} // 메인메소드 종료

} // 클래스 종료
