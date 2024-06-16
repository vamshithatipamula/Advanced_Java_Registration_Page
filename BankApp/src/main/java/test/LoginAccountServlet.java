package test;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/loginaccount")

public class LoginAccountServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		CustomersBean cb = new LoginAccountDAO().login(req.getParameter("uname"), req.getParameter("pword"));
		if(cb==null)
		{
			req.setAttribute("msg", "Invalid Login Details...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("customersbean", cb);
			req.setAttribute("msg", "Login Successfull..<br>");
			req.getRequestDispatcher("LoginAccount.jsp").forward(req, res);
			
		}//end of if-else
	}
}
