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
		out.println("Account Number : " + cb.getAccountNumber() + "<br>");
	%>
	<a href="Deposit.html">Deposit</a>
	<a href="WithDraw.html">WithDraw</a>
	<a href="CheckBalance.html">Check Balance</a>
	<a href="TransferAmount.html">Transfer Amount</a>
	<a href="updateinfo">Update Information</a>
	<a href="DeleteAccount.html">Delete Account</a>
	<a href="logout">Logout</a>
</body>
</html>