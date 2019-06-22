import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
public class SearchEngine extends JFrame {

	public JPanel contentPane;
	public JTextField searchField_0;
	public JTextField searchField_1;
	public JTextField searchField_2;
	public JTextField searchField_3;
	public JTextField searchField_4;
	public JTextField searchField_5;
	private Connection con;
	private Statement st;
	private ResultSet rs;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEngine frame = new SearchEngine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchEngine() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/king_database","root","");
			st = con.createStatement();
			
		} catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Game Mode 3 v 3");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Meiryo UI", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(97, 11, 132, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnBeginMatchmaking = new JButton("Begin Matchmaking");
		btnBeginMatchmaking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					SearchStart();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBeginMatchmaking.setBounds(31, 228, 132, 23);
		contentPane.add(btnBeginMatchmaking);
		searchField_0 = new JTextField();
		searchField_0.setText("Your username");
		searchField_0.setBounds(31, 75, 86, 20);
		contentPane.add(searchField_0);
		searchField_0.setColumns(10);
		
		searchField_1 = new JTextField();
		searchField_1.setText("invite ");
		searchField_1.setBounds(31, 115, 86, 20);
		contentPane.add(searchField_1);
		searchField_1.setColumns(10);
		
		searchField_2 = new JTextField();
		searchField_2.setText("invite");
		searchField_2.setBounds(31, 155, 86, 20);
		contentPane.add(searchField_2);
		searchField_2.setColumns(10);
		
		searchField_3 = new JTextField();
		searchField_3.setText("invite");
		searchField_3.setBounds(222, 75, 86, 20);
		contentPane.add(searchField_3);
		searchField_3.setColumns(10);
		
		searchField_4 = new JTextField();
		searchField_4.setText("invite");
		searchField_4.setBounds(222, 115, 86, 20);
		contentPane.add(searchField_4);
		searchField_4.setColumns(10);
		
		searchField_5 = new JTextField();
		searchField_5.setText("invite");
		searchField_5.setBounds(222, 155, 86, 20);
		contentPane.add(searchField_5);
		searchField_5.setColumns(10);
		
	}
	
	private void SearchStart() throws InterruptedException {
		String searchString_1 = searchField_1.getText();
		String searchString_2 = searchField_2.getText();
		String searchString_3 = searchField_3.getText();
		String searchString_4 = searchField_4.getText();
		String searchString_5 = searchField_5.getText();
try {
			
			String query = "SELECT * FROM users";
			rs=st.executeQuery(query);
			while(rs.next()) {
				String usernametoken = rs.getString("Username"); // data for the search fields
				searchField_1.setText(usernametoken);
				break;
				
			}
			
} catch(Exception ex) {
System.out.println(ex);
}
	}
			
	String emptyStr = "";
	String S0 = "searching";
	String S1 = "searching.";
	String S2 = "searching..";
	String S3 = "searching...";
}
