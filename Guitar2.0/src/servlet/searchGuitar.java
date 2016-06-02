package servlet;

import java.io.IOException; 
 import java.sql.*; 
 import java.util.List; 
 
 
 import javax.servlet.Servlet; 
 import javax.servlet.ServletException; 
 import javax.servlet.annotation.WebServlet; 
 import javax.servlet.http.HttpServlet; 
 import javax.servlet.http.HttpServletRequest; 
 import javax.servlet.http.HttpServletResponse; 
 
 
 import model.Guitar; 
 import model.GuitarSpec; 
 import model.Inventory; 
 import dbUtil.JDBCsqlite; 
 
 
 /** 
  * Servlet implementation class GuitarPost 
  */ 
 @WebServlet("/searchGuitar") 
 public class searchGuitar extends HttpServlet implements Servlet { 
 	private static final long serialVersionUID = 1L; 
         
     /** 
      * @see HttpServlet#HttpServlet() 
      */ 
     public searchGuitar() { 
         super(); 
 
 
     } 
 
 
 	/** 
 	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
 	 */ 
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
 		doPost(request,response); 
 	} 
 
 
 	/** 
 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
 	 */ 
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
 		request.setCharacterEncoding("UTF-8"); 
 		response.setContentType("text/html;charset=UTF-8"); 
 		 
 		String builder = request.getParameter("builder"); 
 		String type = request.getParameter("type"); 
 		String backwood = request.getParameter("backwood"); 
 		String topwood = request.getParameter("topwood"); 
 		 
 
 
 		//根据查询条件，分装成一个查询对象GuitarSpec 
 		GuitarSpec guitarspec = new GuitarSpec(builder,type,backwood,topwood); 
 		 
 		Inventory inventory = new Inventory(); 
 		initializeInventory(inventory); 
 		 
 		List<Guitar> matchingGuitars = inventory.search(guitarspec); 
 
 
 		request.setAttribute("matchingGuitar", matchingGuitars); 
 		request.getRequestDispatcher("/ShowGuitar.jsp").forward(request,response); 
 	} 
 
 
 	private static void initializeInventory(Inventory inventory){ 
 		Connection connection = null; 
 		JDBCsqlite jdbc =  new JDBCsqlite(); 
 		PreparedStatement ps = null; 
 		connection = jdbc.connection; 
 		 
 		try { 
 				ps = connection.prepareStatement("select * from Guitar"); 
 	 
 				ResultSet rs = ps.executeQuery(); 
 				 
 				while(rs.next()){			 
 					inventory.addGuitar(rs.getString(1),rs.getDouble(2),rs.getString(4),rs.getInt(8), new GuitarSpec(rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7))); 
				} 
 				if(rs != null){ 
 					rs.close(); 
 				} 
 				if(ps != null){ 
 					ps.close(); 
 				} 
				connection.close(); 
 			} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		 
 	} 
 
 
 } 

