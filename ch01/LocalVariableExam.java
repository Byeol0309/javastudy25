package ch01;

/*
�ۼ��� : �����
�ۼ��� : 2025-05-02
�ۼ�ȸ�� : ���� ��ī����
��ǥ : ���� ��� ����

*/
public class LocalVariableExam {
	
	public static void main(String[] args) {
		// ������ ��� ������ ��ȣ(��)�ȿ��� ȿ���� �����Ѵ�.
		
		int v1 = 5 ;
		int v2 = 0 ; // ������ ������ �� �� ��
		
		if(v1>10) { // if�� �񱳹����� ()���� ���̸� ���� �����Ѵ�.
			v2 = v1 + 10 ;
			
		} // if�� ����
	
		int v3 = v1 + v2 + 5 ;
		
		System.out.println("v1�� �� :"+ v1);
		System.out.println("v2�� �� :"+ v2);
		System.out.println("v3�� �� :"+ v3);
		
		
		
	}// ���θ޼ҵ� ����
	
}//LocalVariableExam����
