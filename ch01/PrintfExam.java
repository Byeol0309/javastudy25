package ch01;

public class PrintfExam {

	public static void main(String[] args) {
		int i = 97 ;
		String s = "Java" ;
		double f = 3.14 ;
	    // printf("���� �����", ������1, ������2  ) 
		//   %( )   -> ������ ���˿� ���߾� ��µ�.
		// �⺻�� : ������ ����
		//   -  : ���� ����
		//   f- : �Ǽ���
		//   e- : ������
		//  .1  : .(����) -> ���� ��ŭ�� �Ҽ��� ���� ǥ��, .(����)�� ĭ�� ������.
		//  \n  :(�ٹٲ�)
		// d (10����)
		// o (8����)
		// x (16����)
		// c  a(char)
		
		System.out.printf("%d\n", i); // 10����
		System.out.printf("%o\n", i); // 8����
		System.out.printf("%x\n", i); // 16����
		System.out.printf("%c\n", i); // a(char)
		System.out.printf("%5d\n", i); // (����)d , (����)��ŭ�� ĭ�� �����.
		System.out.printf("%05d\n", i); // (����)d ��ŭ�� 0�� ����� �ִ´�.
		System.out.printf("%s\n","java"); // s (string)���ڿ��� �ִ´�.
		System.out.printf("%-5s\n", "java"); // 5ĭ�� �����, 
		                                    // s(string)�� ��������(1)�ؼ� �ִ´�. 
		System.out.printf("%4.1f\n",f);
		System.out.printf("%3d\n", i);
		System.out.printf("%03d\n", i);
		System.out.printf("%04d\n", i);
		System.out.printf("%05d\n", i);
		
		System.out.printf("%s\n",s);
		System.out.printf("%5s\n", s);
		System.out.printf("%-5s\n", s);
		System.out.printf("%f\n", f);
		System.out.printf("%e\n", f);
		System.out.printf("%4.1f\n", f);
		System.out.printf("%04.1f\n", f);
		System.out.printf("%-4.1f\n", f);
		
		

	} // main �޼��� ����

} // Ŭ���� ����
