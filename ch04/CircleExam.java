package ch04;

public class CircleExam {

	public static void main(String[] args) {
		// 2025.05.22.(목)
		// Circle 클래스를 객체로 받아서 동작하는 메서드
		Circle circle = new Circle(); // 생성자를 통해 객체를 생성
		// 객체는 circle이라는 변수와 연결한다.
		
		circle.name = "김샛별" ; // name필드에 String 값을 넣는다.
		circle.radius = 20 ;   // radius필드에 int 값을 넣는다.
		
		double result = circle.getArea() ; //Circle 객체의 getArea 메서드 실행
		System.out.println("원의 넓이 : " + circle.radius + "는 " + result + "입니다." );
		System.out.println("작성자 :" + circle.name);
		
		// getArea메서드에서 3.14*radius*radius 을 return받았음. 
		// return 3.14*radius*radius ;
		
		
		// 객체 지향 프로그램 개발의 단계
		// 첫번째 단계 : 클래스 설계
		// 두번째 단계 : 설계된 클래스를 가지고 사용할 객체를 생성한다.
		// 세번째 단계 : 생성된 객체를 이용한다.
		
		// 지금까지는 main()이 담긴 클래스만 생성하여 단일 클래스로 구현을 해보았음.
		// main()이 담긴 클래스는 Exam이라는 파일로 생성하고
		// 인스턴스화 될 객체 클래스는 main()없이 생성하여 객체를 사용할 것이다.
		
		int total1 = add(new int[] {70, 80, 90}) ;
		int total2 = add(new int[] {60, 70, 80}) ;
		int total3 = add(new int[] {90, 80, 50}) ;
		System.out.println("1반의 총합 :" + total1);
		System.out.println("2반의 총합 :" + total2);
		System.out.println("3반의 총합 :" + total3);

	} // main 메서드종료

	public static int add(int[] scores) {
		int sum = 0 ;
		for(int i = 0 ; i < 3 ; i++) {
			sum += scores[i] ;
		}
		return sum;
	} //add메서드 종료

} // class종료
