package scholarshipGUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import scholarshipSystem.Application;
import scholarshipSystem.Student;
import scholarshipSystem.SystemHandler;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ReviewApplicationGUI extends JFrame {
	
	public ReviewApplicationGUI(Student student, Application application, SystemHandler systemHandler) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 610);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lastName = new JLabel("Last name: ");
		lastName.setBounds(69, 135, 90, 14);
		getContentPane().add(lastName);

		JLabel firstName = new JLabel("First name: ");
		firstName.setBounds(68, 166, 90, 14);
		getContentPane().add(firstName);
		
		JLabel id = new JLabel("Student ID: ");
		id.setBounds(66, 197, 90, 14);
		getContentPane().add(id);
		
		JLabel dateOfBirth = new JLabel("Date of birth: ");
		dateOfBirth.setBounds(57, 228, 90, 14);
		getContentPane().add(dateOfBirth);
		
		JLabel yearOfStudy = new JLabel("Year of study: ");
		yearOfStudy.setBounds(52, 256, 90, 14);
		getContentPane().add(yearOfStudy);
		
		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setText(application.getLastName());
		textField.setBounds(140, 132, 120, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(application.getFirstName());
		textField_1.setBounds(140, 163, 120, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("" + application.getID());
		textField_2.setBounds(140, 194, 120, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText(application.getBirthDate());
		textField_3.setBounds(140, 225, 120, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JTextField textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setText("" + application.getYear());
		textField_5.setBounds(140, 253, 120, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JTextField textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText("" + application.getFaculty());
		textField_4.setColumns(10);
		textField_4.setBounds(140, 281, 120, 20);
		panel.add(textField_4);
		
		JLabel facultyField = new JLabel("Faculty: ");
		facultyField.setBounds(82, 284, 90, 14);
		panel.add(facultyField);
		
		JList list = new JList(application.getFilePaths());
		list.setBounds(140, 312, 379, 152);
		panel.add(list);
		JButton openBtn = new JButton("Open");
		openBtn.setBounds(57, 441, 73, 23);
		openBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (list.getSelectedIndex() >= 0) {
				try {
					Desktop.getDesktop().open(new File((String) list.getSelectedValue()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		panel.add(openBtn);
		
		JButton approveBtn = new JButton("Approve");
		approveBtn.setBounds(351, 506, 73, 23);
		approveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				application.setStatus(Application.APPROVED);
				dispose();
			}
		});
		panel.add(approveBtn);
		
		JButton btnReject = new JButton("Reject");
		btnReject.setBounds(434, 506, 73, 23);
		btnReject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				application.setStatus(Application.REJECTED);
				dispose();
			}
		});
		panel.add(btnReject);
		
		JButton btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(57, 506, 73, 23);
		panel.add(btnClose);
		
		setVisible(true);
	}
}
