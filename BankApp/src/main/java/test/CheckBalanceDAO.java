package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckBalanceDAO 
{
	public CustomersBean cb = null;
	public CustomersBean retrieve(String accNo, Integer pinNo)
	{
		Connection con = DBConnection.getCon();
		try
		{
			PreparedStatement ps = con.prepareStatement("SELECT NVL(BALANCE, 0) FROM CUSTOMERS WHERE ACCOUNTNUMBER=? AND PINNUMBER=?");
			ps.setString(1, accNo);
			ps.setInt(2, pinNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				cb = new CustomersBean();
				cb.setBalance(rs.getLong(1));
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return cb;
	}
}
