package ch05.getter_setter;

import java.util.Scanner;

public class MemberService {
	 // 부메뉴로 DTO를 가지고 CRUD하는 용도
	 // 필드
	 MemberDTO memberDTO = new MemberDTO ();
	
	
	
	 // 생성자
	 
	 

	 // 메서드
	 public void menu() {
		 // memberDTO.name = "" ;
		 // memberDTO.age = 0 ;
		 // memberDTO.admin = true ;
		 // 앞으로 필드 접근은 getter와 setter를 이용하여 할것임.
	 }
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		System.out.print(">>>");
		String name = input.next();
		
		System.out.println("나이를 입력하세요");
		System.out.print(">>>");
		int age = input.nextInt();
		
		System.out.println("관리자 유무를 입력하세요");
		System.out.print(">>>");
		boolean admin = input.nextBoolean();
		
		MemberDTO memberDTO = new MemberDTO();  // 같은 패키지인 경우에는 import가 없다.
		memberDTO.setName(name);
		memberDTO.setAge(age);
		memberDTO.setAdmin(admin);
		System.out.println("객체에 저장된 이름 :" + memberDTO.getName());
		System.out.println("객체에 저장된 나이 : " + memberDTO.getAge());
		System.out.println("객체에 저장된 관리자 : "+ memberDTO.isAdmin());
		
	}
	

}
