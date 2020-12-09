<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    String user=request.getParameter("user");
    String email=request.getParameter("email");
    String pass=request.getParameter("pass");
    String cpass=request.getParameter("cpass");
    if(cpass.equals(pass))
    {
    session.setAttribute("User",user);
    session.setAttribute("Email",email);
    Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
PreparedStatement ps=con.prepareStatement("insert into logintable(UserName,Email,Password) values(?,?,?)");
    ps.setString(1,user);
    ps.setString(2,email);
    ps.setString(3,pass);
    ps.executeUpdate();
     response.sendRedirect("index.jsp");
    }
    
    %>