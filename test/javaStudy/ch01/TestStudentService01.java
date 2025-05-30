package test.javaStudy.ch01;

import java.util.Scanner;

public class TestStudentService01 {
	// CRUD
	// create , readAll, readOne, update, delete
	// 학생용 service 부메뉴

	public static Scanner inputStr = new Scanner(System.in);
	public static Scanner inputInt = new Scanner(System.in);
	public static StudentDTO student = new StudentDTO();

	public StudentDTO menu(StudentDTO[] students) {
		StudentDTO loginStudent = new StudentDTO() ;
		StudentDTO user = student;
		
		loginStudent = loginStudent(students, inputStr, loginStudent);
		// 일치하는 학번의 StudentDTO 객체를 가진다.
		boolean run = true;
		if (loginStudent == null ) {
			run = false;
		}
		while (run) {
			System.out.println("1. 성적입력");
			System.out.println("2. 성적보기");
			System.out.println("3. 최종점수");
			System.out.println("4. 최종등급");
			System.out.println("5. 성적수정 및 삭제");
			System.out.println("9. 프로그램종료");
			System.out.print(">>>");
			String select = inputStr.next();

			switch (select) {
			case "1":
				System.out.println("성적을 입력합니다.");
				// 성적입력메서드 만들기.
				 putOnScore(students, user, loginStudent);
				break;

			case "2":
				System.out.println("입력하신 성적을 확인하세요");
				scoreView(students, user , loginStudent);
				break;

			case "3":
				System.out.println("최종 점수를 확인합니다.");
				gradeView(students, user, inputStr, loginStudent);
				break;

			case "4":
				System.out.println("최종 등급을 확인합니다.");
				grade(students, user, inputStr, loginStudent);
				break;

			case "5":
				System.out.println("성적수정 및 삭제");
				 user = delete(students, user, inputStr, loginStudent);
				break;

			case "9":
				System.out.println("프로그램을 종료합니다.");
				run = false ;
				break;

			default:
				System.out.println("잘못입력하셨습니다.");
				break;

			} // switch문종료
		}

		return null;

	} // menu 메서드 종료

	private StudentDTO delete(StudentDTO[] students, StudentDTO user, Scanner inputStr2, StudentDTO loginStudent) {
		// 성적 삭제 메서드
		System.out.println("-------------------------");
		System.out.println("내가 입력한 성적만 수정이 가능합니다");
		System.out.println("최종 성적은 담당 교사에게 문의하세요");
		System.out.println("\n 1. 수정 \n 2. 삭제 \n 3. 나가기");
		System.out.println(">>>");
		String select = inputStr.next();
		switch(select) {
		case "1" :
			user = putOnScore(students, user, loginStudent);
		break ;
		case "2" :
			System.out.println("성적이 삭제됩니다.");
			user = null ;
		case "3" :
			break ;
		default :
			System.out.println("잘못입력하셨습니다.");
			break ;
		} //switch문 종료
		return user;
		
	}// 메서드 종료

	private void grade(StudentDTO[] students, StudentDTO user, Scanner inputStr2, StudentDTO loginStudent) {
		// 최종 점수 확인
		System.out.println("-------------------------");
		System.out.println(loginStudent.name+"학생 페이지입니다.");
		System.out.println("번호를 누르면 해당 등급을 확인합니다.");
		System.out.println("-------------------------");

		System.out.println("\n 1. 국어 \n 2. 수학 \n 3. 영어 \n 4. 전체 등수 \n 9. 나가기");
		System.out.println(">>>");
		String select2 = inputStr.next();
		switch (select2) {
		case "1":
			System.out.println("국어 등급");
			if (loginStudent.kor == 100) {
				System.out.println("A+");
			}
			if (loginStudent.kor >= 80) {
				System.out.println("국어 B");
			}
			if (loginStudent.kor >= 70) {
				System.out.println("국어 B-");
			} else {
				System.out.println("국어 C");
			}
			return;
		case "2":
			System.out.println("수학 등급");
			if (loginStudent.mat == 100) {
				System.out.println("수학 A+");
			}
			if (loginStudent.mat >= 80) {
				System.out.println("수학 B");
			}
			if (loginStudent.mat >= 70) {
				System.out.println("수학 B-");
			} else {
				System.out.println("수학 C");
			}
			return;
		case "3":
			System.out.println("영어 등급");
			if (loginStudent.eng == 100) {
				System.out.println("영어 A+");
			}
			if (loginStudent.eng >= 80) {
				System.out.println("영어 B");
			}
			if (loginStudent.eng >= 70) {
				System.out.println("영어 B-");
			} else {
				System.out.println("영어 C");
			}
			return;
			
		case "4":
			System.out.println("등수확인");
			System.out.println((Math.random())+10 + "등");
			return;
		case "9":
			break;
		default :
			System.out.println("잘못입력하셨습니다.");
			break ;
		} // 등급 확인 메서드 종료
	System.out.println("-------------------------");

		
		
	} // 점수확인용 메서드

	private StudentDTO loginStudent(StudentDTO[] students, Scanner inputStr2, StudentDTO loginStudent) {
		// 학번 검증용 메서드 생성
		System.out.println("학생 메뉴에 진입하셨습니다.");
		System.out.println("학번을 입력해주세요");
		System.out.print(">>>");
		String inputId = inputStr.next();
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				//System.out.println("students[i]" + students[i].studentID);
				for (int j = 0; j < students.length; j++) {
					if (students[i].studentID.equals(inputId)) {
						loginStudent = students[i];
						return loginStudent ;
					} else {
						loginStudent = null ;
						break ;	
					} 
				}

			} // if문종료
		}// for문종료
		if (loginStudent == null) {
			System.out.println("찾으시는 정보가 없습니다. 다시 시작해주세요.");
		}
		return loginStudent ;
	} // 메서드종료

	private void gradeView(StudentDTO[] students, StudentDTO user, Scanner inputStr, StudentDTO loginStudent) {
		// 등급 보기 메서드
		int avg = (user.kor + user.eng + user.mat);
		int loginAvg = (loginStudent.kor + loginStudent.eng + loginStudent.mat);
		System.out.println("-------------------------");
		System.out.println(loginStudent.name+"학생 성적 확인 페이지입니다");
			System.out.println("최종 점수를 확인합니다.");
			System.out.println("국어 " + loginStudent.kor+" 점");
			System.out.println("영어 " + loginStudent.eng+" 점");
			System.out.println("수학 " + loginStudent.mat+" 점");
			System.out.println("평균 " + loginAvg / 4 +" 점");
			System.out.println("총점 "+ loginAvg+" 점");
			System.out.println("-------------------------");

	}

	private StudentDTO scoreView(StudentDTO[] students, StudentDTO user, StudentDTO loginStudent) {
		// 성적보기메서드
		if (user == null) {
			System.out.println(loginStudent.name + "학생의 입력 점수가 없습니다.");
			return user;
		}
		System.out.println(loginStudent.name+" 학생 가채점 입력점수.");
		System.out.println("국어 :" + user.kor + "점");
		System.out.println("수학 :" + user.mat + "점");
		System.out.println("영어 :" + user.eng + "점");
		System.out.println("-------------------------");
		return user;
	}

	private StudentDTO putOnScore(StudentDTO[] students, StudentDTO user, StudentDTO loginStudent) {
		// 성적 입력 메서드 생성
		System.out.println(loginStudent.name+" 학생 성적을 입력해주세요.");
		System.out.println("국어 :");
		user.kor = inputInt.nextInt();

		System.out.println("수학 :");
		user.mat = inputInt.nextInt();

		System.out.println("영어 :");
		user.eng = inputInt.nextInt();
		
		return user;
	}

} // class 종료
