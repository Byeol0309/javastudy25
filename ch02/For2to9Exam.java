package ch02;

public class For2to9Exam {

	public static void main(String[] args) {
		// 구구단 프로그램 작성
		// 변수 m은 2~9까지 증가하여 단을 생성한다. (바깥쪽 for)
		// 변수 n은 1~9까지 증가하여 곱셈을 완성한다. (안쪽 for)
		
		for (int m = 2 ; m <= 9 ; m++ ) {
			System.out.println("====" + m + "단====");
			
			for (int n = 1 ; n <= 9 ; n++) {
				System.out.println( m + "X" + n + " = "+ (m*n));
			}//안쪽 for문
		} // 바깥쪽 for문

	}//main메서드종료

}//class 종료
