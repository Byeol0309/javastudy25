package ch02;

public class ForPrintExam {

	public static void main(String[] args) {
		for(int i = 1 ; i <=10 ; i++ ) {
	    //        초기값;    최대값; 증감값;  { 실행문 }
			System.out.println("1~10까지 출력 : " +i);
		} // 1~10까지 출력 for문
		
		for (int a = 2 ; a <= 10 ; a = a + 2) {
			System.out.println("1~10까지 짝수만 출력 : " +a);
		}

	} // main메서드종료

}//class종료
