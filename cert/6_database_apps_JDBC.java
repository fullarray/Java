import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public objective_6{
	public static void main(String [] args){
		String url = "jdbc:mysql://localhost:3306/test-app-db?useSSL=false";
		String user = "testappuser";
		String password = "password";
		
		String query = "SELECT VERTSION()";
		
		try(Connection con = DriveManager.getConnection(url,user,password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query)){
				
				if(rs.next()){
					System.out.println(rs.getString(1));
				}
			}catch(SQLException ex){
				Logger lgr = Logger.getLogger(jdbcMySQLVersion.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
	}
}