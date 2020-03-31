package application;



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



public class ProfessorGUI {

	private JFrame frmProfessorGUI;
	private JTextField sID;

	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorGUI window = new ProfessorGUI();
					window.frmProfessorGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**

	 * Create the application.

	 */

	public ProfessorGUI() {
		initialize();
	}

	/**

	 * Initialize the contents of the frame.

	 */

	private void initialize() {
		frmProfessorGUI = new JFrame();
		frmProfessorGUI.setTitle("Professor");
		frmProfessorGUI.setBounds(100, 100, 450, 300);
		frmProfessorGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		frmProfessorGUI.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel ProfessorTitleText = new JLabel("Professor");
		ProfessorTitleText.setFont(new Font("Arial", Font.PLAIN, 20));
		ProfessorTitleText.setBounds(33, 11, 181, 22);
		panel.add(ProfessorTitleText);
		
		JLabel sIDText = new JLabel("Student ID");
		sIDText.setFont(new Font("Arial", Font.PLAIN, 15));
		sIDText.setBounds(174, 80, 73, 22);
		panel.add(sIDText);
		
		JLabel NominateText = new JLabel("Nominate");
		NominateText.setFont(new Font("Arial", Font.PLAIN, 15));
		NominateText.setBounds(43, 49, 125, 22);
		panel.add(NominateText);
		
		sID = new JTextField();
		sID.setBounds(174, 105, 86, 20);
		panel.add(sID);
		sID.setColumns(10);
		
		JButton nominateBtn = new JButton("Nominate");
		nominateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String S_ID = sID.getText();
				
				if(S_ID.equals("30027956")) {
					NominateStudent ns = new NominateStudent();
					ns.nominateStudent();
				} else {
					JOptionPane.showMessageDialog(frmProfessorGUI, "No student with that ID exists in our database.");
				}
			}
		});
		nominateBtn.setBounds(174, 136, 89, 23);
		panel.add(nominateBtn);
	}
}