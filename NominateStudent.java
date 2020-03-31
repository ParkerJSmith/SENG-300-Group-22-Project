package scholarshipGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;

import scholarshipSystem.SystemHandler;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;

public class NominateStudent extends JPanel {

	/**
	 * Create the application.
	 */
	public NominateStudent(JFrame frame, SystemHandler systemHandler) {
		setVisible(false);
		frame.setTitle("Nominate Student");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBackground(SystemColor.control);
		frame.getContentPane().add(this, BorderLayout.CENTER);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Student fund");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 205, 24);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("$");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(32, 82, 6, 14);
		add(lblNewLabel_1);

		JTextField txtText = new JTextField();
		txtText.setFont(new Font("Arial", Font.PLAIN, 11));
		txtText.setForeground(Color.BLACK);
		txtText.setBounds(42, 79, 92, 20);
		add(txtText);
		txtText.setColumns(10);

		JButton btnNewButton = new JButton("Accept");
		btnNewButton.setBounds(144, 78, 89, 23);
		add(btnNewButton);
		setVisible(true);
	}

}
