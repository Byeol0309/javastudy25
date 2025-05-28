package ch05.extended.phone;

public class DmbCellPhoneExam {
	// 2025.05.28(수)
	// 상속 Inheritance
	// 자식 클래스의 객체를 생성하여 테스트를 진행해본다.
	
	// 필드
	
	
	// 생성자
	
	
	//메서드
	public static void main(String[] args) {
		// CellPhone (부모클래스) // DmbCellPhone (자식클래스)
		// DmbCellPhone 클래스(자식클래스)의 생성자를 통해 객체를 생성함.
		// 자식객체를 생성하면, 부모객체가 먼저 생성 -> 자식객체 생성됨.
		// 자식객체가 생성될때 자식 생성자의 맨 첫줄에서 호출됨.
		
		
		// DmbCellPhone (String model, String color, int channel) { } // 사용자정의생성자
		DmbCellPhone dmbPhone = new DmbCellPhone("디엠비폰", "빨강", 10);
		// 생성자로 초기값을 전달한다. (모델명, 색상, 채널번호)
		
		System.out.println("모델 :" + dmbPhone.model);
		System.out.println("색상 :" + dmbPhone.color);
		// 부모로부터 받은 필드를 활용하여 출력
		
		System.out.println("채널번호 :" + dmbPhone.channel);
		// 자식 필드를 활용하여 출력
		System.out.println("----------------------------");
		
		// 전화에 대한 부모 메서드 활용
		dmbPhone.powerOn(); 
		//전원을 켭니다
		
		dmbPhone.bell();
		// 전화벨이 울립니다.
		
		dmbPhone.sendVoice("여보세요");
		dmbPhone.receiveVoice("누구세요?");
		dmbPhone.sendVoice("차빼주세요");
		dmbPhone.receiveVoice("???????????????");
		dmbPhone.sendVoice("테스트였습니다.");
		//전화종료
		dmbPhone.hangup();
		System.out.println("----------------------------");
		
		//dmb에 대한 자식 메서드를 활용
		//dmb전원을 켭니다.
		dmbPhone.turnOnDmb();
		
		//채널 변경함.
		dmbPhone.changeChannelDmb(12);
		
		//dmb 전원을 끕니다.
		dmbPhone.turnOffDmb();
		
		
	} // main메서드종료

}// class종료
