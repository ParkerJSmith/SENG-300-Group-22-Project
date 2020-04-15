/* Main GUI screen for students */
package scholarshipGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import scholarshipSystem.SystemHandler;
import scholarshipSystem.User;

public class StudentGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public StudentGUI(JFrame frame, SystemHandler systemHandler, User user) {
		frame.setTitle("Student");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBackground(SystemColor.control);
		frame.getContentPane().add(this, BorderLayout.CENTER);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Student");							//Create Student label//
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 11, 91, 22);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Scholarship");					// Create Scolarship label//
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(178, 61, 125, 22);
		add(lblNewLabel_1);
		
		JLabel lblSignout = new JLabel("Sign out");							// Create Sign out label//
		lblSignout.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSignout.setBounds(350, 10, 110, 22);
		lblSignout.setForeground(new Color(1, 112, 169));
		lblSignout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {						// Event handlers if Sign out label is clicked//
				int n = JOptionPane.showConfirmDialog(
					    frame,
					    "Are you sure you want to sign out?",				// Confirmation//
					    "Sign out",
					    JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					new GUIHandler(systemHandler);
					frame.dispose();
				}
			}
			
			public void mouseEntered(MouseEvent arg0) {	
				lblSignout.setFont(new Font("Arial", Font.BOLD, 15));
				lblSignout.setBounds(347, 10, 110, 22);	
			}
			
			public void mouseExited(MouseEvent arg0) {
				lblSignout.setFont(new Font("Arial", Font.PLAIN, 15));
				lblSignout.setBounds(350, 10, 110, 22);
			}
		});
		add(lblSignout);

		JButton btnNewButton = new JButton("View Scholarships");			// Create button to view scholarships//
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					// Event handler if view scholarships is clicked//
				frame.setContentPane(new ViewScholarshipGUI(frame, systemHandler, user));		// show scholarships gui//
			}
		});
		btnNewButton.setBounds(152, 104, 120, 23);
		add(btnNewButton);
		
		JButton viewApplications = new JButton("View Applications");		// Create button to view applications//
		viewApplications.addActionListener(new ActionListener() {			// event handler if view applications is clicked//
			public void actionPerformed(ActionEvent arg0) {
				frame.setContentPane(new ViewStatusGUI(frame, systemHandler, user));		// Show scholarships that have been applied for //
			}
		});
		viewApplications.setBounds(152, 128, 120, 23);
		add(viewApplications);
	}

}
