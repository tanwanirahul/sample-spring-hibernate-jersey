<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Task</title>
</head>
<body>
<form:form commandName="tasks">
    <table>
        <tr>
            <td>Title:</td>
            <td><form:input path="title"/> </td>
        </tr>
        <tr>
            <td collspan="2"> <input type="submit" value="Add Task!"></td>
        </tr>
    </table>
</form:form>
</body>
</html>