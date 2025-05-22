package ch04;

public class EnumMethodExam {

	public static void main(String[] args) {
		// 2025.05.21
		// 열거 객체의 메소드
		// 객체를 사용하는 방법은 여러개이고, 내장된 함수인 메소드도 사용해봐야함.
		// 열거객체
		// String name()  			: 열거 객체의 문자열을 리턴 
		// int ordinal()			: 열거 객체의 순번을 리턴(0번부터 시작)
		// int compareTo()			: 열거 객체의 순번 차이를 리턴
		// valueOf(String name)		: (열거 타입) 주어진 문자열의 열거 객체를 리턴
		// values()					: (열거 배열) 모든 열거 객체들을 배열로 리턴
		
		// **name() 메서드**
		// 열거 객체가 가지고 있는 문자열을 리턴한다.
		// 이때 리턴되는 문자열은 열거 타입을 정의할때 사용한 상수 이름과 동일하다.
		// Week today = Week.SUNDAY ;
		// String name = today.name(); SUNDAY가 name에 들어간다.
		Week today = Week.WEDNESDAY ;
		String name = today.name();
		System.out.println("객체 이름은 : " + name);
		
		
		// **ordianl() 메서드**
		// 전체 열거 객체중 몇번재 열거 객체인지 알려준다.
		// 순서는 열거 선안할때 첫번째 값이 0이다
		int ordinal = today.ordinal();
		System.out.println("열거 순서는 : " + ordinal);
		
		// **compareTo() 메서드**
		// 매개값으로 주어진 열거 객체를 기준으로, 전후 몇번째에 위치하는지를 기준으로 비교한다.
		// 앞에 있으면 음수, 뒤에 있으면 양수를 리턴한다.
		Week day1 = Week.MONDAY ;
		Week day2 = Week.SUNDAY ;
		int result1 = day1.compareTo(day2); 
		int result2 = day2.compareTo(day1);
		System.out.println(result1);
		System.out.println(result2);
		
		// **valueOf() 메서드**
		// 매개값으로 주어지는 문자열과 동일한 문자열을 가지는 열거 객체를 리턴한다.
		// 외부로부터 문자열을 입력받아 열거 객체로 변환할때 자주 사용한다.
		Week weekday = Week.valueOf("MONDAY");
		if(weekday == Week.SATURDAY || weekday == Week.SUNDAY) {
			System.out.println("주말이군요! 푹쉬고 평일에 힘냅시다!");
		}else {
			System.out.println("평일이군요. 학습을 위해 8시간 이상은 주무세요!");
		}
		
		//**values() 메서드**
		// 열거 타입의 모든 열거 객체들을 배열로 만들어 리턴한다.
		// 향상된 for를 이용한다.
		Week[] days = Week.values() ; // Week의 열거상수를, days 배열로 생성
		for(Week a : days) {
			System.out.println(a +" ");
		}
		
	} // main메서드 종료

} // class 종료
