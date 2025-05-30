package test.javaStudy.ch01;

import java.util.Scanner;

public class TestExam01 {
	//2025.05.29 (목)
	// DTO를 활용하여 성적처리 프로그램 구현해보기 Test
	public static Scanner inputInt = new Scanner(System.in);
	public static Scanner inputStr = new Scanner(System.in);
	public static StudentDTO studentdto = new StudentDTO () ;
	public static StudentDTO[] students = new StudentDTO[3] ;
	public static StudentDTO loginSt = new StudentDTO() ;
	
	
	static { 
		
		StudentDTO  studentDto0 = new StudentDTO ("김가가", "1234", 10, 10, 10, 10, "b") ;
		students[0] = studentDto0 ;
		
		StudentDTO  studentDto1 = new StudentDTO ("김나나","4567", 20, 20, 20, 20, "b") ;
		students[1] = studentDto1 ;
		
		StudentDTO  studentDto2 = new StudentDTO ("김다다","2345", 10, 10, 20, 20, "b") ;
		students[2] = studentDto2 ;
		
	}
	
	
	public static void main(String[] args) {
		// CRUD
		//
		
		System.out.println("================");
		System.out.println("  성적 처리 시스템");
		System.out.println("================");
		System.out.println("1. 학생");
		System.out.println("2. 교사");
		System.out.print(">>>");
		String select = inputStr.next();
		
		switch(select) {
		case "1" :
			System.out.println("학생 메뉴로 진입합니다.");
			TestStudentService01 service = new TestStudentService01 ();
			 service.menu(students);
			
		break ;
		
		case "2" :
			System.out.println("교사 메뉴로 진입합니다.");
		break ; 
		
		default :
			System.out.println("다시 입력해주세요.");
		break ;
		
		}
		
		
	} // main메서드 종료


	

} // class 종료
