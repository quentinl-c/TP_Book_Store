<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="header.jsp"%>
<title>Checkout</title>
</head>
<body>
	<div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="large-12 cell">
                <h3>Checkout</h3>
                <table>
                    <tr>
                        <th>Quantity</th>
                        <th>Title</th>
                        <th>Unit price</th>
                        <th>€</th>
                    </tr>
                    
                    <c:forEach var="item" items="${cart.items}">
                    <tr>
                        <td>
                          <c:out value='${item.quantity}'/>
                        </td>
                        <td><c:out value='${item.book.title}'/></td>
                        <td><c:out value='${item.book.price}'/> €</td> 
                        <td><c:out value='${item.getTotal()}'/> €</td>
                    </tr>
                </c:forEach>
                	<tr>
                		<td></td>
                		<td>Total</td>	
                		<td></td>
                		<td><c:out value='${cart.getTotal()}'/> €</td>
                	</tr>
            </table>
            <h4>Information</h4>
             <c:if test="${not empty error}">
                <div class="alert callout" aria-live="assertive" role="alert" style="display: block;">
    				<p><c:out value='${error}'></c:out></p>
  				</div>
  			</c:if>
            <form action="ProcessInvoice" method="POST">
            	<label>
            		Name
            		<input type="text" name="name" value='${name}'>
            	</label>
            	<label>
            		Address
            		<input type="text" name="address" value='${address}'>
            	</label>
            	<input type="submit" value="buy" class="success button">
            </form>
           	<a class="button" href="welcome">Go shopping</a>
            </div>
        </div>
    </div>
</body>
</html>