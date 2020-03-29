package scholarshipSystem;

import scholarshipGUI.GUIHandler;

public class SystemHandler {

	private AccountHandler accountHandler;
	private GUIHandler guiHandler;
	private ScholarshipDatabase database;

	public SystemHandler() {
		this.accountHandler = new AccountHandler();
		this.guiHandler = new GUIHandler(this);
		this.database = new ScholarshipDatabase();
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
	}
	
	public String [] getScholarshipNames() {
		return database.getScholarshipNames();
	}

}
