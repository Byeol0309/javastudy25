package ch03;

public class ArrayCreateExam02 {

	public static void main(String[] args) {
		// 메서드를 활용하는 기법은 
		// 매개값의 전달과 리턴값의 전달이 중요하다.
		//int sum = add(new int [] {70, 80, 90}) ;
		          // return값의 변수명은 달라도 된다.
		          // 리턴값의 전달은  add 메서드 
				 // sum + = scores[]에 계산된 sum값이 int sum으로 전달되는 흐름.
		//System.out.println("총합 :" + sum);
		int total1 = add(new int[] {70, 80, 90}) ;
		int total2 = add(new int[] {60, 70, 80}) ;
		int total3 = add(new int[] {90, 80, 50});
		System.out.println("1반의 총합 :" + total1);
		System.out.println("2반의 총합 :" + total2);
		System.out.println("3반의 총합 :" + total3);


	} //main메서드종료

	static int add(int[] scores) {
		// add메서드 생성.
		int sum = 0 ;
		
		for (int i = 0 ; i < 3 ; i++) {
			sum += scores[i] ;
		}
		
		return sum ;
	}//add메서드종료

}//class종료
