package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.CallableStatement;

public class TransferDAO 
{
	public long l = 0;
	public long transfer(CustomersBean cb, Integer amount, Long phNo)
	{
		Connection con = DBConnection.getCon();
		try
		{
			CallableStatement cs = con.prepareCall("{CALL TRANSFER(?,?,?,?,?)}");
			cs.setInt(1, amount);
			cs.setString(2, cb.getAccountNumber());
			cs.setInt(3, cb.getPinNumber());
			cs.setLong(4, phNo);
			cs.registerOutParameter(5, Types.BIGINT);
			cs.execute();
			l =  cs.getLong(5);
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return l;
	}
}
