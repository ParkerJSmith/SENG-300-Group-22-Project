package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class NominateStudent {

	private JFrame frmnStudent;
	private JTextField txtText;

	/**
	 * Launch the application.
	 */
	public static void nominateStudent() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NominateStudent window = new NominateStudent();
					window.frmnStudent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NominateStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmnStudent = new JFrame();
		frmnStudent.setTitle("Nominate Student");
		frmnStudent.setBounds(100, 100, 450, 300);
		frmnStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmnStudent.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student fund");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 205, 24);
		frmnStudent.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("$");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(32, 82, 6, 14);
		frmnStudent.getContentPane().add(lblNewLabel_1);
		
		txtText = new JTextField();
		txtText.setFont(new Font("Arial", Font.PLAIN, 11));
		txtText.setForeground(Color.BLACK);
		txtText.setBounds(42, 79, 92, 20);
		frmnStudent.getContentPane().add(txtText);
		txtText.setColumns(10);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.setBounds(144, 78, 89, 23);
		frmnStudent.getContentPane().add(btnNewButton);
	}

}
