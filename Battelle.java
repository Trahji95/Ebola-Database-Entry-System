import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;

public class Battelle extends JFrame {

	private JPanel contentPane;
	private JTextField txtYyyymmdd;
	private DefaultListModel<String> l1;
	private JList<String> list;  
	private JTextField txtHealth_Zone;
	private JTextField txtProvince;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Battelle frame = new Battelle();
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
	public Battelle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JTextPane textPane = new JTextPane();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		Choice choice = new Choice();
		choice.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent ie)
	        {
	        int choice_index = choice.getSelectedIndex();
	        if (choice_index == 1) {
	        	View_Log VLog = new View_Log();
	        	VLog.setVisible(true);
	        	dispose();
	        }
	        }
	    });
		choice.setBounds(10, 10, 103, 30);
		contentPane.add(choice);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setText("MM/DD/YYYY"); // SQL format is in YYYY-MM-DD
		txtYyyymmdd.setToolTipText("");
		txtYyyymmdd.setBounds(10, 64, 86, 23);
		contentPane.add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
		l1 = new DefaultListModel();  
			l1.addElement("health_zone,PROVINCE(NK=North Kivu,I=Ituri)");
	          l1.addElement("Alimbongo,(NK)");  
	          l1.addElement("Beni,(NK)");  
	          l1.addElement("Biena,(NK)");  
	          l1.addElement("Butembo,(NK)");  
	          l1.addElement("Goma,(NK)");
	          l1.addElement("Kalunguta,(NK)");
	          l1.addElement("Katwa,(NK)");
	          l1.addElement("Kayina,(NK)");
	          l1.addElement("Kyondo,(NK)");
	          l1.addElement("Lubero,(NK)");
	          l1.addElement("Mabalako,(NK)");
	          l1.addElement("Mangurujipa,(NK)");
	          l1.addElement("Masereka,(NK)");
	          l1.addElement("Musienene,(NK)");
	          l1.addElement("Mutwanga,(NK)");
	          l1.addElement("Oicha,(NK)");
	          l1.addElement("Vuhovi,(NK)");
	          l1.addElement("Bunia,(I)");
	          l1.addElement("Komanda,(I)");
	          l1.addElement("Mambasa,(NK)");
	          l1.addElement("Mandima,(I)");
	          l1.addElement("Nyankunde,(I)");
	          l1.addElement("Rwampara,(I)");
	          

	   list = new JList<String>(l1);  
	   list.setBounds(100,100, 75,90);  
	   
	   JScrollPane scrollPane = new JScrollPane(list);
	   scrollPane.setBounds(10, 100, 75, 75);
	   contentPane.add(scrollPane);
	   
	   txtHealth_Zone = new JTextField();
	   txtHealth_Zone.addActionListener(new ActionListener(){ // If a health zone is inputed then ENTER is pressed on keyboard it will fill out the textfield for province by using code for the health_zone

           public void actionPerformed(ActionEvent e){
        	   	   
                   //System.out.println("ENTER");
        	       String ZoneString = txtHealth_Zone.getText();
        	   	   switch(ZoneString) {
        	   	   case "Bunia":
        	   		   txtProvince.setText("Ituri");
        	   		   break;
        	   	   case "Komanda":
        	   		   txtProvince.setText("Ituri");
        	   		   break;
        	   	   case "Mandima":
        	   		   txtProvince.setText("Ituri");
        	   		   break;
        	   	   case "Nyankunde":
        	   		   txtProvince.setText("Ituri");
        	   		   break;
        	   	   case "Rwampara":
        	   		   txtProvince.setText("Ituri");
        	   		   break;
        	   	   default:
        	   		   txtProvince.setText("North Kivu");
        	   		   
        	   	   }

           }});
	   txtHealth_Zone.setText("health_zone...");
	   txtHealth_Zone.setBounds(10, 186, 86, 20);
	   contentPane.add(txtHealth_Zone);
	   txtHealth_Zone.setColumns(10);
	   
	   txtProvince = new JTextField();
	   txtProvince.addActionListener(new ActionListener(){ // If a health zone is inputed then ENTER is pressed on keyboard it will fill out the textfield for province by using code for the health_zone

           public void actionPerformed(ActionEvent e){

                   // action handling code here

           }});
	   txtProvince.setText("province...");
	   txtProvince.setBounds(10, 217, 86, 20);
	   contentPane.add(txtProvince);
	   txtProvince.setColumns(10);
	   
	   JLabel lblWriteAHealthZone = new JLabel("write a health zone from drop-down menu");
	   lblWriteAHealthZone.setBounds(106, 192, 195, 14);
	   contentPane.add(lblWriteAHealthZone);
	   
	   JButton btnGo = new JButton("GO");
	   btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					File file = new File("src/out.txt");
					FileWriter fw;
					try {
						fw = new FileWriter(file);
						PrintWriter pw = new PrintWriter(fw);
						pw.print(textPane.getText());
						pw.close();


					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					String date = txtYyyymmdd.getText();
					String province = txtProvince.getText();
					String Health_Zone = txtHealth_Zone.getText();
					String fileName = "src/out.txt"; // for memo
					java.util.Date myDate = new java.util.Date(date);
					java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
					    
					    FileInputStream fis = null;
					    PreparedStatement pstmt = null;
					    Connection conn = null;
					    try {
					      conn = getConnection();
					      conn.setAutoCommit(false);
					      fis = new FileInputStream(file);
					      pstmt = conn.prepareStatement("insert into battelle_frame(date, province, health_zone, memo) values (?, ?, ?, ?)");
					      pstmt.setDate(1, sqlDate);
					      pstmt.setString(2, province);
					      pstmt.setString(3, Health_Zone);
					      pstmt.setAsciiStream(4, fis, (int) file.length());
					      pstmt.executeUpdate();
					      conn.commit();
					      pstmt.close();
					      fis.close();
					      conn.close();
					    } catch (Exception e) {
					      System.err.println("Error: " + e.getMessage());
					      e.printStackTrace();
					    } 


			}
		});
	   btnGo.setBounds(116, 216, 89, 23);
	   contentPane.add(btnGo);
	   
	   JScrollPane scrollPane_2 = new JScrollPane(textPane);
	   scrollPane_2.setBounds(140, 10, 284, 165);
	   contentPane.add(scrollPane_2);
	   
	   JButton upload_button = new JButton("");
	   upload_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fs = new JFileChooser(new File("c:\\"));
				fs.setDialogTitle("Open a text File");
				fs.setFileFilter(new FileTypeFilter(".txt", "Text File"));
				fs.setFileFilter(new FileTypeFilter(".doc", "Word File"));
				int result = fs.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File file = fs.getSelectedFile();
					try {
						BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
						String text = "";
						String line = reader.readLine();
						while(line!=null) {
							text+=line;
							line = reader.readLine();
						}
						reader.close();
						textPane.setText(text);
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});		
	   upload_button.setIcon(new ImageIcon("C:\\Users\\student\\eclipse-workspace\\MainProgram\\src\\icons8-attach-18.png"));
	   upload_button.setBounds(399, 183, 25, 23);
	   contentPane.add(upload_button);
	   

		choice.add("Data Updater");
		choice.add("View Log");

	}
}
