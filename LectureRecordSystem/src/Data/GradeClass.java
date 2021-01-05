package Data;

public class GradeClass {
	private String gradeclass;//年级班级
	
	
	public GradeClass() {
		
	}
	public GradeClass(String gc) {//构造方法
		this.gradeclass = gc;
	}
	
	public void setGradeClass(String str) {//设置or修改年级班级
		this.gradeclass = str;
	}
	
	public String getGradeClass() {//获取年级班级
		return this.gradeclass;
	}
}
