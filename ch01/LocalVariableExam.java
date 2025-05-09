package ch01;

/*
작성자 : 김샛별
작성일 : 2025-05-02
작성회사 : 엠비씨 아카데미
목표 : 변수 사용 연습

*/
public class LocalVariableExam {
	
	public static void main(String[] args) {
		// 변수의 사용 범위는 괄호(블럭)안에서 효과를 발휘한다.
		
		int v1 = 5 ;
		int v2 = 0 ; // 선언은 위에서 다 할 것
		
		if(v1>10) { // if는 비교문으로 ()값이 참이면 블럭을 실행한다.
			v2 = v1 + 10 ;
			
		} // if문 종료
	
		int v3 = v1 + v2 + 5 ;
		
		System.out.println("v1의 값 :"+ v1);
		System.out.println("v2의 값 :"+ v2);
		System.out.println("v3의 값 :"+ v3);
		
		
		
	}// 메인메소드 종료
	
}//LocalVariableExam종료
