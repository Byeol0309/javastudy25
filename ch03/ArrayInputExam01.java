package ch03;

import java.util.Scanner;

public class ArrayInputExam01 {

	public static void main(String[] args) {
		// 키보드로 입력받은 값을 배열에 저장 후 CRUD 테스트
		// C 성적을 입력
		// R 성적을 보기 (전체보기, 1개보기)
		// U 성적을 수정
		// D 성적을 삭제
		// 개선사항 -> 성적 입력 시 null 값을 보고 넣어보기

		Scanner inputInt = new Scanner(System.in);
		System.out.println("====================");
		System.out.println("성적처리시스템에 입장하셨습니다.");
		System.out.println("학생의 숫자를 입력해주세요.");
		System.out.print("숫자 입력 :");
		int count = inputInt.nextInt(); // count에 입력된 값을 넣는다.
		System.out.println("====================");
		System.out.println("학생 " + count + "명의 성적을 입력하겠습니다.");
		String[] names = new String[count]; // 이름 배열
		int[] kors = new int[count]; // 국어점수 배열
		int[] mats = new int[count]; // 수학점수 배열
		int[] engs = new int[count]; // 영어점수 배열
		// 국어, 영어, 수학 점수의 배열을 입력한 학생 명수만큼 만든다.

		boolean run = true;
		while (run) {
			System.out.println("=======성적처리=======");
			System.out.println("1. 성적입력");
			System.out.println("2. 전체성적보기");
			System.out.println("3. 개인성적보기");
			System.out.println("4. 성적수정하기");
			System.out.println("5. 성적삭제하기");
			System.out.println("0.성적프로그램종료");
			System.out.println("(1 ~ 5) (종료 0)");
			System.out.print("입력 :");
			int select = inputInt.nextInt();

			switch (select) {
			case 1:
				System.out.println("성적입력화면입니다.");
				// 메서드를 생성할때는 입력값과 출력값을 먼저 생각해야한다.
				scoreAdd(names, kors, mats, engs);

				break;

			case 2:
				System.out.println("====================");
				System.out.println("전체성적보기화면입니다.");
				scoreAll(names, kors, mats, engs);

				break;

			case 3:
				System.out.println("====================");
				System.out.println("개인성적보기화면입니다.");
				scoreCheck(names, kors, mats, engs);

				break;

			case 4:
				System.out.println("====================");
				System.out.println("성적수정화면입니다.");
				scoreMod(names, kors, mats, engs);
				break;

			case 5:
				System.out.println("====================");
				System.out.println("성적삭제화면입니다.");
				scoreDelet(names, kors, mats, engs);
				break;

			case 0:
				System.out.println("====================");
				System.out.println("   프로그램이 종료됩니다.");
				System.out.println("====================");
				run = false ;
				break;

			} // switch문 종료

		} // 성적처리 메뉴 while문 종료

	} // main메서드종료

	static void scoreDelet(String[] names, int[] kors, int[] mats, int[] engs) {
		// main에서 만든 배열 4개를 가져와 성적을 수정한다.
		
	} // 성적 삭제용 scoreDelet메서드 종료 // null;값으로 변경하기

	static void scoreMod(String[] names, int[] kors, int[] mats, int[] engs) {
		// main에서 만든 배열 4개를 가져와 성적을 수정한다.
		Scanner inputStr = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		
		System.out.println("====================");
		System.out.println("수정할 학생의 이름을 입력하세요.");
		System.out.print("이름 :");
		String name = inputStr.nextLine();
		System.out.println("====================");
		
		for(int i = 0 ; i < names.length ; i ++)  {
			if (names[i].equals(name)) {
				// 키보드로 입력한 값 (name)이 배열에 같은 값이 있는지 파악
				System.out.println( names[i]+ " 님의 점수를 확인하세요.");
				
				System.out.println("국어 :" + kors[i]);
				System.out.println("수학 :" + mats[i]);
				System.out.println("영어 :" + engs[i]);
				System.out.println("=====================");
				System.out.println("수정하실 점수를 입력하세요");
				System.out.print("국어 수정 점수 :");
				kors[i] = inputInt.nextInt();
				
				System.out.print("수학 수정 점수 :");
				mats[i] = inputInt.nextInt();
				
				System.out.print("영어 수정 점수 :");
				engs[i] = inputInt.nextInt();
				System.out.println("=====================");
				System.out.println("수정된 점수를 확인하세요.");
				System.out.println("국어 :" + kors[i] );
				System.out.println("수학 :" + mats[i] );
				System.out.println("영어 :" + engs[i] );
				break ;
				
			} //if문 
		} //for문 종료


	}// scoreMod 성적수정 메소드종료

	static void scoreCheck(String[] names, int[] kors, int[] mats, int[] engs) {
		// main에서 만든 배열 4개를 가져와 성적을 확인한다.
		Scanner inputStr = new Scanner(System.in);

		System.out.println("====================");
		System.out.println("확인하실 이름을 입력해주세요");
		System.out.print("이름 :");
		String name = inputStr.nextLine();

		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name)) {
				System.out.println("국어 :" + kors[i]);
				System.out.println("수학 :" + mats[i]);
				System.out.println("영어 :" + engs[i]);
			} // 키보드로 입력한 name변수의 입력값과 names배열 들어있는 인덱스값이 같으면 실행
		} // for문 종료

	}// scoreCheck 개인성적보기메소드종료

	static void scoreAll(String[] names, int[] kors, int[] mats, int[] engs) {
		// main에서 만든 배열 4개를 가져와 성적을 확인한다.
		System.out.println("====================");

		for (int i = 0; i < names.length; i++) {
			System.out.println("이름 :" + names[i]);
			System.out.println("국어 :" + kors[i] + "점");
			System.out.println("수학 :" + mats[i] + "점");
			System.out.println("영어 :" + engs[i] + "점");

		}

		// System.out.println("이름");
	} // scoreAll 메서드종료

	static void scoreAdd(String[] names, int[] kors, int[] mats, int[] engs) {
		// main에서 만든 배열 4개를 가져와 성적을 입력한다.
		Scanner inputStr = new Scanner(System.in); // inputStr
		Scanner inputInt = new Scanner(System.in); // inputInt

		for (int i = 0; i < names.length; i++) {
			System.out.println("====================");
			System.out.println("학생의 이름을 입력하세요.");
			System.out.print("이름 :");
			names[i] = inputStr.next(); // 키보드로 입력된 값을 names배열 i인덱스에 넣는다.

			System.out.print("국어 :");
			kors[i] = inputInt.nextInt(); // 키보드로 입력된 값을 kors배열 i인덱스에 넣는다.

			System.out.print("수학 :");
			mats[i] = inputInt.nextInt(); // 키보드로 입력된 값을 mats배열 i인덱스에 넣는다.

			System.out.print("영어 :");
			engs[i] = inputInt.nextInt(); // 키보드로 입력된 값을 engs배열 i인덱스에 넣는다.

		} // 반복성적입력for문 종료
		System.out.println("성적 입력이 완료되었습니다.");
	} // 성적입력 scoreAdd메서드종료

}// class 종료
