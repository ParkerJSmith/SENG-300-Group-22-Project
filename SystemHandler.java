package scholarshipSystem;

import scholarshipGUI.GUIHandler;
import java.io.*;

public class SystemHandler {

	private AccountHandler accountHandler;
	private GUIHandler guiHandler;
	private ScholarshipDatabase database;

	public SystemHandler() {
		this.accountHandler = new AccountHandler();
			
		this.guiHandler = new GUIHandler(this);
		//Try to deserialize scholarships from file, otherwise use new scholarship database
		
		try {
			FileInputStream fIn = new FileInputStream("Scholarships.ser");
			ObjectInputStream in = new ObjectInputStream(fIn);
			database = (ScholarshipDatabase) in.readObject();
			in.close();
			fIn.close();
		} catch(IOException e) {
			System.out.println("Scholarships.ser not found. Creating new database...");
			this.database = new ScholarshipDatabase();
			addScholarship(new Scholarship("Test Scholarship"));
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		SystemHandler systemHandler = new SystemHandler();
		systemHandler.guiHandler.startGUI();

	}

	public AccountHandler getAccountHandler() {
		return this.accountHandler;
	}
	
	public void addScholarship(Scholarship scholarship) {
		database.addScholarship(scholarship);
		writeScholarshipDB();
	}
	
	public void removeScholarship(int index) {
		database.removeScholarship(index);
		writeScholarshipDB();
	}
	
	public String [] getScholarshipNames() {
		return database.getScholarshipNames();
	}
	
	public Scholarship getScholarship(int index) {
		return database.getScholarship(index);
	}
	
	private void writeScholarshipDB() {
	    try {
	    	FileOutputStream fOut = new FileOutputStream("Scholarships.ser");
	    	ObjectOutputStream out = new ObjectOutputStream(fOut);
	    	out.writeObject(database);
	    	out.close();
	    	fOut.close();
	    } catch (IOException e) {
	    	System.out.println("Scholarships.ser not found.");
	    	e.printStackTrace();
	    }
	    return;
	}

}
