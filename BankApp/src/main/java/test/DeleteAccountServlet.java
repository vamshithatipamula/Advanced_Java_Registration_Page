package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/deleteaccount")

public class DeleteAccountServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		String accNo = req.getParameter("accno");
		Integer pinNo = Integer.parseInt(req.getParameter("pinno"));
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			CustomersBean cb = (CustomersBean)hs.getAttribute("customersbean");
			if(accNo.equals(cb.getAccountNumber()) && pinNo.equals(cb.getPinNumber()))
			{
				int k = new DeleteAccountDAO().delete(cb);
				if(k>0)
				{
					hs.setAttribute("msg", "Account Deleted Successfully..");
					req.getRequestDispatcher("Logout.jsp").forward(req, res);
				}
			}
			else
			{
				req.setAttribute("msg", "Invalid Account Details..<br>");
				req.getRequestDispatcher("LoginAccount.jsp").forward(req, res);
			}//end of if-else
		}//end of if-else
	}
}
