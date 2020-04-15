package scholarshipGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import scholarshipSystem.SystemHandler;
import scholarshipSystem.User;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGUI extends JPanel{											/*The Admin's perspective*/

	public AdminGUI(JFrame frame, SystemHandler systemHandler, User user) {

		frame.setTitle("Admin");												//Set Title//					
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBackground(SystemColor.control);
		frame.getContentPane().add(this, BorderLayout.CENTER);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Admin");								// "Admin" Label in top left//
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 11, 91, 22);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Scholarship");						// Create label "Scholarship//
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(178, 61, 125, 22);
		add(lblNewLabel_1);
		
		JLabel lblSignout = new JLabel("Sign out");								// Create Label to sign out//
		lblSignout.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSignout.setBounds(350, 10, 110, 22);
		lblSignout.setForeground(new Color(1, 112, 169));
		lblSignout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {							// If Sign out text is clicked, popup to confirm//
				int n = JOptionPane.showConfirmDialog(
					    frame,
					    "Are you sure you want to sign out?",
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

		JButton btnNewButton = new JButton("View Scholarships");				// Create Button, named "View scholarships"//
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {							// If this button is created, ViewScholarshipGUI window created//
				ViewScholarshipGUI vs = new ViewScholarshipGUI(frame, systemHandler, user);
				frame.setContentPane(vs);
			}
		});
		btnNewButton.setBounds(154, 104, 120, 23);
		add(btnNewButton);
		
		JButton seeApplications = new JButton("View Applications");				// Create Button, named "View Applications"//
		seeApplications.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {							// If this button is created, ViewApplicationsGUI window created//
				frame.setContentPane(new ViewApplicationsGUI(frame, systemHandler, user));
			}
		});
		seeApplications.setBounds(154, 131, 120, 23);
		add(seeApplications);
	}

}
