<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Time"%>
<%@page import="java.sql.Date"%>
<%
   int n=0;
   String per=request.getParameter("person");
   String datte=request.getParameter("datte");
   String time=request.getParameter("ttime");
   java.sql.Date date=java.sql.Date.valueOf(datte);
   SimpleDateFormat fd=new SimpleDateFormat("HH:mm");
   long ms=fd.parse(time).getTime();
   Time t=new Time(ms);
   String email=(String)session.getAttribute("Email");
     Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
PreparedStatement ps=con.prepareStatement("select * from logintable where email=? ");
ps.setString(1, email);
 ResultSet rs=ps.executeQuery();
  if(rs.next())
  {
      n=rs.getInt(4);
  }
   rs.close();
   ps.close();
   con.close();
    Class.forName("com.mysql.jdbc.Driver");
Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
PreparedStatement ps1=con1.prepareStatement("insert into reserve(noPerson,time,date,id,name) values(?,?,?,?,?)");
    ps1.setString(1,per);
    ps1.setTime(2,t);
    ps1.setDate(3,date);
    ps1.setInt(4,n);
    ps1.setString(5,email);
    ps1.executeUpdate();
     response.sendRedirect("alertbox.jsp");   
%>