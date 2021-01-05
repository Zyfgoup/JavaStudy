package Banking7.domain;

public class OverdraftException extends Exception {
	private double deficit;//��ʾ��ȡ��Ǯ�����Ĳ��
	
	static final long serialVersionUID = -338751699824229948L;
	
	public double getDeficit() {
		return deficit;
	}
	
	public OverdraftException (String msg,double deficit) {
		super(msg);
		this.deficit=deficit;
	}
}
