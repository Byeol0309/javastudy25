package ch01;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = in.nextLine();
		System.out.println("나이를 입력하세요 : ");
		String age = in.nextLine();
		System.out.println("이메일을 입력하세요 : ");
		String email = in.nextLine();
		
		System.out.println(name + "님 해킹 당하신 것을 축하드립니다.");
		System.out.println(" 당신의 나이가 " + age + "이군요");
		System.out.println(email + "주소 잘 사용하겠습니다. 감사합니다.");
		

	} // 메인메소드 종료

} // 클래스 종료
