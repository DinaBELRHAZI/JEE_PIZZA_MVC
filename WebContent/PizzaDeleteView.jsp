<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pizza_package.Pizza"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Delete</title>
</head>
<body>
<h1> Vous avez bien supprimer la pizza</h1>

<a class="btn btn-primary"	href="${pageContext.request.contextPath}/ControllerPizza?action=Listpizza"	role="button">Retour à la liste</a> 
</body>
</html>