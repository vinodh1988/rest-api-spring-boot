<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h1>Welcome to the Home Page!</h1>
    <p>This is a JSP page served by Spring Boot.</p>
    <h3><u> Programmers </u></h3>
    <ul>
    <%
    //scriptlet
    String[] names= (String[])request.getAttribute("names");
    for(String n:names) {
    %>
    <li><%=n%></li>
    <%}%>
    </ul>
    
</body>
</html>