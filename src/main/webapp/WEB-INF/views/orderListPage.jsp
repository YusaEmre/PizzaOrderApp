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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body style=background-image:url("../../assets/pizzabackground2.jpg");background-repeat:no-repeat,no-repeat; >

<nav class="navbar navbar-expand-sm bg-light">

    <ul>
        <li class="nav-item" style="list-style-type: none">
            <h4 style="padding: 8px; margin-right: 8px; display: inline-block;" class="font-italic ">JustEat Pizzas</h4>
        </li>
    </ul>

    <ul class="navbar-nav ml-auto">
        <li class="nav-item">
            <span style="padding: 8px; margin-right: 8px; display: inline-block" class="font-weight-bold"> ${param.username}</span>
        </li>
        <li class="nav-item">
            <a href="<spring:url value="/login"/>" class="btn btn-danger" style="width: 5rem">Logout</a>
        </li>
    </ul>
</nav>

<div align="left" style="margin-top: 2%; margin-left: 2%; position: fixed">
    <a href="<spring:url value="/home?username=${param.username}"/>" class="btn btn-secondary">
        <i class="bi bi-arrow-return-left"></i>
        Back
    </a></div>

<div align="center" style="margin-top: 2%;">
    <h1>Order List</h1>
</div>

<div align="center" style="margin-top: 10%; margin-bottom: 3%;">
    <form action="/api/order/orderDetailPage" method="GET">
    <label for="in" class="font-weight-bolder">Order Id</label>
    <input id="in" onchange="myFunc()" name="orderId" type="text"  aria-label="Default" aria-describedby="inputGroup-sizing-default">
        <input style="display: none" value="${param.username}" name="username">
    <input type="submit" value="Search Order" class="btn btn-primary"/></form>
    </form>
        <p align="center"> <p  class="text-danger">
            ${error}
        </p>
</div>


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
        <th scope="col">Edit Order</th>
        <th scope="col">Delete Order</th>

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
    <td><a href="<spring:url value="/api/order/editOrderPage?orderId=${order.orderId}&username=${param.username}"/>" class="btn btn-primary"  style="margin: 10px">Edit</a></td>
    <td><a href="<spring:url value="/api/order/deleteOrder/${order.orderId}?username=${param.username}"/>" class="btn btn-danger"  style="margin: 10px">Delete</a></td>
</tr>
</c:forEach>
    <tbody>
</table>
</div>
</body>
</html>
