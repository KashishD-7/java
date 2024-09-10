package gls.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
        super();
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String name= request.getParameter("name"); 
		String price= request.getParameter("price");
    	try
		{
   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con= DriverManager.getConnection("jdbc:mysql://128.66.203.247/imsc7it27","imsc7it27","sumo@123");
   String insertSQL = "INSERT INTO car (name, price) VALUES (?, ?)";
   //Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dkdb","root","root@123");
   PreparedStatement pst=  con.prepareStatement(insertSQL);
   pst.setString(1,name);
   pst.setString(2,price);
   pst.executeUpdate();
   out.println("Car Added into the database");
   out.println("<a href =\"display\">Show Books</a>");
   System.out.print("car Added");
		}
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
	}

}
