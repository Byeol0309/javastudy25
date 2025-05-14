package ch02;

public class WhiePrintExam {

	public static void main(String[] args) {
		// while문은 조건식이 true일 경우 계속 반복함.
		// 조건식에는 비교 또는 논리 연산식이 주로 옴.
		// 조건식이 false가 되면 반복 행위를 멈추고 while문 종료
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++ ; // 증감식을 꼭 넣어야한다.
			      // 없으면 무한루프
		} //while문 종료

	} //main메서드종료

}//class종료
