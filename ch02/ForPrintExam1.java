package ch02;

public class ForPrintExam1 {

	public static void main(String[] args) {
		// 둘이상의 초기화식
		// 초기화식이 둘이상이나 증감식이 둘이상인 경우도 있다.
		// 주의 : 조건식에는 &&을 이용하여 작성.
		for (int i = 0 , j = 100 ; i <= 10 && j >=90 ; i++ , j--) {
			System.out.println("i값의 증가 : " + i + " || j값의 감소 : " + j);
		}

	} //main매서드종료

}//class종료
