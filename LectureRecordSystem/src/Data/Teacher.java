package Data;

public class Teacher {
	private String name;//老师的名字
	
	public Teacher() {
		
	}
	public Teacher(String str) {
		name = str;
	}
	public void setName(String n) {//设置名字
		name = n;
	}
	
	public String getName() {//获取名字
		return name;
	}
}
