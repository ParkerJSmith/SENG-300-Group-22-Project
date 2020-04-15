package scholarshipGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.Color;

import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import scholarshipSystem.SystemHandler;
import scholarshipSystem.User;

public class ProfessorGUI extends JPanel {

	public ProfessorGUI(JFrame frame, SystemHandler systemHandler, User user) {
		frame.setTitle("Professor");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBackground(SystemColor.control);
		frame.getContentPane().add(this, BorderLayout.CENTER);
		setLayout(null);

		JLabel ProfessorTitleText = new JLabel("Professor");
		ProfessorTitleText.setFont(new Font("Arial", Font.PLAIN, 20));
		ProfessorTitleText.setBounds(33, 11, 181, 22);
		add(ProfessorTitleText);

		JLabel sIDText = new JLabel("Student ID");
		sIDText.setFont(new Font("Arial", Font.PLAIN, 15));
		sIDText.setBounds(174, 80, 73, 22);
		add(sIDText);

		JLabel NominateText = new JLabel("Nominate");
		NominateText.setFont(new Font("Arial", Font.PLAIN, 15));
		NominateText.setBounds(43, 49, 125, 22);
		add(NominateText);

		JTextField sID = new JTextField();
		sID.setBounds(174, 105, 86, 20);
		add(sID);
		sID.setColumns(10);
		
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

		JButton nominateBtn = new JButton("Nominate");
		nominateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String studentID = sID.getText();
				
				if (systemHandler.checkStudentID(studentID)) {
					frame.setContentPane(new NominateStudentGUI(frame, systemHandler, user, systemHandler.getStudent(studentID)));
				} else {
					JOptionPane.showMessageDialog(frame, "No student with that ID exists in our database.");
				}
			}
		});

		nominateBtn.setBounds(174, 136, 89, 23);
		add(nominateBtn);
	}
}