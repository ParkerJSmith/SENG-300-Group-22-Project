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

public class AdminGUI extends JPanel{

	public AdminGUI(JFrame frame, SystemHandler systemHandler, User user) {

		frame.setTitle("Admin");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBackground(SystemColor.control);
		frame.getContentPane().add(this, BorderLayout.CENTER);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 11, 91, 22);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Scholarship");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(178, 61, 125, 22);
		add(lblNewLabel_1);
		
		JLabel lblSignout = new JLabel("Sign out");
		lblSignout.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSignout.setBounds(350, 10, 110, 22);
		lblSignout.setForeground(new Color(1, 112, 169));
		lblSignout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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

		JButton btnNewButton = new JButton("View");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewScholarshipGUI vs = new ViewScholarshipGUI(frame, systemHandler, user);
				frame.setContentPane(vs);
			}
		});
		btnNewButton.setBounds(172, 104, 89, 23);
		add(btnNewButton);
	}

}
