package Data;

public class GradeClass {
	private String gradeclass;//�꼶�༶
	
	
	public GradeClass() {
		
	}
	public GradeClass(String gc) {//���췽��
		this.gradeclass = gc;
	}
	
	public void setGradeClass(String str) {//����or�޸��꼶�༶
		this.gradeclass = str;
	}
	
	public String getGradeClass() {//��ȡ�꼶�༶
		return this.gradeclass;
	}
}
