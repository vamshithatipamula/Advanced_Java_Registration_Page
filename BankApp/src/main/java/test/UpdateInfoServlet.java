package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/updateinfo")

public class UpdateInfoServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("msg", "Update Only (USERNAME, PASSWORD, ADDRESS, PINNUMBER)<br>");
			req.getRequestDispatcher("UpdateInfo.jsp").forward(req, res);
		}//end of ifs-else
	}
}
