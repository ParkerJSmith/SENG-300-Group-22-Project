package scholarshipSystem;

public class Admin extends User {
	private Scholarship scholarship;
	
	public Admin(String username, String password) {
		super(username, password);
	}
	
	public Scholarship getScholarship() {
		return this.scholarship;
	}
	
	public void setScholarship(Scholarship scholarship) {
		this.scholarship = scholarship;
	}
}
