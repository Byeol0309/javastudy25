package ch04;

import java.util.Calendar;

public class EnumWeekExam {

	public static void main(String[] args) {
		// 2025.05.21 
		// Calendar를 사용하여 요일 계산해보기.
		// Java에 내장된 객체를 불러와 요일을 출력해본다.
		
		// Calendar now = Calendar.getInstance();
		// Calendar 타입의 now 변수에, Calendar Instance를 연결한다.
		// int year = now.get(Calendar.YEAR);
		
		Week today = null ; // Week 타입에 today변수를 선언하고, 연결은 나중에 하겠다.
		
		Calendar cal = Calendar.getInstance();    // Calendar Instance를  Calendar타입 변수 cal에 연결(넣는다)
		int year = cal.get(Calendar.YEAR) ;		  // Calendar 타입의 객체에서 YEAR(연도)를 가져온다.
		int month = cal.get(Calendar.MONTH)+ 1 ;  // Calendar 타입의 객체에서 MONTH(월)을 가져온다. 
												  // 컴퓨터는 0이 시작이기 때문에 +1을 해주어야함.
		int day = cal.get(Calendar.DAY_OF_MONTH); // 1달의 일수가 계산.
		int week = cal.get(Calendar.DAY_OF_WEEK); // 요일을 숫자로 출력, 일요일이 1
		
		switch(week) {
		case 1 :
			today = Week.SUNDAY ; break; 
		  // today변수에   Week(이뮴객체)에서 가져온 . SUNDAY(값)를 넣는다. 
		case 2 :
			today = Week.MONDAY ; break ;
		case 3 :
			today = Week.TUESDAY ; break ;
		case 4 :
			today = Week.WEDNESDAY ; break ;
		case 5 :
			today = Week.THURSDAY ; break ;
		case 6 :
			today = Week.FRIDAY ; break ;
		case 7 :
			today = Week.SATURDAY ; break ;
		}
		System.out.println("현재 날짜는 " + year + "년 " + month + "월 " + day +"일 (" + today +")입니다.");
		
		int hour = cal.get(Calendar.HOUR) ;		 // 시간 int 타입의 hour 변수에, Calendar객체에서 가져온 HOUR값을 넣는다.
		int minute = cal.get(Calendar.MINUTE) ;  // 분
		int second = cal.get(Calendar.SECOND) ;  // 초
		System.out.println("현재 시간은 " + hour + "시 " + minute +"분 " + second +"초 입니다.");
	} // main메서드 종료

} // class종료
