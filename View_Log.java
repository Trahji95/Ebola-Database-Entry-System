import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.io.BufferedReader;

public class View_Log extends JFrame {

	private JPanel contentPane;
	private JTextField txtYyyymmdd;
	private JTextField txtProvince;
	private JTextField txtHealthzone;
	private JTextField textField_3;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Log frame = new View_Log();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Connection getConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ebola_data";
		String db_username = "root"; // Username for the database log in
		String db_password = ""; // Password for the database is empty
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, db_username, db_password);
			return conn;
	}

	/**
	 * Create the frame.
	 */
	public View_Log() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setText("YYYY-MM-DD");
		txtYyyymmdd.setToolTipText("");
		txtYyyymmdd.setBounds(10, 26, 86, 20);
		contentPane.add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
		txtProvince = new JTextField();
		txtProvince.setText("province...");
		txtProvince.setBounds(10, 57, 86, 20);
		contentPane.add(txtProvince);
		txtProvince.setColumns(10);
		
		txtHealthzone = new JTextField();
		txtHealthzone.setText("health_zone...");
		txtHealthzone.setBounds(10, 88, 86, 20);
		contentPane.add(txtHealthzone);
		txtHealthzone.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(155, 26, 247, 160);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement pstmt = null;
				String date_str = txtYyyymmdd.getText();
				String province_str = txtProvince.getText();
				String health_zone_str = txtHealthzone.getText();
				String query = "SELECT * FROM `battelle_frame` WHERE date = ? AND province = ? AND health_zone = ?";
				try {
				Connection conn = getConnection();
				// not necessary for this method-Statement st = conn.createStatement();
				pstmt = conn.prepareStatement(query);
			    pstmt.setString(1, date_str);
			    pstmt.setString(2, province_str);
			    pstmt.setString(3, health_zone_str);
				ResultSet resultSet = pstmt.executeQuery();
			    while(resultSet.next()) {
			    	   String memo_string=resultSet.getString("memo");
			    	   textPane.setText(memo_string);
			    	}
			    conn.commit();
			    pstmt.close();
			    conn.close();
				// not necessary for this method-ResultSet rs=st.executeQuery(query);
				}catch(Exception e) {
					System.out.println(e);
				}
				}
			
		});
		
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(10, 119, 65, 23);
		contentPane.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(10, 231, 392, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\student\\eclipse-workspace\\MainProgram\\src\\space.jpg"));
		label.setBounds(0, 1, 434, 261);
		contentPane.add(label);
	}
}
