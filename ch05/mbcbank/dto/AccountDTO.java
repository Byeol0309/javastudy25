package ch05.mbcbank.dto;

public class AccountDTO {
	// 2025.05.27(화)
	// Getter와 Setter를 사용하여
	// 키보드로 계좌 정보를 입력받아서 계좌를 관리하는 프로그램을 작성해본다.
	// 계좌관리 프로그램을 만들어보자.
	
	//개인적 필드
	private String ano ;  	// 계좌번호
	private String owner ;  // 계좌주
	private String pw ;
	private int balance ;	// 잔고
	private String bankname ; // 은행명
	
	
	
	// 생성자
	public AccountDTO(String ano, String owner, String pw, int balance, String bankname) {
		//super();
		// 모든 필드를 사용한 생성자
		// AccountDTO accountDTO = new AccountDTO(계좌번호, 계좌주, 잔고, 은행명)
		this.ano = ano;
		this.owner = owner;
		this.pw = pw ;
		this.balance = balance;
		this.bankname = bankname;
	}


	public AccountDTO() {
		// super();
		// 기본생성자 
		// AccountDTO accountDTO = new AccountDTO();
	}

	
	
	// 메서드
	// Getter : 변수값 출력시 변조를 담당.
	// Setter : 변수값 입력시 검증을 담당.
	public String getAno() { //getter : private 필드값 ano을 리턴하여 출력함.
		return ano;
	}


	public String getOwner() {
		return owner;
	}
	
	public String getPw() {
		return pw;
	}


	public int getBalance() {
		return balance;
	}


	public String getBankname() {
		return bankname;
	}


	public void setAno(String ano) { //setter : 입력된 ano값을 검증하여 private 필드의 ano에 입력.
		this.ano = ano;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public void setBankname(String bankname) {
		this.bankname = bankname;
	}


	@Override
	public String toString() {
		return "AccountDTO [ano=" + ano + ", owner=" + owner + ", balance=" + balance + ", "
				+ "bankname=" + bankname + ",pw"+ pw+"]";
	}
	
	
	
	
	
	

} //class종료
