<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Just Eat</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body style=background-image:url("../../assets/pizzabackground2.jpg");background-repeat:no-repeat,no-repeat;>
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
    <h1>Edit Topping</h1>

    <form action="/api/topping/updateTopping?username=${username}" method="post" modelAttribute="ToppingEditRequest">
        <table border="0" style="with: 50%; padding: 5px; margin-top: 10%; margin-bottom: 5px">
            <tr>
                <td>Topping Id</td>
                <td><input readonly type="text" name="toppingId" value="${topping.id}"/></td>
            </tr>
            <tr>
                <td>Topping Name</td>
                <td><input  type="text" name="toppingName" value="${topping.toppingName}"/></td>
            </tr>
            <tr>
                <td>Topping Price</td>
                <td><input  type="text" name="toppingPrice" value="${topping.toppingPrice}"/></td>
            </tr>
        </table>
        <input style="margin: 10px" type="submit" value="Submit" class="btn btn-primary"/></form>



</div>
</body>
</html>
