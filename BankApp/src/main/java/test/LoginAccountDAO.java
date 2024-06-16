package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class LoginAccountDAO 
{
	public CustomersBean cb = null;
	public CustomersBean login(String username, String password)
	{
		Connection con = DBConnection.getCon();
		try
		{
			PreparedStatement ps = con.prepareStatement
					("SELECT * FROM CUSTOMERS WHERE USERNAME=? AND PASSWORD=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				cb = new CustomersBean();
				cb.setUsername(rs.getString(1));
				cb.setPassword(rs.getString(2));
				cb.setName(rs.getString(3));
				cb.setAddress(rs.getString(4));
				cb.setPhoneNumber(rs.getLong(5));
				cb.setAccountNumber(rs.getString(6));
				cb.setPinNumber(rs.getInt(7));
				cb.setBalance(rs.getLong(8));	
			}//end of if
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return cb;
	}
}
