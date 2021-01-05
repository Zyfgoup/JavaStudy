package Data;
//���μ�¼��
import java.io.File;
public class LectureRecord {
	private  SpeakTeacher st;//�ڿ���ʦ
	private  ListenTeacher lt;//������ʦ
	private GradeClass gc;//�꼶�༶
	File file;
	public LectureRecord next;
	//���췽���������βΣ�
	public LectureRecord() {

	}
	//���췽�������βΣ�
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
	//��Ա������Getter Setter����
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
