<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
    
    String email=request.getParameter("email");
    String pass=request.getParameter("pass");
    ArrayList l1=new ArrayList();
    ArrayList l2=new ArrayList();   
    Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
PreparedStatement ps=con.prepareStatement("select * from logintable where email=? ");
ps.setString(1, email);
 ResultSet rs=ps.executeQuery();
  if(rs.next())
  {
     if(rs.getString(2).equals(email))
     {
         if(rs.getString(3).equals(pass))
         {
             session.setAttribute("Email",email);
             response.sendRedirect("index.jsp");
         }
         else
         {
             response.sendRedirect("loginPage.jsp");
         }
     }
             
  }
    %>