<html>
<head><title>FIBONACCI SERIES IN JSP</title></head>
<body>
<form method="get">
<h3> Enter the number of terms you want:
<input type="text" name="limit">
</h3>
</form>
<h3>
<%
 String s = request.getParameter("limit");
 if (s != null) {
%>
<%@ page import = "java.io.*" %>
<%@ page import = "java.lang.*" %>
<%
    int n=0;
    n=Integer.parseInt(s);
   out.println("No of terms to be printed is  "+n);
%>
<br>
<br>
<br>
The series generated are listed below Hello :<br><br>
<%
    long a=1;
    long b=1;
   out.println(""+a+",\t"+b+",\t");
  for(int i=3;i<= n;i++)
{
    long c=a+b;
   out.print(""+c+",\t");
  a=b;
 b=c;
}
}
%>
</h3>
</body>
</html>
