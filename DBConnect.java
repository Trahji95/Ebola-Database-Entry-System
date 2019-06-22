import java.sql.*;

public class DBConnect {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	public String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/ebola_data";
	public String db_username = "root"; // Username for the database log in
	public String db_password = ""; // Password for the database is empty
	
	public DBConnect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,db_username,db_password);
			st = conn.createStatement();
			
		} catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	
	public void getData() {
		try {
			
			String query = "SELECT * FROM users";
			rs=st.executeQuery(query);
			System.out.println("Records from Database");
			while(rs.next()) {
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				System.out.println("Username: "+username+" Password: "+password);
			}
			
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void addData() {
		try {
			String id_var = "newadd22", User_name = "thisIZworld45", Pass_word = "mynextVictim32";

			String query = "INSERT INTO `users` (`Number`, `Username`, `Password`) VALUES ('"+id_var+"', '"+User_name+"', '"+Pass_word+"')\r\n" + 
		   		"";
			int rows =st.executeUpdate(query);
			System.out.println("Updated Records from Database");
			
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
