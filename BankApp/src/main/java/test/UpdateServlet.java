package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/update")

public class UpdateServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		String accNo = req.getParameter("accno");
		String uName = req.getParameter("uname");
		String pWord = req.getParameter("pword");
		String addrs = req.getParameter("addrs");
		Integer pinNo = Integer.parseInt(req.getParameter("pinno"));
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			CustomersBean cb = (CustomersBean)hs.getAttribute("customersbean");
			if(accNo.equals(cb.getAccountNumber()))
			{
				cb.setUsername(uName);
				cb.setPassword(pWord);
				cb.setAddress(addrs);
				cb.setPinNumber(pinNo);
				int k = new UpdateDAO().update(cb);
				if(k>0)
				{
					req.setAttribute("msg", "Account Details Updated Successfully..<br> ");
					req.getRequestDispatcher("Home.jsp").forward(req, res);
				}
			}
			else
			{
				req.setAttribute("msg", "Invalid Account Number..<br>");
				req.getRequestDispatcher("Home.jsp").forward(req, res);
			}//end of if-else
		}//end of if-else
	}
}
