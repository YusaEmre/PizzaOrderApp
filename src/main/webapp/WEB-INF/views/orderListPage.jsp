<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <i ></i>
</nav>

<
<div align="center">
<table class="table" style="width: 70%; padding: 5px; margin-top: 20%">
    <thead>
<tr>
        <th scope="col">#</th>
        <th scope="col">OrderId</th>
        <th scope="col">UserName</th>
        <th scope="col">Address</th>
        <th scope="col">Topping</th>
        <th scope="col">Order Placed Date</th>
        <th scope="col">Delivery Date</th>
        <th scope="col">Total</th>
    </tr>
    </thead>
    <tbody>
<c:forEach  items="${orders}" var="order">
<tr>
        <th scope="row">1</th>
        <td>${order.orderId}</td>
        <td>${order.user.userName}</td>
        <td>${order.user.address}</td>
    <c:forEach  items="${order.topping}" var="ord">
        <td>
            ${ord.toppingName}
        </td>
    </c:forEach>
        <td>${order.orderPlacedDate}</td>
        <td>${order.deliveryDate}</td>
        <td>${order.totalPrice}</td>
    </tr>
</c:forEach>
    <tbody>
</table>
</div>
</body>
</html>
