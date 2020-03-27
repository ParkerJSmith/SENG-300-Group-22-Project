package scholarshipGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addScholarshipGUI extends JFrame {

	protected static final JFrame Jframe = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public addScholarshipGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddScholarship = new JLabel("Add Scholarship");
		lblAddScholarship.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddScholarship.setBounds(110, 0, 236, 62);
		contentPane.add(lblAddScholarship);
		
		JLabel lblSchoalrshipName = new JLabel("Name:");
		lblSchoalrshipName.setBounds(50, 62, 48, 27);
		contentPane.add(lblSchoalrshipName);
		
		JLabel lblScholarshipDepartment = new JLabel("Department:");
		lblScholarshipDepartment.setBounds(50, 100, 97, 14);
		contentPane.add(lblScholarshipDepartment);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setBounds(52, 136, 46, 14);
		contentPane.add(lblLevel);
		
		JLabel lblRequirements = new JLabel("Requirements: ");
		lblRequirements.setBounds(50, 161, 73, 14);
		contentPane.add(lblRequirements);
		
		JLabel lblAvailibility = new JLabel("Availibility:");
		lblAvailibility.setBounds(52, 238, 106, 14);
		contentPane.add(lblAvailibility);
		
		JLabel lblAward_Amount = new JLabel("Award Amount:");
		lblAward_Amount.setBounds(52, 319, 106, 14);
		contentPane.add(lblAward_Amount);
		
		textField = new JTextField();
		textField.setBounds(138, 65, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 97, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 133, 40, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(138, 158, 289, 69);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(138, 235, 208, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(138, 316, 97, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnPublish = new JButton("Publish");
		btnPublish.setBounds(138, 357, 89, 23);
		contentPane.add(btnPublish);
		
		JButton btnCancel = new JButton("Cancel");
	
		btnCancel.setBounds(267, 357, 89, 23);
		contentPane.add(btnCancel);
	}
}
