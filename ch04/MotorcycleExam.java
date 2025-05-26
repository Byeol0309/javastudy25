package ch04;

public class MotorcycleExam {

	public static void main(String[] args) {
		// 2025.05.22(목)
		Motorcycle myMotorcycle1 = new Motorcycle() ;
		System.out.println("(기본생성자) 차량정보 : " + myMotorcycle1.model);
		System.out.println(myMotorcycle1.company + myMotorcycle1.color + myMotorcycle1.maxSpeed);
		System.out.println();
		
		Motorcycle myMotorcycle2 = new Motorcycle ("스쿠터") ;
		System.out.println("차량정보 :" + myMotorcycle2.model);
		System.out.println(myMotorcycle2.company + myMotorcycle2.color + myMotorcycle2.maxSpeed);
		System.out.println();
		
		Motorcycle myMotorcycle3 = new Motorcycle ("스쿠터", "빨강") ;
		System.out.println("차량정보 :" + myMotorcycle3.model);
		System.out.println(myMotorcycle3.company + myMotorcycle3.color + myMotorcycle3.maxSpeed);
		System.out.println();
		
		
		Motorcycle myMotorcycle4 = new Motorcycle("전기모터", "파랑", 200) ;
		System.out.println("차량정보 :" + myMotorcycle4.model);
		System.out.println(myMotorcycle4.company + myMotorcycle4.color + myMotorcycle4.maxSpeed);
		System.out.println();
		
	} //main메서드종료

} //class 종료
