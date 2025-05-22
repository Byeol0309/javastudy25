package ch03;

public class ArrayCreateExam01 {

	public static void main(String[] args) {
		// 주의사항 : scores배열을 생성하면서 값도 같이 입력되었다.
		// 타입 [] 변수 ;
		// 변수 = {값1, 값2, 값3} ; -> 배열을 생성하였지만 객체가 없는 상태
		// int [] scores ;
		// scores = {83, 90, 87} ; // 컴파일오류 (객체 생성되지 않은 상태)
		int [] scores = null; // 값이 들어있지 않은 , 비어있는 객체(int타입의 scores 배열객체) 생성
		scores = new int [] {83, 90, 87} ; // new 연산자를 이용하여 객체 생성
		
		System.out.println("scores[0]" + scores[0]);
		System.out.println("scores[0]" + scores[1]);
		System.out.println("scores[0]" + scores[2]);
		
		int sum = 0 ; 
		for(int i = 0 ; i < 3 ; i++ ) {
			sum += scores[i] ;
		}
		System.out.println("총점 :" + sum);
		double avg = (double) sum / 3 ;
		System.out.println("평균 :" + avg);

	}//main메서드종료

}//class종료
