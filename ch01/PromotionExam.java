package ch01;

public class PromotionExam {

	public static void main(String[] args) {
		// �ڵ� Ÿ�� ��ȯ ����
		// byte(1byte : 8bit)
		// shot(2byte : 16bit) & char(�����ڵ�� : ����ǥ��)
		// int (4byte : 32bit)
		// long(8byte : 64bit)  ���̻� L
		// float(4byte : 32bit) �Ǽ��� ���̻� F
		// double(8byte : 64bit)
		
		byte byteValue = 10 ; // ����Ʈ Ÿ���� ������ 10���� ����.
		int intValue = byteValue ; // �ڵ�Ÿ�Ժ�ȯ��.
		
		System.out.println("�ڵ�Ÿ�� �� int : " + intValue);
		// �ڵ�Ÿ�� �� int : 10
		
		
		char charValue = '��' ;
		intValue = charValue ;
		System.out.println("�ڵ�Ÿ�� �� int : " + intValue);
		// �ڵ�Ÿ�� �� int : 44032
		
		
		intValue = 500 ;
		long longValue = intValue ; 
		System.out.println("�ڵ�Ÿ�� �� long : " + longValue);
		// �ڵ�Ÿ�� �� long : 500
		
		double doubleValue = intValue ; 
		System.out.println("�ڵ�Ÿ�� �� double : " + doubleValue);
		// �ڵ�Ÿ�� �� double : 500.0

		
		
	} // ���θ޼ҵ� ����

} // Ŭ���� ����
