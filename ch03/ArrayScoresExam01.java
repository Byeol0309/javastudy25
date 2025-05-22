package ch03;

import java.util.Scanner;

public class ArrayScoresExam01 {

	public static void main(String[] args) {
		// 배열을 이용하여 성적표를 만들어보자
		// 학생수를 파악한다
		// 점수를 입력한다.
		// 총점과 평균을 구하여 출력한다.
		Scanner input = new Scanner(System.in);
		System.out.println("======성적표======");
		System.out.println("학생수를 입력하세요 : ");
		System.out.print(">>>");
		int count = input.nextInt();
		
		int[] scores = new int[count]; //키보드로 입력받은 값을 토대로 배열길이 생성
		System.out.println("배열의 길이 :" + scores.length);
		
		for(int i = 0 ; i < scores.length; i++) {
			System.out.println((i+1)+"번째 학생의 점수를 입력하세요.");
			scores[i] = input.nextInt(); 
		} //학생 수만큼 배열에 점수를 입력한다. for문종료
		
		System.out.println("====입력된 점수를 확인합니다=====");
		for(int i = 0 ; i < scores.length; i++) {
			System.out.println((i+1) + "번째 "+scores[i] + " "); // 위에 입력한 점수가 모두 출력된다.
		}
		System.out.println();
		System.out.println("====수정할 번호 입력====");
		int select = input.nextInt();
		System.out.println("====수정할 점수 입력====");
		int score = input.nextInt();
		
		scores[select-1] = score ; 
		System.out.println("수정한 결과를 확인합니다.");
		System.out.println(select + "번의 점수는 :" + score +"로 수정되었습니다.");
		
		//총점과 평균을 구함
		int sum = total(scores);
		System.out.println("총점 :" + sum +"점 입니다.");
		
		double ave = average(sum, count);
		System.out.println("평균 :" + ave +"점 입니다.");
		
	} // main메서드 종료

	
	static double average(int sum, int count) {
		// main 메소드에서 sum, count 값을 가져온 후 
		// 실행문을 처리하여 
		// main 메소드로 보낸다.
		
		double ave = 0 ;
		ave = sum / count ; 
		return ave;
		
	} // average 메서드종료

	
	
	
	static int total(int[] scores) {
		// main메서드에서 scores 배열의 값을 가져와 값의 총 합을 구한다.
		int sum = 0;
		for (int i = 0 ; i < scores.length ; i++) {
			sum += scores[i] ; //scores의 모든 값을 sum에 누적 
		}//scores배열의 값을 모두 가져옴
		
		
		return sum;
	}//total메서드종료

} //class종료
