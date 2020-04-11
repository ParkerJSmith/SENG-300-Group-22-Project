package scholarshipSystem;
import java.io.*;
import java.util.ArrayList;

public class AccountHandler implements java.io.Serializable {

	private ArrayList<User> accounts;
	
	@SuppressWarnings("unchecked")
	public AccountHandler() {
		//Try to deserialize accounts from file, otherwise use new accounts
		
		try {
			FileInputStream fIn = new FileInputStream("Accounts.ser");
			ObjectInputStream in = new ObjectInputStream(fIn);
			accounts = (ArrayList<User>) in.readObject();
			in.close();
			fIn.close();
		} catch(IOException e) {
			System.out.println("Accounts.ser not found. Creating new accounts...");
			this.accounts = new ArrayList<User>();
			addAccount(new Admin("Admin", "password"));
			addAccount(new Student("Student", "password"));
			addAccount(new Professor("Professor", "password"));
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		//In final version will read from file to load all users
		//For demo purposes users are hardcoded in
		
	}
	
	public User verifyAccount(String username, String password) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getUsername().equals(username) && accounts.get(i).checkPassword(password)) {
				return accounts.get(i);
			}
		}
		return null;
	}
	
	private void addAccount(User user) {
		this.accounts.add(user);
		writeAccounts();
	}
	
	private void writeAccounts() {
		try {
	    	FileOutputStream fOut = new FileOutputStream("Accounts.ser");
	    	ObjectOutputStream out = new ObjectOutputStream(fOut);
	    	out.writeObject(accounts);
	    	out.close();
	    	fOut.close();
	    } catch (IOException e) {
	    	System.out.println("Accounts.ser not found.");
	    	e.printStackTrace();
	    }
	    return;
	}
}
