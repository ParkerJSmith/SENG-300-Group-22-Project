abstract class User {

	private String password, username;

	public User(String password, String username) {
		this.password = password;
		this.username = username;
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
