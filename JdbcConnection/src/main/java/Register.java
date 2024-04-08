

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String fathername=request.getParameter("fathername");
		String mobileno=request.getParameter("phone");
		String address=request.getParameter("address");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Register", "root","vamc12345");
			PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, fathername);
			ps.setString(4, mobileno);
			ps.setString(5, address);
			
			
			int i=ps.executeUpdate();
			
			if(i>0) {
				out.print("successfully registered");
				
			}
			
		}catch(Exception e) {
		  System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
