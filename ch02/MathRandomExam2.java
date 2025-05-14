package ch02;

import java.util.Scanner;

public class MathRandomExam2 {

	public static void main(String[] args) {
		// 랜덤 성적 처리 프로그램.
		int kor = (int)(Math.random()*100)+1 ; // 1~100의 난수를 생성하여 kor변수에 넣는다.
		int eng = (int)(Math.random()*100)+1 ;
		int mat = (int)(Math.random()*100)+1 ;
		int avg = (kor + eng + mat)/3 ;
		String grade = "";

		if (avg >= 90) {
			grade = "A" ;
		} else if (avg >=80) {
			grade = "B" ;
		} else if (avg >=70) {
			grade = "C" ;
		} else if (avg >=60) {
			grade = "D" ;
		}else {
			grade = "F" ; // 60미만
		}
		
		
		System.out.println("국어점수 : " + kor);
		System.out.println("영어점수 : " + eng);
		System.out.println("수학점수 : " + mat);
		System.out.println("평균점수 : " + avg);
		System.out.println("등급 : " + grade);
	} // main 메소드 종료

} // class 종료
