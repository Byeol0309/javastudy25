package ch02;

import java.util.Scanner;

public class IfSsnExam1 {

	public static void main(String[] args) {
		// 주민등록번호를 활용하여 출생년도, 성별, 나이 구하기
		System.out.println("내 정보 확인을 원하신다면");
		System.out.println("주민등록번호를 입력하세요(-포함) : ");
		System.out.print(">>>");
		Scanner in = new Scanner(System.in);
		
		String ssn = in.next(); 
		char gender = ssn.charAt(7); //ssn2에 ssn 6번째 자리 문자 뽑기. (성별)
		// 123456-12345678
		int year = Integer.parseInt(ssn.substring(0, 2)); // ssn에서 1,2번째 자리 문자 뽑기 (생년)
		

		// 나이구하기 2025-(1900+(year)) 7번째자리(8)가 1또는2 
		//         2025-(2000+(year)) 7번째 자리가 3또는4
		int age ; // (2025-(1990+year));
		
		String gender2 = "" ;
		int ssn2 = Character.getNumericValue(gender) ; // gender의 값 (ssn.charAt(7))문자를 int형으로 변환
		if (ssn2 %2 == 0) {
			gender2 = "여자" ;
		}else {
			gender2 = "남자" ;
		} // 성별 if else문 종료
		
		int birthYear = 0;
		if (ssn2 == 1 || ssn2 == 2 || ssn2 == 5 || ssn2 == 6) {
			birthYear = 1900 + year ;
		} else if (ssn2 == 3 || ssn2 == 4 || ssn2 == 7 || ssn2 == 8 ) {
			birthYear = 2000 + year ;
		}
		//System.out.println(birthYear);
		// 테스트 안됐던 이유 뒷자리를 계속 2로넣었음 
		
		
		if (ssn2 == 1 || ssn2 == 2 || ssn2 == 5 || ssn2 == 6) {
			// System.out.println(1900+year);
			age = 2025-birthYear; 
		}else if (ssn2 == 3 || ssn2 == 4 || ssn2 == 7 || ssn2 == 8 ) {
			age = 2025-birthYear;
		} else {
			age = 0; 
			System.out.println("다시 입력해주세요.");
		} // 나이 if-else문 종료
		
		if (age > 19) {
			System.out.println("성인입니다. 확인이 가능합니다.");
			System.out.println("============================");
			System.out.println("확인하시겠습니까?");
			System.out.println(" 'Y' 버튼을 누르시면 프로그램이 실행됩니다.");
			System.out.println("=============================");
			System.out.print(">>>>>");
			//Scanner input = new Scanner(System.in);
			char agreed = in.next().charAt(0);
			
			switch(agreed) {
			case 'Y' :
			case 'y' :
				System.out.println("내정보를 확인합니다.");
				System.out.println("1. 출생년도확인");
				System.out.println("2. 나이확인");
				System.out.println("3. 성별확인" );
				System.out.print("1~3입력>>>");
				int check = in.nextInt();
				
				switch(check) {
				case 1 :
					System.out.println("출생년도 : " + birthYear +"년" );
					break ;
				case 2 : 
					System.out.println("나이 : " + age + "세");
					break ;
				case 3 :
					System.out.println("성별 : " + gender2);
					break ;
				default :
					System.out.println("1~3값만 입력하세요.");
					System.out.println("프로그램을 다시 실행하세요");
				}
			} //switch문 종료
		}else {
			System.out.println("미성년자는 확인이 불가합니다.");
		}
		
		
		//System.out.println("성별" + gender + Gender);
		//System.out.println("생년 " + year + "나이 : " + age);

	} // main 메서드 종료

} // class 종료
