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
		out.println("Name : " + cb.getName() + "<br>");
		out.println("Amount WithDrawn : " + Integer.parseInt(request.getParameter("amount"))+ "<br>");
		out.println("Remaining Balance : " + cb.getBalance() + "<br>");
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