package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAccountDAO
{
	public int k = 0;
	public int delete(CustomersBean cb)
	{
		Connection con = DBConnection.getCon();
		try
		{
			PreparedStatement ps = con.prepareStatement
					("DELETE FROM CUSTOMERS WHERE ACCOUNTNUMBER=? AND PINNUMBER=?");
			ps.setString(1, cb.getAccountNumber());
			ps.setInt(2, cb.getPinNumber());
			k = ps.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return k;
	}
}
