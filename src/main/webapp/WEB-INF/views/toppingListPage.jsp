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

<div align="center">
    <table class="table" style="width: 70%; padding: 5px; margin-top: 20%">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Topping Id</th>
            <th scope="col">Topping Name</th>
            <th scope="col">Topping Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach  items="${toppings}" var="topping" varStatus="loop">
        <tr>
            <th scope="row">${loop.index+1}</th>
            <td>${topping.id}</td>
            <td>${topping.toppingName}</td>
            <td>${topping.toppingPrice}</td>
            <td><a href="<spring:url value="/api/topping/toppingEditPage?username=${username}&toppingId=${topping.id}"/>" class="btn btn-primary"  style="margin: 10px">Edit</a></td>
        </tr>
        </c:forEach>
        <tbody>
    </table>
</div>
</body>
</html>
