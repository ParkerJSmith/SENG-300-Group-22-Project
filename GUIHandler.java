package scholarshipGUI;

import scholarshipSystem.Admin;
import scholarshipSystem.Professor;
import scholarshipSystem.Student;
import scholarshipSystem.SystemHandler;
import scholarshipSystem.User;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUIHandler {

	private JFrame frame;
	private SystemHandler systemHandler;

	/**
	 * Launch the application.
	 */
	public void startGUI() {
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public GUIHandler(SystemHandler systemHandler) {
		this.systemHandler = systemHandler;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame = new JFrame();
		LoginGUI panel = new LoginGUI(frame, systemHandler, this);
		frame.setBounds(100, 100, 454, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	
	protected void displayHomePage(User user) {
		if (user instanceof Admin) {
			frame.setContentPane(new AdminGUI(frame, systemHandler, user));
		} else if (user instanceof Student) {
			frame.setContentPane(new StudentGUI(frame, systemHandler, user));
		} else if (user instanceof Professor) {
			frame.setContentPane(new ProfessorGUI(frame, systemHandler, user));
		}
	}

}
