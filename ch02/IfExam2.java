package ch02;

import java.util.Scanner;

public class IfExam2 {

	public static void main(String[] args) {
		// if (조건) { 실행문 }
		//     조건이 true -> 실행문 실행.
		//     조건이 false -> else문 실행
		
		Scanner input = new Scanner(System.in);
	
		
		System.out.println("이름을 입력해주세요.");
		System.out.print(">>>");
		String name = input.next(); // name변수에 키보드로 입력받은 값을 넣는다.
		
		System.out.println("점수를 넣어주세요.");
		System.out.print(">>>");
		int score = input.nextInt(); //score변수에 키보드로 입력받은 값을 넣는다.
		
		if (score > 0 && score <=100) { //0보다 크고 100과 같거나 작을때 true
			if (score >= 90) {// score가 90보다 크거나 같을때 실행
				System.out.println(name + "님의 등급은.");
				System.out.println("점수 " + score + "점 A등급 입니다."); 
				} else if (score >=80) {
					System.out.println(name + "님의 등급은.");
					System.out.println("점수 " + score + "점 B등급 입니다.");
				} else if (score >=70) {
					System.out.println(name + "님의 등급은.");
					System.out.println("점수 " + score + "점 C등급 입니다.");
				} else if (score >=60) { 
					System.out.println(name + "님의 등급은.");
					System.out.println("점수 " + score + "점 D등급 입니다.");
				} else {
					System.out.println(name + "님의 등급은.");
					System.out.println("점수 " + score + "점 F등급 입니다.");
				} //안쪽 if문 종료
	} else {
		System.out.println(name + "님의 등급은.");
		System.out.println("점수 " + score + " 점");
		System.out.println("다시 확인해주세요.");
	} 

	} // main 메서드 종료

} // class 종료
