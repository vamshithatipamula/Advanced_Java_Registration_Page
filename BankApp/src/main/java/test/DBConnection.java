package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static test.DBInfo.*;

public class DBConnection
{
	private static Connection con = null;
	private DBConnection() {}
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con =  DriverManager.getConnection(dbUrl, uName, pWord);
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}//static block
	public static Connection getCon()
	{
		return con;
	}
}
