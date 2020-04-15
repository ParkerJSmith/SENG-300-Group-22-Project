/* GUI to view status of scholarship*/
package scholarshipGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scholarshipSystem.Student;
import scholarshipSystem.SystemHandler;
import scholarshipSystem.User;

public class ViewStatusGUI extends JPanel {

	DefaultListModel model;
	JList list;

	public ViewStatusGUI(JFrame frame, SystemHandler systemHandler, User user) {

		model = new DefaultListModel();
		Student student = (Student) user;

		String applications[] = student.getApplicationNames();

		for (int i = 0; i < applications.length; i++) {					// Add the scholarships that have been applied//
			model.addElement(applications[i]);
		}

		frame.setTitle("Scholarship");									//Set frame title//
		frame.setBounds(100, 100, 479, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		setBounds(0, 0, 463, 301);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Scholarships");				// Create label "Scholarships"//
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(29, 11, 125, 24);
		add(lblNewLabel);

		JTextField textField = new JTextField();						//Create Text field, for list of applied scholarships//
		textField.setBounds(29, 90, 86, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Search:");					// Create label "Search"//
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(29, 76, 46, 14);
		add(lblNewLabel_1);

		list = new JList(model);
		list.setBounds(147, 46, 306, 244);
		add(list);

		JButton backButton = new JButton("Back");						// Create "back" button//
		backButton.setBounds(29, 254, 89, 23);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {					// Event handler if back is clicked, creates StudentGUI//
				frame.setContentPane(new StudentGUI(frame, systemHandler, user));
			}
		});
		add(backButton);
	}
}
