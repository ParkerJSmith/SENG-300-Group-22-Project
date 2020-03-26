package scholarshipSystem;

import scholarshipGUI.GUIHandler;

public class SystemHandler {

	private AccountHandler accountHandler;
	private GUIHandler guiHandler;

	public SystemHandler() {
		this.accountHandler = new AccountHandler();
		this.guiHandler = new GUIHandler(this);
	}

	public static void main(String[] args) {

		SystemHandler systemHandler = new SystemHandler();
		systemHandler.guiHandler.startGUI();

	}

	public AccountHandler getAccountHandler() {
		return this.accountHandler;
	}

}
