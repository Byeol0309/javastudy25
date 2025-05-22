package ch04;

public class Motorcycle { // Motorcycle 클래스를 공용으로 생성함.
	// 2025.05.22(목)
	// 생성자 오버로딩(Overloading)
	// 외부에서 제공되는 데이터를 이용해서 객체를 초기화 하려면 생성자도 다양화 되어야함.
	
	// 기본 객체 생성 :
	// 객체에서 생성할때 외부에서 제공되는 데이터가 없을때
	
	// 생성자 선언 :
	// 외부에서 데이터가 제공될때
	// (ex. model, color)
	//-------------------------------------------
	
	// 필드
	String company = "볼보" ; // 제작회사
	String model ; 		     // 모델
	String color ;		     // 색상
	int maxSpeed ;			 // 최고 속도

	
	// 생성자 (객체 생성시 초기화 역할 담당)
	Motorcycle() { // 기본생성자
		
	}
	
	Motorcycle(String model) { // 모델값만 받는 생성자
		this.model = model ;
	}
	
	Motorcycle(String model, String color) { // 모델과 색상정보를 받는 생성자
		this.model = model ;
		this.color = color ;
	}
	
	Motorcycle(String model, String color, int maxSpeed) { // 모델과 색상정보, 속도정보를 받는 생성자
		this.model = model ;
		this.color = color ;
		this.maxSpeed = maxSpeed ;
	}
	
	
	
	//

}
