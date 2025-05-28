package ch05.marioKart_v2.dto;

public class MemberDTO {

	    // 2025.05.26(월)
		// getter와 setter를 적용하여
		// ch04의 MVC 패턴으로 마리오 카트 만들기를 리팩토링해보기. 
		//
		// 클래스를 선언할때 필드를 private으로 선언하여 외부로부터 필드를 보호하고
		// Getter_Setter를 작성하여 필드값을 안전하게 변경, 사용할수있다.
		// boolean일 경우 Getter와 get으로 시작하지 않고 is로 시작하는 것이 관례임.
		// Getter : 필드값을 가공 후 외부로 전달
		// Setter : 검증 후 매개값을 전달하는 역할.
	
		// 필드
		private String id ; 
		private String pw ;
		private String nickName ;
		private String email ; 
		
		private int loginNum ; // index번호 저장용 변수
		private CharacterDTO characterDTO ;
		private int loginComplete ;
		// 생성자
		
		
		
		// private 필드값에 getter_setter 사용하기.
		// 메서드
	
		public String getId() { // Getter : 필드값을 가공 후 외부로 전달
			return id;
		}
		public String getPw() {
			return pw;
		}
		public String getNickName() {
			return nickName;
		}
		public String getEmail() {
			return email;
		}
		public int getLoginNum() {
			return loginNum;
		}
		public CharacterDTO getCharacterDTO() {
			return characterDTO;
		}
		public int getLoginComplete() {
			return loginComplete;
		}
		
		
		public void setId(String id) {  // Setter : 검증 후 매개값을 전달하는 역할.
			this.id = id;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setLoginNum(int loginNum) {
			this.loginNum = loginNum;
		}
		public void setCharacterDTO(CharacterDTO characterDTO) {
			this.characterDTO = characterDTO;
		}
		public void setLoginComplete(int loginComplete) {
			this.loginComplete = loginComplete;
		}
		
		
		
}
