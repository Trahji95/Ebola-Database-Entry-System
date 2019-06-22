import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class file_class extends JFrame {

	private JPanel contentPane;
	public JTextPane textPane;
	public JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					file_class frame = new file_class();
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
	public file_class() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(10, 68, 212, 138);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.addActionListener(new ActionListener() {
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


			}
		});
		btnNewButton.setBounds(10, 209, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\student\\eclipse-workspace\\MainProgram\\src\\icons8-attach-18.png"));
		btnNewButton_1.setBounds(197, 209, 25, 23);
		contentPane.add(btnNewButton_1);

	}
}
