<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<title>Book Store</title>
<body>
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="large-12 cell">
                <h3>Todo List</h3>
                <table>
                    <tr>
                    	<th>Task</th>
                    	<th></th>
                    </tr>
                   <!-- It's up to you-->
                </table>
                <form action="AddTask" method="post">
                	<label>
                		One more thing to do ...
                		<!-- It's up to you-->
                	</label>
                	<input type="submit" value="Add new task" class="success button">
                </form>
            </div>
        </div>
    </div>
</body>
</html>