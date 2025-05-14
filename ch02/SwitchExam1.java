package ch02;

public class SwitchExam1 {

	public static void main(String[] args) {
		// �ֻ��� ����
		int num = (int)(Math.random()*6) + 1 ;
		
		switch(num) {
		case 1 :
			System.out.println(" ");
			break;
		case 2 :
			System.out.println(" ");
			break;
		case 3 :
			System.out.println(" ");
			break;
		case 4 :
			System.out.println(" ");
			break;
		case 5 :
			System.out.println("5���� ���Խ��ϴ�.");
			break;
		case 6 :
			System.out.println("6���� ���Խ��ϴ�.");
			break;
		default :
			System.out.println("���α׷� ������ �ֻ����� ���峵���ϴ�.");
			break;
		
		} //switch문 종료
		
	int time =  (int)(Math.random()*6)+6 ;
	System.out.println(" [ 현재시간은 :" + time + "시 ]");
	switch(time) {
	case 7 :
		System.out.println("세수를 합니다");
	case 8 :
		System.out.println("스트레칭을 합니다.");
	case 9 :
		System.out.println("학원에 갑니다.");
	
	}
	

	} // main 메서드 종료

} // class 종료
