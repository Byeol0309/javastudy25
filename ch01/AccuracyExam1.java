package ch01;

public class AccuracyExam1 {

	public static void main(String[] args) {
		// 사과 1개를 10조각으로 쪼개면 1조각이 0.1로 10개가 됨.
		
		int apple = 1 ; // 사과 1개
		double pieceUite = 0.1 ; // 조각 단위
		int number = 7 ; // 7개의 조각
		
		double result = apple - number*pieceUite ; 
		System.out.println("사과 7조각을 뺀 : " + result);
		System.out.println("7조각의 값 : " + number * pieceUite);
		// 결론 정확한 계산을 위해서는 실수 타입을 사용하지 않는 것이 좋다.

	} // 메인메서드 종료

} // 클래스 종료
