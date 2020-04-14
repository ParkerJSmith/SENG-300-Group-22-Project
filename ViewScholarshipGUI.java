package scholarshipGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import scholarshipSystem.Admin;
import scholarshipSystem.Student;
import scholarshipSystem.SystemHandler;
import scholarshipSystem.User;

public class ViewScholarshipGUI extends JPanel {

	JList list;
	SystemHandler systemHandler;
	DefaultListModel model;

	public ViewScholarshipGUI(JFrame frame, SystemHandler systemHandler, User user) {
		this.systemHandler = systemHandler;
		model = new DefaultListModel();

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

		list = new JList(model);
		list.setBounds(147, 46, 306, 244);
		add(list);

		JButton backButton = new JButton("Back");
		add(backButton);

		if (user instanceof Admin) {
			backButton.setBounds(29, 254, 89, 23);
			backButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					frame.setContentPane(new AdminGUI(frame, systemHandler, user));
				}
			});

			JButton btnRemove = new JButton("Remove");
			btnRemove.setBounds(29, 227, 89, 23);
			add(btnRemove);
			btnRemove.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int listIndex = list.getSelectedIndex();
					if (listIndex > -1) {
						int n = JOptionPane.showConfirmDialog(frame,
								"Are you sure you want to delete this scholarship? This cannot be undone.", "Warning",
								JOptionPane.YES_NO_OPTION);
						if (n == 0) {
							systemHandler.removeScholarship(listIndex);
							model.remove(listIndex);
						}
					}
				}
			});

			JButton btnNewButton = new JButton("Add");
			btnNewButton.setBounds(29, 200, 89, 23);
			add(btnNewButton);
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					AddScholarshipGUI panel = new AddScholarshipGUI(frame, systemHandler, user);
					frame.setContentPane(panel);
				}
			});
		}

		if (user instanceof Student) {
			Student student = (Student)user;
			backButton.setBounds(29, 227, 89, 23);
			backButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					frame.setContentPane(new StudentGUI(frame, systemHandler, user));
				}
			});

			JButton btnNewButton = new JButton("Apply");
			btnNewButton.setBounds(29, 200, 89, 23);
			add(btnNewButton);
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (list.getSelectedIndex() >= 0 && !student.checkAppliedMax()) {
						new ApplicationGUI((Student) user, systemHandler.getScholarship(list.getSelectedIndex()),
								systemHandler);
					}
				}
			});
		}
	}

}
