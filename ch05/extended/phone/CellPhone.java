package ch05.extended.phone;

public class CellPhone { // 부모클래스
	// 2025.05.28(수)
	// 상속 Inheritance
	// 부모클래스 : 기본적인 필드와 메서드 제공
	
	// 필드 (부모필드)
	String model ;
	String color ; 
	
	
	//생성자 (디폴트로 활용)
	
	//메서드 // void 앞에 생략, 아무것도 안적으면 default임
		   // default : 같은 패키지로 구성된 클래스만 허용
	void powerOn() {System.out.println("전원을 켭니다.");}
	void powerOff() {System.out.println("전원을 끕니다.");};
	void bell () {System.out.println("벨이 울립니다.");};
	void sendVoice (String message) {System.out.println("자기 :" + message);};
	void receiveVoice (String message) {System.out.println("상대방 :"+ message);};
	void hangup() {System.out.println("전화를 끊습니다.");};
	
}
