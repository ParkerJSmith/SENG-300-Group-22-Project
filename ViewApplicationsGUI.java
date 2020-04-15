/* Review application GUI*/
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scholarshipSystem.Admin;
import scholarshipSystem.Student;
import scholarshipSystem.SystemHandler;
import scholarshipSystem.User;

public class ViewApplicationsGUI extends JPanel {
	
	DefaultListModel model; 
	JList list;
	
	public ViewApplicationsGUI(JFrame frame, SystemHandler systemHandler, User user) {
		
		model = new DefaultListModel();

		String applications[] = systemHandler.getApplicationNames();

		for (int i = 0; i < applications.length; i++) {
			model.addElement(applications[i]);
		}

		frame.setTitle("Scholarship");											//Set title of frame//
		frame.setBounds(100, 100, 479, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		setBounds(0, 0, 463, 301);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Scholarships");						// Create "Scholarships" label//
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(29, 11, 125, 24);
		add(lblNewLabel);

		JTextField textField = new JTextField();								// Create textfield for "Search" label//
		textField.setBounds(29, 90, 86, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Search:");							// Create "Search:" LAbel//
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(29, 76, 46, 14);
		add(lblNewLabel_1);

		list = new JList(model);
		list.setBounds(147, 46, 306, 244);
		add(list);

		JButton backButton = new JButton("Back");								// Create button "Back"//
		backButton.setBounds(29, 254, 89, 23);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {							// Event handler if back is clicked//
				frame.setContentPane(new AdminGUI(frame, systemHandler, user));
			}
		});
		add(backButton);
		
		JButton viewButton = new JButton("View");								// Create "View" button//
		viewButton.setBounds(29, 227, 89, 23);
		viewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {							// Event handler if view is clicked, new review application GUI is created//
				if (list.getSelectedIndex() >= 0) {
					new ReviewApplicationGUI(systemHandler.getApplication(list.getSelectedIndex()).getStudent(), systemHandler.getApplication(list.getSelectedIndex()),
							systemHandler);
				}
			}
		});
		add(viewButton);

	}

}
