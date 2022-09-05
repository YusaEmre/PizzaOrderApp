<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Just Eat</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
</head>

<nav class="navbar navbar-expand-sm bg-light">

    <ul class="navbar-nav ml-auto">
        <li class="nav-item">
            <span style="margin: 10px" class="font-weight-bolder"> ${username}</span>
        </li>
        <li class="nav-item">
            <a href="<spring:url value="/login"/>" class="btn btn-danger" style="width: 5rem">Logout</a>
        </li>
    </ul>
</nav>
<body>

<div align="center">
    <h1> Order List </h1>
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
<c:forEach  items="${orders}" var="order" varStatus="loop">
<tr>
        <th scope="row">${loop.index+1}</th>
        <td>${order.orderId}</td>
        <td>${order.user.userName}</td>
        <td>${order.user.address}</td>
        <td>${order.topping.toppingName}</td>
        <td>${order.orderPlacedDate}</td>
        <td>${order.deliveryDate}</td>
        <td>${order.totalPrice}</td>
    <td><a href="<spring:url value="/api/order/editOrderPage?orderId=${order.orderId}"/>" class="btn btn-primary"  style="margin: 10px">Edit</a></td>
    </tr>
</c:forEach>
    <tbody>
</table>
</div>
</body>
</html>
