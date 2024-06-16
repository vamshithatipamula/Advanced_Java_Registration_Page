package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccountDAO 
{
	public int k = 0;
	public int create(CustomersBean cb)
	{
		Connection con = DBConnection.getCon();
		try
		{
			PreparedStatement ps = con.prepareStatement
					("INSERT INTO CUSTOMERS(USERNAME, PASSWORD, NAME, ADDRESS, PHONENUMBER, ACCOUNTNUMBER, PINNUMBER) VALUES(?, ?, ?, ?, ?, CONCAT(? , '83'), ?)");
			ps.setString(1, cb.getUsername());
			ps.setString(2, cb.getPassword());
			ps.setString(3, cb.getName());
			ps.setString(4, cb.getAddress());
			ps.setLong(5, cb.getPhoneNumber());
			ps.setLong(6, cb.getPhoneNumber());
			ps.setInt(7, cb.getPinNumber());
			k = ps.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.toString());
		}
		return k;
	}
}
