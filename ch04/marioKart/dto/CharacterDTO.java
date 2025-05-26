package ch04.marioKart.dto;

public class CharacterDTO {
	// 2025.05.23(금)
	// MVC 패턴으로 마리오 카트 프로그램 만들어보기.
	// 캐릭터 DTO 
	
	// 필드
	public String name ;  		// 캐릭터명
	public double weight ; 		// 캐릭터 무게
	public double speed ; 		// 속도
	public double acceleration ;// 가속
	public double handling ; 	// 핸들링
	public double friction ;	// 마찰력
	
	// 기본생성자 -> new CharacterDTO();
	// 생성자
	public CharacterDTO(String name, double weight, 
			double speed, double acceleration, double handling, double friction) {
		this.name = name ; 
		this.weight = weight ;
		this.speed = speed ;
		this.acceleration = acceleration ;
		this.handling = handling ; 
		this.friction = friction ;
		
	}
	
	
	// 메서드
	
	
} // class종료
