package ch04;

import java.util.Calendar;

public class EnumWeekExma01 {

	public static void main(String[] args) {
		// 2025.05.21
		// Calender와 Week를 사용한 동등비교.
		// 요일을 매칭하여 학습목표를 출력해본다.
		// 이뮴타입은 객체 1개를 사용해서 주소를 연결하기때문에 
		// == 동등연산이 가능하다.
		
		Week today = null ;  // Week(이뮴) 타입의 today 변수 = null(빈값) ;
		Calendar cal = Calendar.getInstance() ; 
		
		int week = cal.get(Calendar.DAY_OF_WEEK) ;
		
		//int week = cal.DAY_OF_WEEK ;    
		// 	  		 Calendar 객체의 DAY_OF_WEEK의 상수값을 불러내게됨 
		// 						   DAY_OF_WEEK 자체는 정수 상수값 7을 가지고 있음. -> 7 출력
		//    week = cal.get(Calendar.DAY_OF_WEEK) ;
		//		     Calendar 객체의 DAY_OF_WEEK의 현재 값을 불러내게됨.
		//						   DAY_OF_WEEK은 요일을 1~7으로 출력. 오늘의 요일은 수요일 -> 4 출력

		// 요일별 스케쥴 출력해보기
		switch (week) {
		case 1:
			today = Week.SUNDAY ; break;
		case 2:
			today = Week.MONDAY ; break;
		case 3:
			today = Week.TUESDAY; break;
		case 4:
			today = Week.WEDNESDAY; break;
		case 5:
			today = Week.THURSDAY; break;
		case 6:
			today = Week.FRIDAY; break;
		case 7:
			today = Week.SATURDAY; break;
		}
		if (today == Week.SUNDAY) {
			System.out.println("일요일은 내가 짜파게티 요리사");
		}else if (today == Week.MONDAY) {
			System.out.println("월요일입니다 오늘은 : 마트에 갑니다.");
		}else if (today == Week.TUESDAY) {
			System.out.println("화요일입니다 오늘은 : 운동을 합니다.");
		}else if (today == Week.WEDNESDAY) {
			System.out.println("수요일입니다 오늘은 : 분리수거 하는날.");
		}else if (today == Week.THURSDAY) {
			System.out.println("목요일입니다 오늘은 : 자바공부를 합니다.");
		}else if (today == Week.FRIDAY) {
			System.out.println("금요일입니다 오늘은 : 맛있는 음식 먹는날.");
		}else if (today == Week.SATURDAY) {
			System.out.println("토요일입니다. 오늘은 : 더 맛있는 음식 먹는날.");
		}
	} // main 메서드 종료

} // class 종료
