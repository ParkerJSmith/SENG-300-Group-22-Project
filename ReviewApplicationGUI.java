/* GUI to review student applications for scholarships*/
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
		
		JLabel lastName = new JLabel("Last name: ");			//Create "Last Name" label//
		lastName.setBounds(69, 135, 90, 14);
		getContentPane().add(lastName);

		JLabel firstName = new JLabel("First name: ");			//Create "First name" label//
		firstName.setBounds(68, 166, 90, 14);
		getContentPane().add(firstName);
		
		JLabel id = new JLabel("Student ID: ");					// Create "Student id" label//
		id.setBounds(66, 197, 90, 14);
		getContentPane().add(id);
		
		JLabel dateOfBirth = new JLabel("Date of birth: ");		//Create DOB label//
		dateOfBirth.setBounds(57, 228, 90, 14);
		getContentPane().add(dateOfBirth);
		
		JLabel yearOfStudy = new JLabel("Year of study: ");		//Create "Year of study" label//
		yearOfStudy.setBounds(52, 256, 90, 14);
		getContentPane().add(yearOfStudy);
		
		JTextField textField = new JTextField();				//Create textfield for last name label//
		textField.setEditable(false);
		textField.setText(application.getLastName());			// Get last name//
		textField.setBounds(140, 132, 120, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();				//Create textfield for first name label//
		textField_1.setEditable(false);
		textField_1.setText(application.getFirstName());		//Get first name//
		textField_1.setBounds(140, 163, 120, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textField_2 = new JTextField();				//Create textfield for Student ID label//
		textField_2.setEditable(false);
		textField_2.setText("" + application.getID());			//Get Student ID//
		textField_2.setBounds(140, 194, 120, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();				//Create textfield for DOB label//
		textField_3.setEditable(false);
		textField_3.setText(application.getDate().toString());	// get date//
		textField_3.setBounds(140, 225, 120, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JTextField textField_5 = new JTextField();				//Create textfield for year of study label//
		textField_5.setEditable(false);
		textField_5.setText("" + application.getYear());		// Get YOS//
		textField_5.setBounds(140, 253, 120, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JTextField textField_4 = new JTextField();				//Create textfield for Faculty label//
		textField_4.setEditable(false);
		textField_4.setText("" + application.getFaculty());		// get Faculty//
		textField_4.setColumns(10);
		textField_4.setBounds(140, 281, 120, 20);
		panel.add(textField_4);
		
		JLabel facultyField = new JLabel("Faculty: ");			//create Faculty Label//
		facultyField.setBounds(82, 284, 90, 14);
		panel.add(facultyField);
		
		JList list = new JList(application.getFilePaths());
		list.setBounds(140, 312, 379, 152);
		panel.add(list);
		JButton openBtn = new JButton("Open");					//Create button "Open"//
		openBtn.setBounds(57, 441, 73, 23);
		openBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			// Event handler if open is clicked//
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
		
		JButton approveBtn = new JButton("Approve");			// Create Approve button//
		approveBtn.setBounds(351, 506, 73, 23);
		approveBtn.addMouseListener(new MouseAdapter() {		//Event handler if approve button is clicked//
			@Override
			public void mouseClicked(MouseEvent arg0) {
				application.setStatus(Application.APPROVED);
				dispose();
			}
		});
		panel.add(approveBtn);
		
		JButton btnReject = new JButton("Reject");				// Create Reject button//
		btnReject.setBounds(434, 506, 73, 23);
		btnReject.addMouseListener(new MouseAdapter() {			// Event handler if reject is clicked"
			@Override
			public void mouseClicked(MouseEvent arg0) {
				application.setStatus(Application.REJECTED);
				dispose();
			}
		});
		panel.add(btnReject);
		
		JButton btnClose = new JButton("Close");				// Create Close button//
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			// Event handler if close is clicked, dispose() invoked//
				dispose();
			}
		});
		btnClose.setBounds(57, 506, 73, 23);
		panel.add(btnClose);
		
		setVisible(true);
	}
}
