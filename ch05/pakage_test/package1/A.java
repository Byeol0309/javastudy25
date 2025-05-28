package ch05.pakage_test.package1;
	//2025.05.26 
	// 생성자 접근 제한
	// public    : 모든 패키지에서 아무런 제한 없이
	// protected : 같은 패키지에 속하는 클래스에서 생성자를 호출
	// default   : 생성자 선언시 접근제한자를 생략하면, 같은 패키지에서는 제한 없이 생성자 호출 가능 ( 다른 패키지에서는 불가 )
	// private   : 동일 패키지, 다른 패키지 모두 호출하지 못하도록 제한
public class A {
		B b ; // B class에 접근제한자는 public으로 가능
		
		A a1 = new A(true) ;	// public 용  
		A a2 = new A(1) ;		// default용
		A a3 = new A("문자열");	// private 용
	
	// 생산자 오버로딩
	public A(boolean b) {  	// public 공용 생성자
			// new A(true)
		}
	
	A(int b) {				// 접근 제한자 생략 -> 디폴트 접근제한자
			// new A(1)
	}
	
	private A(String s) {   // private -> 개인적인 생성자
			// new A("문자열")
	}

}
