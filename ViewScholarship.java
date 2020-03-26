package scholarshipGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class ViewScholarship extends JPanel {

	// private JFrame frame;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public ViewScholarship(JFrame frame) {

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

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(29, 200, 89, 23);
		add(btnNewButton);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(29, 227, 89, 23);
		add(btnRemove);

		textField = new JTextField();
		textField.setBounds(29, 90, 86, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Search:");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(29, 76, 46, 14);
		add(lblNewLabel_1);

		JList list = new JList();
		list.setBounds(147, 46, 306, 244);
		add(list);
		//frame.setContentPane(panel);
	}

}
