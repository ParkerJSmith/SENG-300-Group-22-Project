package scholarshipsGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import scholarshipSystem.openFile;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Application extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Application Form");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle.setBounds(163, 11, 212, 31);
		contentPane.add(lblTitle);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(71, 62, 79, 20);
		contentPane.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(71, 93, 79, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblStudyYear = new JLabel("Year of Study:");
		lblStudyYear.setBounds(71, 209, 101, 20);
		contentPane.add(lblStudyYear);
		
		JLabel lblGPA = new JLabel("Estimated GPA:");
		lblGPA.setBounds(71, 240, 101, 14);
		contentPane.add(lblGPA);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setBounds(175, 524, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(301, 524, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(71, 325, 435, 161);
		contentPane.add(textArea);
		
		JButton btnNewButton_2 = new JButton("Browse");				//Select File code//
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openFile openfile = new openFile();
				
				try {
					openfile.pick();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				textArea.setText(openfile.sb.toString());
				
			}
		});
		btnNewButton_2.setBounds(145, 297, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Select Files:");
		lblNewLabel_4.setBounds(71, 302, 101, 12);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Birth Date:");
		lblNewLabel.setBounds(71, 153, 63, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Major:");
		lblNewLabel_1.setBounds(71, 184, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID Number:");
		lblNewLabel_2.setBounds(71, 128, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(160, 237, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 209, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 181, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(160, 153, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(160, 125, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(160, 90, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(160, 62, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		

	}
}
