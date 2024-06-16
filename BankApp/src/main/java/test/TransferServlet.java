package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/transfer")

public class TransferServlet  extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		Integer amount = Integer.parseInt(req.getParameter("amount"));
		String accNo = req.getParameter("accno");
		Integer pinNo = Integer.parseInt(req.getParameter("pinno"));
		Long phNo = Long.parseLong( req.getParameter("phno"));
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			CustomersBean cb = (CustomersBean)hs.getAttribute("customersbean");
			if(amount>cb.getBalance() || amount<=0)
			{
				req.setAttribute("msg", "Invalid Amount..<br>");
				req.getRequestDispatcher("LoginAccount.jsp").forward(req, res);
			}
			else
			{
				if(accNo.equals(cb.getAccountNumber()) && pinNo.equals(cb.getPinNumber()))
				{
					long l = new TransferDAO().transfer(cb, amount, phNo);
					if(phNo==l)
					{
						cb.setBalance(cb.getBalance()-amount);
						req.setAttribute("msg", "Amount Transferred Successfully..<br>");
						req.getRequestDispatcher("Transfer.jsp").forward(req, res);
					}
					else
					{
						req.setAttribute("msg", "Invalid Details..<br>");
						req.getRequestDispatcher("LoginAccount.jsp").forward(req, res);
					}
				}
				else
				{
					req.setAttribute("msg", "Invalid Account Details..<br>");
					req.getRequestDispatcher("LoginAccount.jsp").forward(req, res);
				}//end of if-else
			}//end of if-else
		}//end of if-else
	}
}
