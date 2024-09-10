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
 * Servlet implementation class display
 */
@WebServlet("/display")
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		// TODO Auto-generated method stub
		{
	    	PrintWriter out= response.getWriter();
	    	try
			{
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con= DriverManager.getConnection("jdbc:mysql://128.66.203.247/imsc7it27","imsc7it27","sumo@123");
	   PreparedStatement pst=  con.prepareStatement("Select * from car");
	   ResultSet rs=  pst.executeQuery();
	   while(rs.next())
	   		{
		   String name=rs.getString(1);
		   String price=rs.getString(2);
		   String linkUrl = "Details?name=" + name + "&price=" + price;
	       out.println("<html>");
	       out.println("<body>");
	       out.println("<a href='" + linkUrl + "'>" + name + "</a>");
	       out.println("</body>");
	       out.println("</html>");
	      }
	   out.close();
			}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
