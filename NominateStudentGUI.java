package scholarshipGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import scholarshipSystem.Admin;
import scholarshipSystem.Application;
import scholarshipSystem.Student;
import scholarshipSystem.SystemHandler;
import scholarshipSystem.User;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class NominateStudentGUI extends JPanel {

	/**
	 * Create the application.
	 */
	public NominateStudentGUI(JFrame frame, SystemHandler systemHandler, User user, Student student) {
		setVisible(false);
		frame.setTitle("Nominate Student");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultListModel model = new DefaultListModel();

		String scholarships[] = systemHandler.getScholarshipNames();

		for (int i = 0; i < scholarships.length; i++) {
			model.addElement(scholarships[i]);
		}

		frame.setTitle("Scholarship");
		frame.setBounds(100, 100, 479, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		setBounds(0, 0, 463, 301);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Scholarships");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(29, 11, 125, 24);
		add(lblNewLabel);

		JTextField textField = new JTextField();
		textField.setBounds(29, 90, 86, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Search:");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(29, 76, 46, 14);
		add(lblNewLabel_1);

		JList list = new JList(model);
		list.setBounds(147, 46, 306, 244);
		add(list);

		JButton backButton = new JButton("Back");
		add(backButton);

		backButton.setBounds(29, 227, 89, 23);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setContentPane(new AdminGUI(frame, systemHandler, user));
			}
		});

		JButton btnNewButton = new JButton("Nominate");
		btnNewButton.setBounds(29, 200, 89, 23);
		add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int listIndex = list.getSelectedIndex();

				if (!systemHandler.checkNominatable(listIndex)) {
					JOptionPane.showMessageDialog(frame, "This scholarship does not accept nominations.",
							"Nomination Failure", JOptionPane.WARNING_MESSAGE);
				} else if (listIndex > -1) {
					int n = JOptionPane.showConfirmDialog(frame,
							"Confirm nomination of student?", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (n == 0) {
						Application application = new Application(student, systemHandler.getScholarship(listIndex));
						systemHandler.addApplication(application);
						student.addApplication(application);
					}
				}
			}
		});
		setVisible(true);
	}

}
