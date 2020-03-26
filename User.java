package scholarshipSystem;
public abstract class User {

	private String password, username;

	public User(String username, String password) {
		this.password = password;
		this.username = username;
	}
	
	public User getUser(String username, String password) {
		if (this.username.equals(password) && checkPassword(password)) {
			return this;
		} else {
			return null;
		}
	}
	
	public String getUsername() {
		return new String(username);
	}
	
	public boolean checkPassword(String inputPassword) {
		return inputPassword.equals(this.password);
	}
	
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}

}
