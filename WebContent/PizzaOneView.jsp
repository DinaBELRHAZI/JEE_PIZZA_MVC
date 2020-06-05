<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pizza_package.Pizza"%>
<html>
<head>
<title>Bootstrap Liste Pizza</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/vendors/formvalidation/dist/css/formValidation.min.css">

<style type="text/css">
.zoom {
	-webkit-transform: scale(1);
	transform: scale(1);
	-webkit-transition: .3s ease-in-out;
	transition: .3s ease-in-out;
	width: 100%; 
	height: auto;
	
}

.zoom:hover {
	-webkit-transform: scale(1.1);
	transform: scale(1.1);
}

.caption {

	width: auto;
	height: auto;
	margin-top: 5%;
	margin-bottom: 5%;
	/* margin-right: 50%;
	margin-left: 20%; */
}
h2 {

	margin-top: 5%;
	margin-bottom: 5%;
	text-align: center;
}
p{

	margin-top: 5%;
	margin-bottom: 3%;
	border-bottom: 3px solid black; 
	position: relative; 
	top: -20px;
}
.image{

	height: 30%;
	margin-bottom : 4%;
}
</style>


</head>
<body>
	<div class="container">
		<h2>Informations de la pizza</h2>
		<p></p><!-- barre de séparation -->

			<%
				Pizza mapizza = (Pizza) request.getAttribute("mapizza");
			%>
			
			<div class="image">
				<img src="imagesPizza/<%=mapizza.getId()%>.jpg" class="zoom" alt="Lights" >	
			</div>
					
					<div class="form-group row">
					     <label class="col-sm-2 col-form-label"> Désignation Pizza :</label>
					     <div class="col-sm-10">
					        <%=mapizza.getDesignPizz()%>
					     </div>
					 </div>
				<br>
					 <div class="form-group row">
					     <label class="col-sm-2 col-form-label">Tarif Pizza :</label>
					     <div class="col-sm-10">
					        $&nbsp;<%=mapizza.getPrice()%>
					     </div>
					  </div>
				 <br>
					  <div class="form-group row">
					      <label class="col-sm-2 col-form-label">La description :</label>
					      <div class="col-sm-10">
					           <%=mapizza.getDescription()%>
					       </div>
					  </div>
					
					<p></p><!-- barre de séparation -->
					<a class="btn btn-warning"	href="${pageContext.request.contextPath}/ControllerPizza?action=modifpizza&idpizza=<%=mapizza.getId()%>"
											role="button">Modifier</a> 
					<a class="btn btn-primary" href="${pageContext.request.contextPath}/ControllerPizza?action=Listpizza"
						role="button">Retour à la liste</a> 
					
</div>
</body>
</html>
