package Data;
//听课记录类
import java.io.File;
public class LectureRecord {
	private  SpeakTeacher st;//授课老师
	private  ListenTeacher lt;//听课老师
	private GradeClass gc;//年级班级
	File file;
	public LectureRecord next;
	//构造方法（不含形参）
	public LectureRecord() {

	}
	//构造方法（含形参）
	public LectureRecord(String path,String s,String l,String g) {
		file  = new File(path);
		this.st = new SpeakTeacher(s);
		this.lt = new ListenTeacher(l);
		this.gc = new GradeClass(g);
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	//成员变量的Getter Setter方法
	public SpeakTeacher getSt() {
		return st;
	}
	public void setSt(SpeakTeacher st) {
		this.st = st;
	}
	public ListenTeacher getLt() {
		return lt;
	}
	public void setLt(ListenTeacher lt) {
		this.lt = lt;
	}
	public GradeClass getGc() {
		return gc;
	}
	public void setGc(GradeClass gc) {
		this.gc = gc;
	}	
}
