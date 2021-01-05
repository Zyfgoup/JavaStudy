package Banking8.domain;

public class OverdraftException extends Exception {
	private double deficit;//表示所取的钱与余额的差额
	
	static final long serialVersionUID = -338751699824229948L;
	
	public double getDeficit() {
		return deficit;
	}
	
	public OverdraftException (String msg,double deficit) {
		super(msg);
		this.deficit=deficit;
	}
}
