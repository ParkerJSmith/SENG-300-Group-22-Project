package scholarshipGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import scholarshipSystem.Faculty;
import scholarshipSystem.Scholarship;
import scholarshipSystem.SystemHandler;
import scholarshipSystem.User;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.JTextArea;

public class AddScholarshipGUI extends JPanel {

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddScholarshipGUI(JFrame frame, SystemHandler systemHandler, User user) {
		frame.setBounds(100, 100, 453, 430);
		frame.getContentPane().setLayout(null);
		setLayout(null);

		JLabel lblAddScholarship = new JLabel("Add Scholarship");
		lblAddScholarship.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddScholarship.setBounds(124, 11, 213, 37);
		add(lblAddScholarship);

		JLabel lblSchoalrshipName = new JLabel("Name:");
		lblSchoalrshipName.setBounds(11, 75, 31, 14);
		add(lblSchoalrshipName);

		JLabel lblScholarshipDepartment = new JLabel("Department:");
		lblScholarshipDepartment.setBounds(11, 100, 61, 14);
		add(lblScholarshipDepartment);

		JLabel lblLevel = new JLabel("Deadline:");
		lblLevel.setBounds(11, 124, 60, 14);
		add(lblLevel);

		JLabel lblRequirements = new JLabel("Requirements: ");
		lblRequirements.setBounds(11, 149, 73, 14);
		add(lblRequirements);

		JLabel lblAvailibility = new JLabel("Availibility:");
		lblAvailibility.setBounds(11, 215, 51, 14);
		add(lblAvailibility);

		JLabel lblAward_Amount = new JLabel("Award Amount:");
		lblAward_Amount.setBounds(11, 240, 75, 14);
		add(lblAward_Amount);
		
		JLabel lblnominate = new JLabel("Allow nominations: ");
		lblnominate.setBounds(11, 281, 200, 20);
		add(lblnominate);
		
		JLabel lblminGPA = new JLabel("Minimum GPA: ");
		lblminGPA.setBounds(11, 261, 200, 20);
		add(lblminGPA);
		
		JCheckBox nominateBool = new JCheckBox();
		nominateBool.setBounds(110, 282, 23, 23);
		add(nominateBool);

		JTextField textField = new JTextField();
		textField.setBounds(113, 72, 247, 20);
		add(textField);
		textField.setColumns(10);

		JTextField textYear = new JTextField();
		textYear.setText("YYYY");
		textYear.setBounds(113, 120, 40, 20);
		add(textYear);
		JTextField textMonth = new JTextField();
		textMonth.setText("MM");
		textMonth.setBounds(155, 120, 40, 20);
		add(textMonth);
		JTextField textDay = new JTextField();
		textDay.setText("DD");
		textDay.setBounds(197, 120, 40, 20);
		add(textDay);
		

		String[] facultyNames = { "Arts", "Medicine", "Architecture", "Graduate Studies", "Business", "Kinesiology",
				"Law", "Nursing", "Engineering", "Science", "Social Work", "Veterinary", "Education", "Open Studies", "Continuing Education" };

		JComboBox<String> facultyBox = new JComboBox<String>(facultyNames);
		facultyBox.setBounds(113, 97, 247, 20);
		add(facultyBox);
		// textField_2.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textArea.setBounds(113, 144, 247, 60);
		add(textArea);

		JTextField textField_4 = new JTextField();
		textField_4.setBounds(113, 212, 247, 20);
		add(textField_4);
		textField_4.setColumns(10);

		JTextField textField_5 = new JTextField();
		textField_5.setBounds(113, 237, 247, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		JTextField minGPAText = new JTextField();
		minGPAText.setBounds(113, 262, 40, 20);
		add(minGPAText);

		JButton btnPublish = new JButton("Publish");
		btnPublish.setBounds(11, 320, 65, 23);
		add(btnPublish);
		btnPublish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String s = textArea.getText();
				Scanner sc = new Scanner(s);
				ArrayList<String> requirements = new ArrayList<String>();
				int i = 0;
				while (sc.hasNext()) {
					requirements.add(sc.nextLine());
					i++;
				}
				sc.close();

				String reqArray[] = new String[i];

				for (int j = 0; j < requirements.size(); j++) {
					reqArray[j] = requirements.get(j);
				}
				
				Calendar date = new GregorianCalendar(Integer.parseInt(textYear.getText()), Integer.parseInt(textMonth.getText()), Integer.parseInt(textDay.getText()));

				systemHandler.addScholarship(new Scholarship(textField.getText(), date,
						Faculty.getFaculty(facultyBox.getSelectedIndex()), reqArray, Integer.parseInt(textField_4.getText()),
						Integer.parseInt(textField_5.getText()), 4, nominateBool.isSelected()));

				frame.setContentPane(new ViewScholarshipGUI(frame, systemHandler, user));
			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(86, 320, 65, 23);
		add(btnCancel);

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setContentPane(new ViewScholarshipGUI(frame, systemHandler, user));
			}
		});
	}
}
