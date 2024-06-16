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
		String msg = (String)request.getAttribute("msg");
		out.println(msg);
		out.println("Name : " + cb.getName() + "<br>");
	%>
	<form method="post" action="update">
		<input type="hidden"  name="accno" value=<%=cb.getAccountNumber()%>><br>
		<input type="text"  name="uname" value=<%=cb.getUsername()%> placeholder="Update Username"  required><br><br>
		<input type="text"  name="pword" value=<%=cb.getPassword()%> placeholder="Update Password" required><br><br>
		<input type="text" name="addrs" value=<%=cb.getAddress()%> placeholder="Update Address" required><br><br>
		<input type="number"  name="pinno" value=<%=cb.getPinNumber()%> placeholder="Update PinNumber" required><br><br>
		<input type="submit"  value="update"><br><br>
	</form>
</body>
</html>