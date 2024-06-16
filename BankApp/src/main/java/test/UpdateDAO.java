package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDAO
{
	public int k = 0;
	public int update(CustomersBean cb)
	{
		Connection con = DBConnection.getCon();
		try
		{
			PreparedStatement ps = con.prepareStatement
					("UPDATE CUSTOMERS SET USERNAME=?, PASSWORD=?, ADDRESS=?, PINNUMBER=? WHERE ACCOUNTNUMBER=?");
			ps.setString(1, cb.getUsername());
			ps.setString(2, cb.getPassword());
			ps.setString(3,  cb.getAddress());
			ps.setInt(4, cb.getPinNumber());
			ps.setString(5, cb.getAccountNumber());
			k = ps.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return k;
	}
}
