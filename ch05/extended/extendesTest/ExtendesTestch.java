package ch05.extended.extendesTest;

public class ExtendesTestch extends ExtendsTest { // ExtendsTest를 부모로 하는 자식클래스
	// 2025.05.28(수)
	// 상속(Inheritance) , 잘 개발된 클래스를 재사용하여 코드의 중복을 줄여준다.
	// 클래스명 뒤에 // extends 부모클래스명 // 을 기입하여 상속을 진행함.
	// 부모클래스의 멤버를 자식클래스에게 물려줄수있다. 다중상속은 불가능함.
	// 부모클래스 : 상위클래스
	// 자식클래스 : 하위클래스, 파생클래스
	
	// 상속을 해도 부모클래스의 모든 필드와 메소드를 물려받지는 않음
	// private(getter,setter활용해야함.) , default(부모와 자식클래스가 다른 패키지일경우.)
	
	
	//필드
	int field2 ;
	
	
	//생성자
	
	
	// 메서드
	void method2() {
		// 실행문
	}// 메서드종료

	public static void main(String[] args) {
		ExtendesTestch b = new ExtendesTestch(); //
		b.field1 = 10 ;  // 부모클래스
		b.method1();  	 // 부모클래스
		
		b.field2 = 20 ; // 자식클래스
		b.method2();    // 자식클래스
	} // main메서드종료 

} // 자식클래스로 부모객체를 활용한다. class종료
