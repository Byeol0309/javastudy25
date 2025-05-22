package ch04;

import java.util.Scanner;

public class Member {
	// 2025.05.21
	// java는 객체 지향 프로그래밍 (OOP : Object Oriented Programing) 
	// 객체 : 자신의 속성을 가지고 있는 것 , 식별이 가능한 것   (객체는 속성과 동작으로 이루어져있다)
	// java에서
	// 속성 : 필드
	// 동작 : 메서드 
	// 객체들은 각각 독립적으로 존재하면서 다른 객체와 상호작용하며 동작함.
	//										-> 메소드 (상호작용의 수단)
	// 메서드 호출(도트 연산자를 통해서) : 객체가 다른 객체의 기능을 이용하는것
	// 
	
	//회원용 객체로 main 메서드는 exam에서 진행함.
	// 클래스의 기본 속성 3가지
	// 필드, 생성자, 메서드
	// 필드 : 객체가 가지고 있어야 할 값(변수)
	// 회원번호, id, 성명, 암호, 이메일주소, 집주소, 전화번호 등
	
	//*필드
	public int mno ; 
	public String id ;
	public String pw ;
	
	//*생성자 : Exam클래스의 main메서드에서 new로 호출할때 동작
	public Member( ) {
		 // 기본 생성자 : 클래스명과 같은 메서드
		 // Member member = new Member() ;
		 //				 	=== 생성자. 객체가 생성된다.
	}
	
	
	//*메서드 : member클래스에서 행해지는 동작 CRUD
	public Member memberAdd(Scanner input) { // main에서 Scanner 객체를 전달받음.
		Member member = new Member();
		System.out.println("회원가입 메서드입니다.");
		System.out.println("회원번호를 입력해주세요.");
		System.out.print(">>>");
		member.mno = input.nextInt(); 
		
		System.out.print("id를 입력해주세요 : ");
		member.id = input.next();
		
		System.out.print("pw를 입력해주세요 : ");
		member.pw = input.next();
		
		return member;
		
	} // memberAdd()메서드 종료
	
	public void memberAllList(Member[] members) {
		System.out.println("모든 회원 보기 리스트 메서드입니다.");
		for(int i = 0 ; i <members.length ; i ++) {
			System.out.println("회원번호 : " + members[i].mno);
			System.out.println("회원ID : " + members[i].id);
			System.out.println("회원PW : " + members[i].pw);
			System.out.println("**************************");

		} // for문 종료
	} // memberAllList()메서드 종료
	
	public void memberLogin(Member[] members) {
		Scanner inputStr = new Scanner(System.in);
		boolean loginId = false ;

		System.out.println("로그인 메서드입니다.");
		System.out.println("ID를 입력해주세요");
		System.out.println("ID : ");
		String inputID = inputStr.next();
		
		for (int i = 0 ; i < members.length ; i ++) {  
		 if(inputID.equals(members[i].id)) { // inputID.equals(members[i]) 로 실행하니 -> members[i] 값이 ch04.Member@7a0ac6e3으로 출력됨
			 									//members[i] : Member객체 전체이고 inputID는 문자열이어서
			 									//비교가 맞지 않고 주소 출력이 나온것임. 
			 									// members[i]배열에서 .(도트연산자)로 .id를 호출해야함.
			loginId = true ; 	
			//System.out.println("확인용 입력한 ID" + inputID);
			//System.out.println("확인용 호출된 ID" + members[i].id);
			
			System.out.println("PW를 입력해주세요");
			System.out.println("PW : ");
			String inputPW = inputStr.next();
			
			if (inputPW.equals(members[i].pw)) {
				System.out.println("로그인 완료!");
				System.out.println("**************************");
				return; 
			} else  { 
				System.out.println("PW가 틀렸습니다.");
			} // PW 검증용 if-else문 종료
			return;
		}//id검증 if문 
		}//for문 종료
		if (!loginId) {
			System.out.println("존재하지 않는 ID입니다.");
		}
	} // memberLogin()메서드 종료
	
	public void memberUpdate(Member[] members) {
		Scanner inputInt = new Scanner(System.in);
		Scanner inputStr = new Scanner(System.in);
		boolean loginId = false ;

		System.out.println("회원수정 메서드입니다.");
		System.out.println("회원님의 회원번호를 입력해주세요.");
		System.out.print(">>>");
		int userNum = inputInt.nextInt();
		
		for (int i = 0 ; i < members.length ; i++) {
			if (userNum == members[i].mno) {
				System.out.println("확인용. 입력받은 숫자 " + userNum); //확인용. 입력받은 숫자 5678
				System.out.println("확인용. members[i]" +members[i].mno);
				
				// System.out.println("확인용. members[i]" +members[i]); 확인용. members[i]ch04.Member@7a0ac6e3
				System.out.println("**************************");
				System.out.println("수정하실 항목의 번호를 눌러주세요.");
				System.out.println("1. 회원번호 변경");
				System.out.println("2. 비밀번호 변경");
				System.out.print(">>>");
				int select = inputInt.nextInt();
				switch(select) {
				case 1 :
					System.out.println("회원번호를 변경합니다.");
					System.out.println("변경하실 번호를 입력해주세요");
					System.out.print("변경 번호 :");
					int changeMno = inputInt.nextInt();
					members[i].mno = changeMno ;
					System.out.println("ID :"+members[i].id + "님!");
					System.out.println("회원번호 : " + changeMno + " 로 변경되었습니다.");
					System.out.println("***********");
					
				case 2 :
					System.out.println("비밀번호를 변경합니다.");
					System.out.println("회원님의 ID와 PW를 입력해주세요.");
					
					System.out.println("ID : ");
					String inputID = inputStr.next();
					
					for (i = 0 ; i < members.length ; i ++) {  
					 if(inputID.equals(members[i].id)) { // inputID.equals(members[i]) 로 실행하니 -> members[i] 값이 ch04.Member@7a0ac6e3으로 출력됨
						 									//members[i] : Member객체 전체이고 inputID는 문자열이어서
						 									//비교가 맞지 않고 주소 출력이 나온것임. 
						 									// members[i]배열에서 .(도트연산자)로 .id를 호출해야함.
						loginId = true ; 	
						//System.out.println("확인용 입력한 ID" + inputID);
						//System.out.println("확인용 호출된 ID" + members[i].id);
						
						System.out.println("PW를 입력해주세요");
						System.out.println("PW : ");
						String inputPW = inputStr.next();
						
						if (inputPW.equals(members[i].pw)) {
							System.out.println("변경하실 비밀번호를 입력해주세요.");
							System.out.print("입력 : ");
							String changePw = inputStr.next();
							System.out.println("***확인용 : " +members[i].pw);
						
			
							members[i].pw = changePw ;
							System.out.println("***확인용 : " +changePw);
							System.out.println("***확인용 : " +members[i].pw);
							System.out.println();
							System.out.println("**************************");
							return; 
						} else  { 
							System.out.println("PW가 틀렸습니다.");
						} // PW 검증용 if-else문 종료
						return;
					}//id검증 if문 
					}//for문 종료
					if (!loginId) {
						System.out.println("존재하지 않는 ID입니다.");
					}
					
					
					
				} //회원정보변경 swtich문 종료
				
			} //입력받은 userNum의 값이 members.mno 배열에 있는지 검증 if문 종료
		} //for문 종료
		
	} // memberUpdate()메서드 종료
	
	public void memberDelete() {
		System.out.println("회원탈퇴 메서드입니다.");
	} // memberDelete()메서드 종료

}
