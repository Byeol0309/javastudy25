package ch03;

import java.util.Scanner;

public class ArrayScoresExam02 {

	public static void main(String[] args) {
		Scanner mainSC = new Scanner(System.in);
		int select = 0 ;
		System.out.println("초기 작업 : 학생 수를 입력하세요.");
		System.out.print("학생수 :");
		int count = mainSC.nextInt(); //학생수 등록
		String [] names = new String[count] ; // 위에서 입력된 수(count)만큼 학생 이름 테이블 작성
		byte [] kors = new byte[count] ; // 국어 성적 테이블 작성
		byte [] engs = new byte[count] ; // 영어 성적 테이블 작성
		int [] total = new int[count] ; //  총점 성적 테이블 작성
		double [] avgs = new double[count] ; // 평균 테이블 작성
		 
		boolean run = true ; 
		
		while (run) {
			System.out.println("=======MBC 교육센터 성적 관리 프로그램=======");
			System.out.println("1. 학생관리 | 2. 성적관리 | 3. 통계 | 4. 종료");
			System.out.println("======================================");
			System.out.print("번호 입력 :");
			select = mainSC.nextInt(); // 정수 입력 후 분기
			
			switch (select) {
			case 1 -> student(names) ;
			case 2 -> scores(kors, engs, names) ;
			case 3 -> totals(total, kors, engs, names) ;
			case 4 -> {
				System.out.println("성적처리 고생하셨습니다.");
				run = false ; 
			} //
			
			} //switch문종료
			
		}//while문 종료

	} // main메서드종료

	
	static Object totals(int[] total, byte[] kors, byte[] engs, String[] names) {
		// 3. 통계
		return null;
	} // totals 메서드 종료

	static Object scores(byte[] kors, byte[] engs, String[] names) {
		// 2. 성적관리 
		return null;
	} // scores 메서드 종료

	static Object student(String[] names) {
		// 1. 학생관리 
		
		return null;
	}// student 메서드 종료

}// class종료
