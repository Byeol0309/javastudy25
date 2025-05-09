package ch01;

import java.util.Scanner;

public class LogicalExam {

	public static void main(String[] args) {
		
		String gender = "여" ;
		String agreed = "Y" ;
		
		Scanner input = new Scanner(System.in) ;
		System.out.println("성별을 입력해 주세요 한글자로 입력 예) 남, 여 : ");
		String G = input.nextLine();
		System.out.println("입력하신 성별은 : " + G + "입니다." );
		
		System.out.println("동의 여부를 작성해주세요 : ");
		String A = input.nextLine();
		System.out.println("***확인중입니다.");
		
		if((gender.equals(G)) & agreed.equals(A)) {
			System.out.println("참여가 가능합니다");
			System.out.println("신청 완료!!!!!!");
		} else { //if 문에서 else 처리용
			System.out.println("신청이 불가합니다.");
			System.out.println("다시 확인해주세요.");
		}

	
		
		

	} // 메인메소드 종료

} // 클래스 종료
