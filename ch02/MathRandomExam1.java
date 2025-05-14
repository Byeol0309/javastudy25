package ch02;

public class MathRandomExam1 {

	public static void main(String[] args) {
		//int score = (int)(Math.random()*50) + 51 ;
		// 51~100 사이값을 난수로 발생시킨다.
		// (int)(Math.random()*50) + 51 ;
		// (int)(Math.random()*51) + 50 ;
		//System.out.println("현재점수는 :" + score);
		int score = 77 ;
		String grade ;
		if (score >= 90) {
			if(score == 100) {
				grade = "A++" ;
			} else if (score >= 95) {
				grade = "A+" ;
			}else {
				grade = "A" ;
			} // 90점 이상이면 A	
		} else {
			if(score > 80) { // 81점 이상인지를 묻는다.
				grade = "B"; // 80점 이상이면 B 
			} else if (score <= 80 && score > 50 )  {
				grade = "C" ;	
			} else if (score == 77 ) {
				grade = "lucky"  ; // 50보다 크고 80보다 작을때
			} 
			 else {
				grade = "재시험" ;
				System.out.println("재시험에 응시해주세요.");
			}
		} // else�� ����
		 System.out.println("학점 :" + grade );

	} // main �ż��� ����

} // class ����
