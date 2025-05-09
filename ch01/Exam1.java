package ch01;

public class Exam1 {

	public static void main(String[] args) {

		int x = 10;
		int result1 = +x;
		int result2 = -x;
		System.out.println(x);
		System.out.println(result1);
		System.out.println(result2);

		short s = 100;
		// short result3 = -s ;
		int result3 = -s;
		System.out.println(result3);
		// 정수연산일때는 int 타입을 기본으로 함.
		System.out.println("=========================");

		x++;
		System.out.println("x++ = " + x); // 11
		++x;
		System.out.println("++x = " + x); // 12
		System.out.println("x = : " + x); // 12

		int z = x++;
		System.out.println(z); // 12
		System.out.println(x); // 13

		System.out.println("=========================");

		z = ++x;
		System.out.println(z); // 14
		System.out.println("x : " + x); // 14

		int y = 10;
		y--; // -> 9
		--y; // -> 8
		System.out.println("y : " + y);

		z = ++x + y++; //
		System.out.println("z : " + z);
		System.out.println("x : " + x); // 15 = ++14
		System.out.println("y : " + y); // 9 = 8++
		// ++, --, 연산이 뒤에 있으면 다른 연산을 모두 수행하고 마지막에 수행함.

		boolean play = true;
		System.out.println(play);
		play = !play;
		System.out.println(play);
		play = !play;
		System.out.println(play);
		System.out.println("==================");

		String str1 = "kitty";
		String str2 = "Hello";
		System.out.println(str1 + str2);
		System.out.println(str2 + str1);
		String str3 = str1 + str2;
		System.out.println(str3);
		String str4 = str1 + 10 + 04;
		String str5 = 10 + 04 + str1;
		System.out.println(str4);
		System.out.println(str5);
		
		String str6 = new String("kitty");
		System.out.println(str2 + str6);
		
		System.out.println(str1 == str6);
		System.out.println(str1.equals(str6));
		System.out.println("=====================");
		int num = 0 ;
		num += 10 ; 
		System.out.println(num);
		num -= 5 ; 
		System.out.println(num);
		num *= 3 ;
		System.out.println(num);
		num /= 5 ;
		System.out.println(num);
		num %= 2 ;
		System.out.println(num);
		// 대입연산자.
		// 대입연산자는 오른쪽 피연산자의 값을 
		//          좌측 피연산자인 변수에 저장.
		
		System.out.println("===================");
		int score = 91 ;
		char grade = (score > 90) ? 'A' :( (score > 80 )  ? 'B' : 'C' ) ;
		System.out.println(score + "점은" + grade + "등급입니다.");
		
	} // 메인메서드 종료

} // 클래스 종료
