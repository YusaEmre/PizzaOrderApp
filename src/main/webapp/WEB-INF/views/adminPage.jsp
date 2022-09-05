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
<body>
<nav>${username}</nav>
<div align="center" style="with: 50%; padding: 5px; margin-top: 10%; margin-bottom: 5px">
    <h1>Welcome to Just Eat Pizza</h1>
    <span style="padding:15px;"></span>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <a href="<spring:url value="/api/order/toppingsPage?username=${username}"/>" class="btn btn-primary" style="width: 18rem">Toppings</a>
        </div>
    </div>
    <span style="padding:5px;"></span>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <a href="<spring:url value="/api/order/orderListPage?username=${username}"/>" class="btn btn-primary" style="width: 18rem">Orders</a>
        </div>
    </div>
    <span style="padding:5px;"></span>
</div>
</body>
</html>