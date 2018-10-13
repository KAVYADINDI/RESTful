<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<h3>Cart Items</h3>
<br>
<br><br>
	<table class="table table-bordered">
		<thead align="center">
			<tr>
				<th scope="col">Product Id</th>
				<th scope="col">Quantity</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="i" items="${sessionScope.cart}">
				<tr>
				<td>${i.product.productId}</td>
				<td>${i.quantity}</td>
				<td>${i.price}</td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><strong>Total: ${sessionScope.totalAmount}</strong></td>
				</tr>
		</tbody>
	</table>
</body>
</html>