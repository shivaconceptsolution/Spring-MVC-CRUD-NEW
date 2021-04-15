<%@page import="org.springframework.ui.ModelMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>  
<%@page import="org.hibernate.cfg.*" %> 
<%@page import="org.hibernate.*" %>   
<%@page import="java.util.*" %>  
<%@page import="dao.Register" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updatereg" method="post">
<%
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sf = cfg.buildSessionFactory();
Session s = sf.openSession();
Query q = s.createQuery("from Register r where r.id=?");
q.setInteger(0,Integer.parseInt(request.getAttribute("res").toString()));
List lst= q.list();
Iterator it = lst.iterator();
while(it.hasNext())
{
	Register r = (Register)it.next();%>
	<input type="text" value="<%= r.getId() %>" name="txtid" /> <br> <br>
    <input type="text" value="<%= r.getEmailid() %>" name="txtemail" /> <br> <br>
    <input type="text" value="<%= r.getPassword() %>" name="txtpass" /><br> <br>
    <input type="submit" name="btnsubmit" value="Update" />
    
<%}
sf.close();

%>
</form>
</body>
</html>