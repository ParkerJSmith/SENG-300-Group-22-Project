/*The GUI for the application of scholarships*/
package scholarshipGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import scholarshipSystem.Application;
import scholarshipSystem.OpenFile;
import scholarshipSystem.Scholarship;
import scholarshipSystem.Student;
import scholarshipSystem.SystemHandler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ApplicationGUI extends JFrame {

	/**
	 * Create the frame.
	 */

	ArrayList<String> files = new ArrayList<>();

	public ApplicationGUI(Student student, Scholarship scholarship, SystemHandler systemHandler) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 610);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Application Form");						//Create label, "Application Form"//
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle.setBounds(163, 11, 212, 31);
		contentPane.add(lblTitle);

		JLabel lblLastName = new JLabel("Last Name:");							// Create label, "Last Name"//
		lblLastName.setBounds(71, 62, 79, 20);
		contentPane.add(lblLastName);

		JLabel lblFirstName = new JLabel("First Name:");						// Create label, "First Name"//
		lblFirstName.setBounds(71, 93, 79, 14);
		contentPane.add(lblFirstName);

		JLabel lblStudyYear = new JLabel("Year of Study:");						// Create label, "Year of Study"//
		lblStudyYear.setBounds(71, 209, 101, 20);
		contentPane.add(lblStudyYear);

		JLabel lblGPA = new JLabel("Estimated GPA:");							// Create label, "Estimated GPA:"//
		lblGPA.setBounds(71, 240, 101, 14);
		contentPane.add(lblGPA);

		JButton btnNewButton_1 = new JButton("Cancel");							// Create Button, labelled "Cancel"//
		btnNewButton_1.setBounds(301, 524, 89, 23);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {							// Event handler if "Cancel" is clicked//
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(71, 325, 435, 161);
		contentPane.add(textArea);

		JButton btnNewButton_2 = new JButton("Browse"); 						// Create "Browse" Button//
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {							// Select file from users computer//
				OpenFile openfile = new OpenFile();
				try {
					files.add(openfile.pick());
					String text = "";
					for (int i = 0; i < files.size(); i++) {
						text += files.get(i) + "\n";
					}
					textArea.setText(text);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(145, 297, 89, 23);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_4 = new JLabel("Select Files:");						// create Label "Select Files:" next to the button "Browse"//
		lblNewLabel_4.setBounds(71, 302, 101, 12);
		contentPane.add(lblNewLabel_4);

		JLabel lblDate = new JLabel("Date:");									// Create label, "Date"//
		lblDate.setBounds(71, 153, 63, 20);
		contentPane.add(lblDate);

		JLabel lblNewLabel_1 = new JLabel("Faculty:");							// Create label, "Faculty"//
		lblNewLabel_1.setBounds(71, 184, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ID Number:");						// Create label, "ID Number"//
		lblNewLabel_2.setBounds(71, 128, 79, 14);
		contentPane.add(lblNewLabel_2);

		JTextField textField = new JTextField();								// Text field for the "Estimated GPA" Label//
		textField.setBounds(160, 237, 178, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JTextField textField_1 = new JTextField();								// Text field for the "Year of study" Label//
		textField_1.setBounds(160, 209, 178, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JTextField textField_2 = new JTextField();
		textField_2.setText("" + student.getFaculty());
		textField_2.setEditable(false);
		textField_2.setBounds(160, 181, 178, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JTextField dateField = new JTextField();								// Gets date for "Date" text field"//
		Calendar date = new GregorianCalendar();
		String dateString = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH) + 1) + "/"
				+ date.get(Calendar.DAY_OF_MONTH);
		dateField.setText(dateString);
		dateField.setEditable(false);
		dateField.setBounds(160, 153, 178, 20);
		contentPane.add(dateField);
		dateField.setColumns(10);

		JTextField textField_4 = new JTextField();								// Text field for the "ID Number" Label//
		textField_4.setText(student.getStudentID());	
		textField_4.setEditable(false);
		textField_4.setBounds(160, 125, 178, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JTextField textField_5 = new JTextField();								// Text field for the "First Name" Label//
		textField_5.setBounds(160, 90, 178, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JTextField textField_6 = new JTextField();								// Text field for the "Last Name" Label//
		textField_6.setBounds(160, 62, 178, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JButton btnNewButton = new JButton("Confirm");							// Create button "Confirm"//
		btnNewButton.setBounds(175, 524, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {							// Event handler if "Confirm" button is clicked"
																				// Assures no illegal arguments are passed through
				if (Double.parseDouble(textField.getText()) <= 4.0) {
																				// Checks to verify that student has high enough GPA and is in the correct faculty//
					if (scholarship.getFaculty() == student.getFaculty()
							&& Double.parseDouble(textField.getText()) >= scholarship.getMinGPA()) {
						// Student passes automated requirements and application is then fed into the
						// application system.

						String[] array = new String[files.size()];
						for (int i = 0; i < files.size(); i++) {
							array[i] = files.get(i);
						}

						Application application = new Application(textField_6.getText(), textField_5.getText(),
								textField_4.getText(), date, student.getFaculty(),
								Integer.parseInt(textField_1.getText()), Double.parseDouble(textField.getText()),
								scholarship, student, array);
						student.addApplication(application);

						systemHandler.addApplication(application);
					} else {
																				// Since student failed certain requirements, scholarship is added only to list
																				// of applied scholarships, but is not
																				// added to the database. Application is rejected immediately and scholarship
																				// stats are not affected.
						student.addApplication(
								new Application(textField_6.getText(), textField_5.getText(), textField_4.getText(),
										date, student.getFaculty(), Integer.parseInt(textField_1.getText()),
										Double.parseDouble(textField.getText()), scholarship, student, 0));

					}
					setVisible(false);
				}
			}
		});

		setVisible(true);
	}
}
