<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div align="center">
    <h1>Place Order</h1>

    <form action="home" method="get" modelAttribute="Order">
        <table border="0" style="with: 50%; padding: 5px; margin-top: 10%; margin-bottom: 5px">
            <tr>
                <td>Customer Id</td>
                <td><input readonly type="text" name="customerId" value="${order.user.id}"/></td>
            </tr>
            <tr>
                <td>Customer Name</td>
                <td><input readonly type="text" name="customerName" value="${order.user.name}"/></td>
            </tr>
            <tr>
                <td>Customer Last Name</td>
                <td><input readonly type="text" name="customerLastName" value="${order.user.lastName}"/></td>
            </tr>
            <tr>
                <td>Customer Address</td>
                <td><input  readonly type="text" name="customerAddress" value="${order.user.address}"/></td>
            </tr>
            <tr>
                <td>Customer Phone Number</td>
                <td><input  readonly type="text" name="customerPhoneNumber" value="${order.user.phoneNumber}"/></td>
            </tr>
            <tr>
                <td>Total Price</td>
                <td><input readonly type="text" name="customerPhoneNumber" value="${order.totalPrice}"/></td>
            </tr>
            <tr>
                <td>Topping</td>
                <td><input type="text" name="customerPhoneNumber" value="${order.topping.toppingName}"/></td>
            </tr>
        </table>
        <span style="padding: 50px"></span>
        <input type="submit" value="Ok" class="btn btn-primary"/></form>

</div>
</body>
</html>

