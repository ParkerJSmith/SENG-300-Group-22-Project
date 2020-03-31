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
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import scholarshipSystem.SystemHandler;

public class ViewScholarship extends JPanel {

	/**
	 * Create the application.
	 */
	public ViewScholarship(JFrame frame, SystemHandler systemHandler) {
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

		JTextField textField = new JTextField();
		textField.setBounds(29, 90, 86, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Search:");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(29, 76, 46, 14);
		add(lblNewLabel_1);

		JList list = new JList(systemHandler.getScholarshipNames());
		list.setBounds(147, 46, 306, 244);
		add(list);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				addScholarshipGUI panel = new addScholarshipGUI(frame, systemHandler);
				frame.setContentPane(panel);
			}
		});
	}

}
