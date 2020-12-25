import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public objective_6_prepared_statements{
	public static void main(String [] args){
		String url = "jdbc:mysql://localhost:3306/test-app-db?useSSL=false";
		String user = "testappuser";
		String password = "password";
		String personName = "johndo"
		String sql = "INSERT INTO Person(Name) VALUES (?)";
		
		try(Connection con = DriveManager.getConnection(url,user,password);
			PreparedStatement pst = con.prepareStatement(sql)){
				pst.setString(1, personName);
				pst.executeUpdate();
				System.out.println("A new author has been inserted.");
			}catch(SQLException ex){
				Logger lgr = Logger.getLogger(jdbcPrepared.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
	}
}
