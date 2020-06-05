<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pizza_package.Pizza"%>
<html>
<head>
<title>Modification</title>
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

	margin-top: 10%;
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

</style>
</head>
<body>

<form method="GET" action="${pageContext.request.contextPath}/ControllerPizza" enctype="multipart/form-data"> 

<div class="container">
<h2>Formulaire de modification</h2>
<p></p><!-- barre de séparation -->

			<%
				Pizza modifpizza = (Pizza) request.getAttribute("modifpizza");
			%>
			
			<input type="hidden" name="action" value=modifpizzavalid>
			<input type="hidden" name="idpizza" value="<%=modifpizza.getId()%>">
							
				<div class="form-group row">
					<label class="col-sm-2 col-form-label"> Nom de la pizza :</label>
					<div class="col-sm-10">
					   <input type="text" class="form-control" name="DesignPizz" value="<%=modifpizza.getDesignPizz()%>" required/>
					</div>
				</div>
			<br>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Tarif Pizza :</label>
					<div class="col-sm-10">
					      <div class="input-group">
					            <div class="input-group-prepend">
					               <span class="input-group-text">$</span>
					            </div>
					            <input type="number" name="TarifPizz" class="form-control" value="<%=modifpizza.getPrice()%>" required/>
					      </div>
				    </div>
				</div>
			<br>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">La description :</label>
					<div class="col-sm-10">
					   <input type="text" class="form-control" name="Description" value="<%=modifpizza.getDescription()%>" required/>
					</div>
				</div>
			<button type="submit" name="submit" class="btn btn-success">Valider</button>
				
			<p></p><!-- barre de séparation -->
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/ControllerPizza?action=Listpizza" role="button">Retour à la liste</a>	 
	
</div>					
</form>

</body>
</html>