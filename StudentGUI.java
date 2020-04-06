package scholarshipGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scholarshipSystem.SystemHandler;
import scholarshipSystem.User;

public class StudentGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public StudentGUI(JFrame frame, SystemHandler systemHandler, User user) {
		frame.setTitle("Student");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBackground(SystemColor.control);
		frame.getContentPane().add(this, BorderLayout.CENTER);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Student");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 11, 91, 22);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Scholarship");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(178, 61, 125, 22);
		add(lblNewLabel_1);

		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Makes ViewScholarship window when clicked

				ViewScholarshipGUI vs = new ViewScholarshipGUI(frame, systemHandler, user);
				frame.setContentPane(vs);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		btnNewButton.setBounds(172, 104, 89, 23);
		add(btnNewButton);
	}

}
