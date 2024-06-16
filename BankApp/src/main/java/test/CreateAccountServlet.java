package test;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
@WebServlet("/createaccount")

@SuppressWarnings("serial")
public class CreateAccountServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		CustomersBean cb = new CustomersBean();
		cb.setUsername(req.getParameter("uname"));
		cb.setPassword(req.getParameter("pword"));
		cb.setName(req.getParameter("name"));
		cb.setAddress(req.getParameter("addrs"));
		cb.setPhoneNumber(Long.parseLong(req.getParameter("phno")));
		cb.setPinNumber(Integer.parseInt(req.getParameter("pinno")));
		int k = new CreateAccountDAO().create(cb);
		if(k>0)
		{
			req.setAttribute("msg", "Account Created Successfully..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}//end of if
	}
}
