package scholarshipSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import scholarshipGUI.GUIHandler;

public class SystemHandler {

	private AccountHandler accountHandler;
	private GUIHandler guiHandler;
	private ScholarshipDatabase database;
	private ApplicationHandler applicationHandler;

	public SystemHandler() {
		this.accountHandler = new AccountHandler();
		this.guiHandler = new GUIHandler(this);
		this.applicationHandler = new ApplicationHandler();
		
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
		
		systemHandler.addScholarship(new Scholarship("Test Scholarship"));
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
	
	public String [] getScholarshipNames() {
		return database.getScholarshipNames();
	}
	
	public Scholarship getScholarship(int index) {
		return database.getScholarship(index);
	}
	
	public String [] getApplicationNames() {
		return applicationHandler.getApplicationNames();
	}
	
	public int getAppSize() {
		return applicationHandler.size();
	}
	
	public void addApplication(Application application) {
		applicationHandler.addApplication(application);
	}
	
	public Application getApplication(int index) {
		return applicationHandler.getApplication(index);
	}
	
	public boolean checkStudentID(String id) {
		return accountHandler.checkStudentID(id);
	}
	
	public Student getStudent(String id) {
		return accountHandler.getStudent(id);
	}
	
	public boolean checkNominatable(int index) {
		return database.checkNominatable(index);
	}

}
