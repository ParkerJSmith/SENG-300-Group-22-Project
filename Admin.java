
public class Admin extends User {
	private Scholarship x;
	
	public Admin(String password, String username) {
		super(password, username);
	}
	
	public Scholarship getScholarship() {
		return this.Scholarship;
	}
	
	public void setScholarship() {
		return this.Scholarship;
	}
}
