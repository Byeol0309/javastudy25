package ch02;

import java.util.Scanner;

public class ExSwitchExam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputInt = new Scanner(System.in); // 정수용
		Scanner inputIn = new Scanner(System.in); // 문자용
		boolean run = true ; 
		boolean run2 = true ;
		boolean session = false ; // 로그인 
		boolean session2 = false ; // 성적입력
		boolean session3 = false ;
		int kor = 0 ; 
		int mat = 0 ;
		int eng = 0 ;
		int sci = 0 ;
		int avg = 0 ;
		
		String korGrade = "" ;
		String matGrade = "" ;
		String engGrade = "" ;
		String sciGrade = "" ;
		String id = "김샛별" ;
		String pw = "999999" ;
				
			
			while (run) {
				
				System.out.println("===================");
				System.out.println("   성적 확인 시스템 ");
				System.out.println("===================");
				System.out.println("    1. 로그인  " );
				System.out.println("    2. 성적 입력  " );
				System.out.println("    3. 성적 확인  " );
				System.out.println("    4. 프로그램 종료");
				System.out.print("(1~4) >>>");
				int selectInt2 = inputInt.nextInt(); // 숫자 입력
				
				switch(selectInt2) {
				
				case 1 :
					System.out.println("===================");
					System.out.println(" 로그인을 해주세요.");
					System.out.println("===================");
					session = loginOK(id,pw,session);
					if (session == true) {
						System.out.println("로그인 완료");
					}else if (session == false) {
						System.out.println("로그인 실패");
					}
					run2 = false ;
				
				case 2 :
					System.out.println("===================");
					System.out.println("  성적을 입력해주세요.");
					System.out.println("===================");
					session2 = putOnScore(kor,mat,eng,sci,session2);
				break;
				
				case 3 :
					System.out.println("===================");
					System.out.println("  성적을 확인합니다. ");
					System.out.println("===================");
					session3 = scoreCheak(kor,mat,eng,sci,session3);
					System.out.println(kor + mat + eng + sci);
				break;
				
				case 4 :
					System.out.println("===================");
					System.out.println(" 프로그램이 종료됩니다");
					System.out.println("===================");
				break;
				
				
				} //run2 switch문 종료
		
			//System.out.println();
			}//while2 종료
			 
			
			} // main메서드종료


		

	static boolean scoreCheak(int kor, int mat, int eng, int sci, boolean session3) {
		// 성적 확인용 메서드 생성

		int avg = kor + mat + eng + sci ;
		
		System.out.println("국어 점수: " + kor);
		System.out.println("수학 점수: " + mat);
		System.out.println("영어 점수: " + eng);
		System.out.println("과학 점수: " + sci);
		System.out.println("점수 합계: " + avg);
		System.out.println("점수 평균: " + avg/4);
		return session3;
	}


	static boolean putOnScore(int kor, int mat, int eng, int sci, boolean session2) {
		// 성적 입력용 메서드 생성
		Scanner inputScore = new Scanner(System.in);

		System.out.print("1. 국어 점수 입력 :");
		kor = inputScore.nextInt();
		if (kor < 0 || 100 < kor ) {
			System.out.println("잘못 입력하셨습니다.");
		} // 입력값 검증

		System.out.print("2. 수학 점수 입력 :");
		mat = inputScore.nextInt();
		if (mat < 0 || 100 < mat ) {
			System.out.println("잘못 입력하셨습니다.");
		} // 입력값 검증

		System.out.print("3. 영어 점수 입력 :");
		eng = inputScore.nextInt();
		if (eng < 0 || 100 < eng ) {
			System.out.println("잘못 입력하셨습니다.");
		} // 입력값 검증

		System.out.print("4. 과학 점수 입력 :");
		sci = inputScore.nextInt();
		if (sci < 0 || 100 < sci ) {
			System.out.println("잘못 입력하셨습니다.");
		} // 입력값 검증
		


		return session2;
	}

	static boolean loginOK(String id, String pw, boolean session) {
		// 새로운 메서드에서 id, pw값 검증하기
		Scanner inputLogin = new Scanner(System.in);
		System.out.println("===================");
		System.out.print("이름 : ");
		String inputId = inputLogin.next();
		System.out.println("===================");

		System.out.println("===================");
		System.out.print("생년월일 : ");
		String inputPw = inputLogin.next();
		System.out.println("===================");

		if (id.equals(inputId) && pw.equals(inputPw)) {
			System.out.println(id + "님 로그인 되셨습니다.");
			System.out.println("===================");
			session = true;
		} else {
			System.out.println("로그인에 실패하셨습니다.");
			System.out.println("다시 확인해주세요.");
			System.out.println("===================");
			session = false;
		}

		return session; // session의 true , false값을 리턴함.
	} // loginOK메서드 생성

}// class종료
