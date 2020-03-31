package scholarshipSystem;
import java.util.ArrayList;

public class AccountHandler {

	private ArrayList<User> accounts = new ArrayList<User>();
	
	public AccountHandler() {
		//In final version will read from file to load all users
		//For demo purposes users are hardcoded in
		
		accounts.add(new Admin("Admin", "password"));
		accounts.add(new Student("Student", "password"));
		accounts.add(new Professor("Professor", "password"));
	}
	
	public User verifyAccount(String username, String password) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getUsername().equals(username) && accounts.get(i).checkPassword(password)) {
				return accounts.get(i);
			}
		}
		return null;
	}
	
}
