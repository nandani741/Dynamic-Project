package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.Time;
import java.sql.Date;

public final class rev_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    
    ArrayList<Integer>l1=new ArrayList();
        ArrayList l2=new ArrayList();
   String per=request.getParameter("person");
   String datte=request.getParameter("datte");
   String time=request.getParameter("ttime");
   java.sql.Date date=java.sql.Date.valueOf(datte);
   SimpleDateFormat fd=new SimpleDateFormat("HH:mm");
   long ms=fd.parse(time).getTime();
   Time t=new Time(ms);
   String email=(String)session.getAttribute("email");
     Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
PreparedStatement ps=con.prepareStatement("select * from logintable where email=? ");
ps.setString(1, email);
 ResultSet rs=ps.executeQuery();
  if(rs.next())
  {
      l1.add(rs.getInt(4));
  }
   rs.close();
   ps.close();
   con.close();
   l2.add(email);
    Class.forName("com.mysql.jdbc.Driver");
Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
PreparedStatement ps1=con1.prepareStatement("insert into reserve(noPerson,time,date,id,name) values(?,?,?,?,?)");
    ps1.setString(1,per);
    ps1.setTime(2,t);
    ps1.setDate(3,date);
    ps1.setInt(4,l1.get(0));
    ps1.setString(5,email);
    ps1.executeUpdate();
     response.sendRedirect("index.jsp");   

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
