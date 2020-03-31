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

public class ProfessorGUI extends JPanel {

	public ProfessorGUI(JFrame frame, SystemHandler systemHandler) {
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

		JButton nominateBtn = new JButton("Nominate");
		nominateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String S_ID = sID.getText();

				if (S_ID.equals("30027956")) {
					frame.setContentPane(new NominateStudent(frame, systemHandler));
				} else {
					JOptionPane.showMessageDialog(frame, "No student with that ID exists in our database.");
				}
			}
		});

		nominateBtn.setBounds(174, 136, 89, 23);
		add(nominateBtn);
	}
}