package Banking5_2;

public class Customer {
	private String firstname;
	private String lastname;
	private SavingAccount savingaccount;
	private CheckingAccount checkingaccount;
	
	public Customer(String f,String l) {
		firstname=f;
		lastname=l;

	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public SavingAccount getSaving() {
		return savingaccount;
	}

	public void setSaving(SavingAccount savingaccount) {
		this.savingaccount = savingaccount;
	}

	public CheckingAccount getChecking() {
		return checkingaccount;
	}

	public void setChecking(CheckingAccount checkingaccount) {
		this.checkingaccount = checkingaccount;
	}
	
}
