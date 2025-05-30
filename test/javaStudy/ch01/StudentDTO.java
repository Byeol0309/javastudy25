package test.javaStudy.ch01;

public class StudentDTO {
	
		// 필드
		public String name ; 
		public String studentID ;
		public int kor ;
		public int mat ;
		public int eng ;
		public int avg ; 
		public String grade ; 
		
	
	
	// 생성자
		public StudentDTO(String name, String studentId, int kor, int mat, int eng, int avg, String grade) {
		
			this.name = name ;
			this.studentID = studentId;
			this.kor = kor;
			this.mat= mat;
			this.eng = eng ;
			this.avg = avg ;
			this.grade = grade;
		}
		
		public StudentDTO() {
			
		}
	
	// 메서드
	
	

}
