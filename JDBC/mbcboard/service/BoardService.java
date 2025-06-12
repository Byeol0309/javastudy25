package mbcboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dao.BoardDAO;
import mbcboard.dto.BoardDTO;
import mbcmember.dto.MemberDTO;

public class BoardService {

	// 2025.06.10
	// dao와 dto를 사용하여 board의 boardService 부메뉴와 CRUD를 처리한다
	// 2025.06.11
	// boardService 완료
	//

	// 필드
	public BoardDAO boardDAO = new BoardDAO();  // BoardDAO의 기본생성자에서 1단계, 2단계를 수행한다.
												// Class.forName으로 드라이버 로딩
												// DriverManager.getConnection으로 로딩된 드라이버를
												// Connection 객체로 반환(DB와 연결)
												// 필드에서 public으로 BoardDAO 객체를 생성했기때문에, 메서드에서 DAO객체 활용 가능하다.
	// 생성자

	// 메서드 (부메뉴, 생성, 모두보기, 1개보기, 수정하기, 삭제하기)
	public MemberDTO subMenu(MemberDTO loginSession, Scanner inputStr) throws SQLException {
		// 부메뉴용 subMenu 메서드 생성
		boolean session = false;
		boolean subRun = true;
		session = memberJoin(loginSession);
		if (session != true) {
			System.out.println("\t로그인 후\n\t이용해주세요\n======================");
			subRun = false;
		}
		
		while (subRun) {
			System.out.println("MBC아카데미 게시판 서비스 입니다.");
			System.out.println("1. 게시글 전체 목록");
			System.out.println("2. 게시글 작성");
			System.out.println("3. 게시글 검색");
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
				// Service부메뉴에서 DAO객체의 메서드를 호출하여 SQL을 DB에 전달 후 실행하여 결과값을 반환받는다.
				// DAO 객체에서 -> 쿼리문 insert into() values() 을 DB에 전달 후 실행하여 결과값을 반환받는다.
				insert(boardDAO, inputStr);
				break;
			case "3":
				System.out.println("======================\n\t게시글을\n\t열람합니다\n======================");
				// select 열람할 열, , , from 테이블이름 where = ?
				// Service부메뉴에서 DAO객체의 메서드를 호출하여 SQL을 DB에 전달 후 실행하여 결과값을 반환받는다.
				// SQL : select bno, btitle, bcontent, bwriter, bdate from board where btitle =
				// ?
				readOne(inputStr);
				break;
			case "4":
				System.out.println("======================\n\t게시글을\n\t수정합니다\n======================");
				// update 테이블이름 set 변경할열 = 변경할내용
				// Service부메뉴에서 DAO객체의 메서드를 호출하여 SQL을 DB에 전달 후 실행한다. 결과값을 반환받는다.
				// SQL : update 테이블이름 set 수정할열 = '수정내용' ;
				// "update board set btitle = ?, bcontent = ?, bwriter = ?, bdate = ?" ;
				modify(inputStr);
				break;
			case "5":
				System.out.println("======================\n\t게시글을\n\t삭제합니다\n======================");
				// delete from 테이블이름 where 조건 ;
				deleteOne();
				break;
			case "6":
				System.out.println("======================\n\t게시판을\n\t종료합니다\n======================");
				boardDAO.connection.close(); // 게시판 종료시 connection 종료
				subRun = false ;
				break;

			} // switch문 (부메뉴) 종료

		} // while문 종료
		return loginSession;

	} // subMenu메서드 종료

	private boolean memberJoin(MemberDTO loginSession) {
		// 로그인상태검증용 메서드
		if (loginSession != null) {
			return true;
		}
		return false;
	}//memberJoin()종료

	private void deleteOne() throws SQLException {
		// 게시물의 번호를 키보드로 입력받아 삭제한다.
		System.out.println("삭제하려는 게시글의 번호를 입력하세요");
		
		Scanner inputInt = new Scanner(System.in);
		System.out.print("입력 : ");
		int selectBno = inputInt.nextInt();
		boardDAO.deleteOne(selectBno) ;

	} //deleteOne()메서드종료

	private void modify(Scanner inputStr) throws SQLException {
		// 키보드로 입력받은 제목(btitle)을 찾아서 내용을 수정한다.
		// SQL : update board set bcontent = '수정내용';
		// update board set bwriter = ?, btitle = ?, bcontent = ?, bdate = sysdate ;
		System.out.println("수정하시려는 게시글의 제목을 입력하세요");
		System.out.print("입력 : ");
		String title = inputStr.next();

		boardDAO.modify(title, inputStr);

	} // modify() 게시글 수정 메서드 종료

	private void readOne(Scanner inputStr) throws SQLException {
		// 키보드로 입력받은 작성자(btitle)가 포함되는 열을 열람해보자.
		// DAO 기본생성자로 JDBC와 연결.
		// SQL : select bno, btitle, bcontent, bwriter, bdate from board where btitle =
		// ?
		System.out.println("게시글 찾기");
		System.out.print("게시글 제목 :");
		String btitle = inputStr.next();

		boardDAO.readOne(btitle);

	} // readOne() 조건이 있는 게시글 열람. 메서드종료

	private void insert(BoardDAO boardDAO, Scanner inputStr) throws SQLException {
		// 키보드로 입력받은 데이터를 DTO에 넣고, 데이터베이스에 insert 하자.
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
		// boardDTO.setBcontent(inputStr.next()); inputStr은 String문자열을 담기때문에 띄어쓰기가 포함된
		// 문장을 담을 수 없으므로
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
