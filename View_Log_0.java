import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class View_Log_0 extends JFrame {

	private JPanel contentPane;
	private JTextField txtYyyymmdd;
	private DefaultListModel<String> l1;
	private JList<String> list;  
	private JTextField txtProvince;
	private JTextField txtHealth_Zone;
	private JLabel background;
	private ImageIcon img;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Log_0 frame = new View_Log_0();
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
	public View_Log_0() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		img = new ImageIcon("src/space.jpg");
		   background = new JLabel("",img,JLabel.CENTER);
		   background.setBounds(0, 0, 450, 300);
		   contentPane.add(background);
		   
		   textField = new JTextField();
		   textField.setBounds(10, 41, 86, 20);
		   contentPane.add(textField);
		   textField.setColumns(10);
		   
		   textField_1 = new JTextField();
		   textField_1.setBounds(10, 95, 86, 20);
		   contentPane.add(textField_1);
		   textField_1.setColumns(10);
		   
		   textField_2 = new JTextField();
		   textField_2.setBounds(10, 151, 86, 20);
		   contentPane.add(textField_2);
		   textField_2.setColumns(10);
		   
		   JTextPane textPane = new JTextPane();
		   textPane.setBounds(214, 41, 190, 130);
		   contentPane.add(textPane);
		   
		   JButton btnSearch = new JButton("search");
		   btnSearch.setBounds(102, 150, 89, 23);
		   contentPane.add(btnSearch);
	}

}
