package test;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/deposit")

public class DepositServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			Integer amount = Integer.parseInt(req.getParameter("amount"));
			String accountNumber = req.getParameter("accno");
			Integer pinNumber = Integer.parseInt(req.getParameter("pinno"));
			if(amount<=0)
			{
				req.setAttribute("msg", "Invalid Amount...<br>");
				req.getRequestDispatcher("LoginAccount.jsp").forward(req, res);
			}
			else
			{
				CustomersBean cb = (CustomersBean)hs.getAttribute("customersbean");
				if(accountNumber.equals(cb.getAccountNumber()) && pinNumber.equals(cb.getPinNumber()))
				{
					int k = new DepositDAO().deposit(cb, amount);
					if(k>0)
					{
						cb.setBalance(cb.getBalance()+amount);
						req.setAttribute("msg", "Amount Deposited Successfully...<br>");
						req.getRequestDispatcher("LoginAccount.jsp").forward(req, res);
					}//end of if
				}		
				else
				{
					req.setAttribute("msg", "Invalid Account Details...<br>");
					req.getRequestDispatcher("LoginAccount.jsp").forward(req, res);
				}//end of if-else
			}
		}//end of if-else
	}//end of if-else
}
