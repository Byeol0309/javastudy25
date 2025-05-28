package ch05.marioKart_v2.dto;

public class CharacterDTO {
		// 2025.05.26(월)
		// DTO에 getter_setter를 적용해보자.
		// MVC 패턴으로 마리오 카트 프로그램 만들어보기.
		// 캐릭터 DTO 
		
		// 필드
		private String name ;  		// 캐릭터명
		private double weight ; 		// 캐릭터 무게
		private double speed ; 		// 속도
		private double acceleration ;// 가속
		private double handling ; 	// 핸들링
		private double friction ;	// 마찰력
		
		// 기본생성자 -> new CharacterDTO();
		// 생성자
		private CharacterDTO(String name, double weight, 
				double speed, double acceleration, double handling, double friction) {
			this.name = name ; 
			this.weight = weight ;
			this.speed = speed ;
			this.acceleration = acceleration ;
			this.handling = handling ; 
			this.friction = friction ;
}
}
