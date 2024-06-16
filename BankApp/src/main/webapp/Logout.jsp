<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.CustomersBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		CustomersBean cb = (CustomersBean)session.getAttribute("customersbean");
		String msg = (String)session.getAttribute("msg");
		out.println(msg);
		session.invalidate();
	%>
	<jsp:include page="Home.html"></jsp:include>
</body>
</html>