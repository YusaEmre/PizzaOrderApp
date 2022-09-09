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
    <script>
        function myFunc() {
            var  price= $("#selected").val();
            var sum = parseFloat(price) + parseFloat("350")
            $("#price").val(sum);
        }
    </script>


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
    <h1>Edit Your Order</h1>

    <form action="/api/order/updateOrder?username=${username}" method="post" modelAttribute="OrderEditRequest">
        <table border="0" style="with: 50%; padding: 5px; margin-top: 10%; margin-bottom: 5px">
            <tr>
                <td>Order Id</td>
                <td><input readonly type="text" name="orderId" value="${order.orderId}"/></td>
            </tr>
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
                <td><input readonly type="text" name="customerAddress" value="${order.user.address}"/></td>
            </tr>
            <tr>
                <td>Customer Phone Number</td>
                <td><input readonly type="text" name="customerPhoneNumber" value="${order.user.phoneNumber}"/></td>
            </tr>
            <tr>
                <td>Toppings</td>
                <td>
                    <div class="dropdown">
                        <select id="selected"  onchange="myFunc()" name="toppingPrice" style="width: 18rem" >
                                <c:forEach var="topping" items="${toppings}">
                                    <option value="${topping.toppingPrice}"  ${topping.toppingName == order.topping.toppingName ? 'selected="selected"' : ''}>${topping.toppingName}</option>
                                </c:forEach>
                        </select>
                    </div></td>
            </tr>
            <tr>
                <td>Delivery date</td>
                <td>
                    <input readonly name="deliveryDate" type="text" id="datepicker" value="${order.deliveryDate}">
                </td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>
                    <input name="totalPrice" readonly value="${order.totalPrice}" type="text" id="price" >
                </td>
            </tr>
        </table>
        <input style="margin: 10px" type="submit" value="Submit" class="btn btn-primary"/></form>



</div>
</body>
</html>
