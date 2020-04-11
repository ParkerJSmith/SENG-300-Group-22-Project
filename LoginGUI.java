package scholarshipGUI;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

import scholarshipSystem.AccountHandler;
import scholarshipSystem.SystemHandler;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JPanel {

	private SystemHandler systemHandler;
	private AccountHandler accountHandler;
	private GUIHandler guiHandler;

	/**
	 * Create the panel.
	 */
	public LoginGUI(JFrame frame, SystemHandler systemHandler, GUIHandler guiHandler) {
		this.guiHandler = guiHandler;
		this.systemHandler = systemHandler;
		this.accountHandler = systemHandler.getAccountHandler();

		setBackground(new Color(239, 239, 239));

		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setBounds(74, 221, 296, 28);

		JTextField textField = new JTextField();
		textField.setBounds(74, 80, 296, 28);
		textField.setColumns(10);

		JPasswordField textField_1 = new JPasswordField();
		textField_1.setBounds(74, 131, 296, 28);
		textField_1.setColumns(10);
		textField_1.setEchoChar('*');

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(103, 105, 107));
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUsername.setBounds(74, 64, 76, 14);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(103, 105, 107));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(74, 115, 90, 14);

		JLabel lblUniversityOfWinnipeg = new JLabel("University of Winnipeg Scholarships");
		lblUniversityOfWinnipeg.setBounds(102, 33, 253, 20);
		lblUniversityOfWinnipeg.setFont(new Font("Arial", Font.PLAIN, 16));
		setLayout(null);
		add(lblUsername);
		add(lblPassword);
		add(btnLogin);
		add(textField_1);
		add(textField);
		add(lblUniversityOfWinnipeg);

		JLabel lblAlreadyHaveAn = new JLabel("Don't have an account?");
		lblAlreadyHaveAn.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAlreadyHaveAn.setForeground(Color.BLACK);

		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = textField.getText().trim();
				char[] passwordArray = textField_1.getPassword();
				String password = "";
				for (int i = 0; i < passwordArray.length; i++) {
					password += passwordArray[i];
				}
				if (accountHandler.verifyAccount(username, password) != null) {
					guiHandler.displayHomePage(accountHandler.verifyAccount(username, password));
				} else {
					System.out.println("The username or password were incorrect");
				}
			}
		});

		lblAlreadyHaveAn.setBounds(90, 260, 192, 18);
		add(lblAlreadyHaveAn);

		JLabel lblLogin = new JLabel("Register here");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterGUI panel = new RegisterGUI(frame, systemHandler, guiHandler);
				frame.setContentPane(panel);
				frame.setVisible(true);
			}
		});
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLogin.setForeground(new Color(1, 112, 169));
		lblLogin.setBounds(260, 260, 107, 18);
		add(lblLogin);

		JCheckBox chckbxRememberMe = new JCheckBox("Remember Me");
		chckbxRememberMe.setForeground(new Color(103, 105, 107));
		chckbxRememberMe.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxRememberMe.setBounds(74, 166, 133, 23);
		add(chckbxRememberMe);

	}
}
