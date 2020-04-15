/*GUI for registering account*/
package scholarshipGUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import scholarshipSystem.SystemHandler;

import javax.swing.JLabel;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterGUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private SystemHandler systemHandler;
	private GUIHandler guiHandler;

	/**
	 * Create the panel.
	 */
	public RegisterGUI(JFrame frame, SystemHandler systemHandler, GUIHandler guiHandler) {
		this.guiHandler = guiHandler;
		this.systemHandler = systemHandler;

		setBackground(new Color(239, 239, 239));

		JButton btnRegister = new JButton("Register");					//Create button "Register"//
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setFont(new Font("Arial", Font.PLAIN, 16));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegister.setBounds(74, 224, 296, 28);
		btnRegister.addMouseListener(new MouseAdapter() {				// Event handler for register button//
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Takes the user to the logged in page
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
			}
		});

		textField = new JTextField();									// Text field for "Username" Label//
		textField.setBounds(74, 80, 296, 28);
		textField.setColumns(10);

		textField_1 = new JTextField();									// Text field for "Password" Label//
		textField_1.setBounds(74, 131, 296, 28);
		textField_1.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");					// Create "Username" label//
		lblUsername.setForeground(new Color(103, 105, 107));
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUsername.setBounds(74, 64, 76, 14);

		JLabel lblPassword = new JLabel("Password:");					// Create "Password" Label//
		lblPassword.setForeground(new Color(103, 105, 107));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(74, 115, 90, 14);

		JLabel lblUniversityOfWinnipeg = new JLabel("University of Winnipeg Scholarships");	// Create school name label//
		lblUniversityOfWinnipeg.setBounds(102, 33, 253, 20);
		lblUniversityOfWinnipeg.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_2 = new JTextField();									// Text field for "Confirm Password" Label//
		textField_2.setBounds(74, 185, 296, 28);
		textField_2.setColumns(10);
		setLayout(null);

		JLabel lblConfirmPassword = new JLabel("Confirm Password:");	// Create label "Confirm password"//
		lblConfirmPassword.setForeground(new Color(103, 105, 107));
		lblConfirmPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblConfirmPassword.setBounds(74, 169, 175, 14);
		add(lblConfirmPassword);										// Add all the labels, buttons, textfields//
		add(lblUsername);
		add(lblPassword);
		add(btnRegister);
		add(textField_2);
		add(textField_1);
		add(textField);
		add(lblUniversityOfWinnipeg);

		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");	// Create label "Already have an account?"//
		lblAlreadyHaveAn.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAlreadyHaveAn.setForeground(Color.BLACK);
		lblAlreadyHaveAn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {					// Event handler if above label is clicked"//
				//
				//
				//
				//
				//
			}
		});
		lblAlreadyHaveAn.setBounds(102, 263, 192, 14);
		add(lblAlreadyHaveAn);

		JLabel lblLogin = new JLabel("Sign In");						// Create Sign in label//
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {					// Event handler for sign in, head to LoginGUI panel/
				LoginGUI panel = new LoginGUI(frame, systemHandler, guiHandler);
				frame.setContentPane(panel);
				frame.setVisible(true);
			}
		});
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLogin.setForeground(new Color(1, 112, 169));
		lblLogin.setBounds(287, 259, 52, 23);
		add(lblLogin);

	}
}
