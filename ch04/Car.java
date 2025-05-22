package ch04;

import java.util.Scanner;

public class Car {
	
		// 2025.05.22
		// Car클래스 사용하여 자동차 주행 프로그램 만들어보기
		// 계기판, 후진, 경고 count, 기능도 추가해서 구현해보려고함....
	
	
		// 필드 (객체가 가지고 있어야 하는 값) -> 글로벌 변수 (GV)
		// 고유 데이터
		public String company ; // 제작회사(현대, 기아, KGM, 쉐보레, 아우디)
		public String model ; // 아반떼, 그렌저, 소나타
		public String color ; // 빨간색, 은색, 검정색, 하얀색
		int maxSpeed ; // 최고속도
		public String oilType ; // 경유, 휘발유
		public final int MAXSPEED = 300 ; // final int를 사용하여 MAXSPEED값을 설정함.
		public final int MINSPEED = 0 ;   // final int를 사용하여 MINSPEED값을 설정함.
		public final int MAXOIL = 200;
		public final int MINOIL = 0 ;
		// 상태값 (변동가능)
		public int speed ;
		public int rpm ;
		public int oil ;
		public int money ;
		public int oilCharge = 0 ;
		public int oilPrice = 150 ;
		// java의 필드는 자동연결된 계산식을 지원하지 않는다.
		// java 필드의 초기화식은 한번만 실행 -> 고정된 값처럼 취급됨.
	
		
		// 부품 -> 다른 클래스를 생성하여 연결한다.
//		public Body body ;
//		public Engine engine ;
//		public Tire tire ; 
	    
		//	부품에 필드 사용법 
		// Car myCar = mew Car(); -> 객체생성(인스턴스)
		// myCar.maxSpped = 300 ; -> 객체에 있는 maxSpeed에 300 정수를 넣는다.
		//*********************************************************************//
		
		
		// 기본 생성자 : 생략가능 (객체가 생성할 때 사용되는 메서드 : 클래스명과 같은 이름)
		public Car() {
			speed = 0 ;
			rpm = 50 ;
			oil = 100 ;
			
		} // 객체가 생성되면서 변수에 값이 저장됨.
		
		// 사용자 지정 생성자 -> 개발자가 응용하는 기법 
		// 사용자 지정 생성자가 만들어지면 기본생성자는 자동으로 생성되지 않는다.
		public Car (String company, String model, String color, final int MAXSPEED, final int MINSPEED ) {
			this.company = company ;
			this.model = model ;
			this.color = color ;
			
		} // Car myCar = new Car("벤츠","E클래스","빨간색") ; 
		
		//메서드 (객체가 수행해야하는 동작)
		// C 	       R		    U	  	 	 D
		// (시동)		(주행상태)	  (가속, 감속, 주차)  (시동종료)
		public void start() {
			System.out.println(this.model+" 가(이) 주행을 시작합니다. ");
			System.out.println("현재 속도 : " + this.speed);
			System.out.println("현재 rpm : "+ this.rpm );
			System.out.println("현재 주유량 : "+ this.oil);
} // start메서드종료
		
		public void drive() {
			Scanner inputInt = new Scanner(System.in);
			boolean driving = true ; 
			while(driving) { // while문으로 실행하지 않으면 switch문 실행 후 main으로 빠져나가게됨.
			System.out.println("1. 엑셀");
			System.out.println("2. 브레이크");
			System.out.print(">>>");
			int run = inputInt.nextInt();
			switch(run) {
			case 1 :
				if (this.speed >= this.MAXSPEED) {  // this.speed >= this.MAXSPEED 300이상일때만, if문 실행하게됨.
					System.out.println("최대 속도입니다.");
					System.out.println("안전을 위하여 감속을 시작합니다.");
					this.speed = this.MAXSPEED ;
					this.speed = 270 ;
					System.out.println("현재 속도 : "+ this.speed);
					System.out.println("****경고****감속하세요****");
					// 여기서 return ; 을 넣으면 main으로 이동함.
					// if문 밖에 this.speed += 30 ; 을 넣으면, 감속 후에도 speed+= 30 이 출력됨.
				} else { // speed값이 300 미만일때 실행됨. 
				this.speed += 30 ;
				this.rpm += 5;
				this.oil -= 1 ;
				System.out.println("가속을 진행합니다.");
				System.out.println("현재 속도 : " + this.speed);
				System.out.println("현재 주유량 : "+ this.oil); }
				break ;
				
			case 2 :
				if (this.speed <= this.MINSPEED) { 
					System.out.println("현재 속도 : "+ this.speed);
					System.out.println("****차량이 정차합니다****");// speed가 MINSPEED보다 작거나 같을때 실행되는 if문 
					System.out.println("주행을 종료하시려면 0번을 눌러주세요.");
					System.out.print(">>>");
					int stop = inputInt.nextInt();
					if (stop == 0 ) {
						driving = false ;
					} // 주행종료 if문
				} else { // else문을 넣지 않으면 , if문 밖 실행문이 실행되게됨.
				this.speed -= 30 ;
				this.rpm -= 5 ;
				this.oil -= 1 ;
				System.out.println("감속을 진행합니다.");
				System.out.println("현재 속도 : " + this.speed);
				System.out.println("현재 주유량 : "+ this.oil);
				break ; 
				} // else문 종료
			} // driving while문종료
			} // switch문 종료
		} //drive메서드종료
		
		
		public void stop () {
			System.out.println(color + company+ " " + model +"의 주행을 종료합니다.");
			//System.out.println("주행을 종료합니다.");
		} // stop 메서드 종료
		
		public void getOil() {
		Scanner inputInt = new Scanner(System.in);
			System.out.println("원하시는 주유량을 입력해주세요.");
			System.out.print(">>>");
			oilCharge = inputInt.nextInt();
			
			System.out.println(oilCharge +" 이 주유됩니다.");
			System.out.println("가격 : "+ (oilCharge * oilPrice) + "원");
			this.oil += oilCharge ;
			System.out.println("현재 주유량 : " + this.oil);
			
		} //getGas메서드 종료
		
		public void dashBoard () {
			
		} // dashBoard메서드 종료
		
} //class종료