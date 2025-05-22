package ch04;

import java.util.Scanner;

public class CarExam {

	public static void main(String[] args) {
		// 2025.05.22
		// class를 사용하여 자동차 실행 프로그램 만들기.
		// 자동차 주 실행 프로그램
			Scanner input = new Scanner(System.in);
			boolean run = true ; 
			System.out.println("***차량 정보입력***");
			Car myCar = new Car();  // 기본생성자로 객체 생성
			// 생성시 속도와 rpm과 오일량은 기본값으로 생성
			System.out.print("제조회사 : ");
			myCar.company = input.next();
			
			System.out.print("모델 : ");
			myCar.model = input.next();
			
			System.out.print("색상 : ");
			myCar.color = input.next();
			
			while (run) {
				// 자동차 주 실행 프로그램
				System.out.println("1. 차량 정보확인");
				System.out.println("2. 차량 시동걸기");
				System.out.println("3. 차량 주행시작");
				System.out.println("4. 차량 주행종료");
				System.out.println("5. 차량 주유하기");
				System.out.print(">>>");
				String select = input.next();
				switch(select) {
				case "1" :
					System.out.println("차랑명 : " + myCar.company);
					System.out.println("모델명 : " + myCar.model);
					System.out.println("색상  : " + myCar.color);
					break ;
				case "2" :
					System.out.println("차량의 시동이 걸렸습니다.");
					myCar.start();
					break ; 
					
				case "3" : // 차량주행시작
					System.out.println("차량이 주행을 시작합니다.");
					myCar.drive();
					break ; 
					
				case "4" : // 차량주행종료
					myCar.stop();
					run = false ; 
					break ;
				case "5" : // 차량주유하기
					myCar.getOil();
				
				} //switch문 종료
			}//while문 종료
	} // main메서드종료

} // class종료
