package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepositDAO 
{
	public int k = 0;
	public int deposit(CustomersBean cb, Integer amount)
	{
		Connection con = DBConnection.getCon();
		try
		{
			PreparedStatement ps = con.prepareStatement
					("UPDATE CUSTOMERS SET BALANCE=NVL(BALANCE,0)+? WHERE ACCOUNTNUMBER=? AND PINNUMBER=?");
			ps.setInt(1, amount);
			ps.setString(2, cb.getAccountNumber());
			ps.setInt(3, cb.getPinNumber());
			k = ps.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return k;
	}
}
