package ch02;

import java.util.Scanner;

public class ForSumExam {

	public static void main(String[] args) {
		// for 1~100까지의 합.
		// 변수는 2개 필요
		// sum은 합을 누적하는 변수로 활용 / i는 1~100까지 증가되는 변수로 활용.
		Scanner in = new Scanner(System.in);
		System.out.println("누적 합계의 최대값을 넣어주세요");
		System.out.print("숫자입력 >>>");
		int max = in.nextInt();
		int sum = 0;
		for(int i = 1 ; i <= max ; i++) { // 1~100까지 증가값
			sum = sum + i ;
		} //for문 종료
		System.out.println("1~" + max + "까지의 합 : " + sum);

	}//main메서드종료

}//class종료
