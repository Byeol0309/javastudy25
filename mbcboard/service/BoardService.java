package mbcboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dao.BoardDAO;
import mbcboard.dto.BoardDTO;

public class BoardService {

	// 2025.06.10
	// dao와 dto를 사용하여 부메뉴와 CRUD를 처리한다

	// 필드
	public BoardDAO boardDAO = new BoardDAO(); // BoardDAO의 기본생성자에서 1단계, 2단계를 수행한다.
												// Class.forName으로 드라이버 로딩
												// DriverManager.getConnection으로 로딩된 드라이버를
												// Connection 객체로 반환(DB와 연결)
												// 필드에서 public으로 BoardDAO 객체를 생성했기때문에, 메서드에서 DAO객체 활용 가능하다.
	// 생성자

	// 메서드 (부메뉴, 생성, 모두보기, 1개보기, 수정하기, 삭제하기)
	public void subMenu(Scanner inputStr) throws SQLException {
		// 부메뉴용 subMenu 메서드 생성
		boolean subRun = true;
		while (subRun) {
			System.out.println("MBC아카데미 게시판 서비스 입니다.");
			System.out.println("1. 모두보기");
			System.out.println("2. 게시글 작성");
			System.out.println("3. 게시글 자세히 보기");
			System.out.println("4. 게시글 수정");
			System.out.println("5. 게시글 삭제");
			System.out.println("6. 나가기");
			System.out.print(">>>");
			String subSelect = inputStr.next();

			switch (subSelect) {
			case "1":
				System.out.println("======================\n\t게시판\n\t목록보기\n======================");
				selectAll(boardDAO);
				// Service부메뉴에서 DAO객체의 메서드 호출하여
				// DAO 객체에서 -> select * from board
				break;
			case "2":
				System.out.println("======================\n\t게시글을\n\t작성합니다\n======================");
				// Service부메뉴에서 DAO객체의 메서드를 호출하여
				// DAO 객체에서 -> 쿼리문 insert into() values() 을 DB에 전달 후 실행하여 결과값을 반환받는다.
				insert(boardDAO, inputStr);
				break;
			case "3":
				System.out.println("======================\n\t게시글을\n\t열람합니다\n======================");
				// select 열람할 열, , , from 테이블이름 where = ?
				break;
			case "4":
				System.out.println("======================\n\t게시글을\n\t수정합니다\n======================");
				// update 테이블이름 set 변경할열 = 변경할내용
				break;
			case "5":
				System.out.println("======================\n\t게시글을\n\t삭제합니다\n======================");
				// delete from 테이블이름 where 조건 ;
				break;
			case "6":
				System.out.println("======================\n\t게시판을\n\t종료합니다\n======================");
				break;

			} // switch문 (부메뉴) 종료

		} // while문 종료

	} // subMenu메서드 종료

	private void insert(BoardDAO boardDAO, Scanner inputStr) {
		// 키보드로 입력받은 데이터를 DTO를 사용하여 데이터베이스에 insert 하자.
		BoardDTO boardDTO = new BoardDTO();
		System.out.println("       게시글 작성");
		System.out.println("======================");
		System.out.print("작성자 : ");
		boardDTO.setBwiter(inputStr.next());
		
		System.out.print("제목 : ");
		boardDTO.setBtitle(inputStr.next());
		
		Scanner inputLine = new Scanner(System.in);
		System.out.print("내용 : ");
		boardDTO.setBcontent(inputLine.nextLine());
		// boardDTO.setBcontent(inputStr.next()); inputStr은 String문자열을 담기때문에 띄어쓰기가 포함된 문장을 담을 수 없으므로
		// nextLine()을 담을 Scanner객체 inputLine을 새로 생성하겠다.
		
		// 입력값을 받은 boardDTO 객체를 DB와 연결할 boardDAO객체에 전달하겠다.
		boardDAO.insertBoard(boardDTO); // boardDTO객체를 boardDAO객체의 insertBoard메서드에 전달.

	} // insert()메서드 종료

	private void selectAll(BoardDAO boardDAO) throws SQLException {
		// DAO객체의 메서드를 호출하여 db와 연동한다.
		// DAO객체의 메서드에서 sql로 select*from board
		System.out.println("======================");
		System.out.println("     MBC 게시판 목록");
		boardDAO.selectAll();
		System.out.println("======================");

	} // selectAll()메서드 종료

} // class종료
