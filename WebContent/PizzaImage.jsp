<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Image de la pizza</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

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
	

		<form action="FileUpload" method="POST" enctype="multipart/form-data">
			
			<div class="container">
				<h2>Image de votre pizza</h2>
				<p></p><!-- barre de séparation -->
						<div class="alert alert-warning" role="alert">
						  Attention ! Le nom de votre image doit être exactement le même que votre nom de pizza.
						</div>
						<p></p><!-- barre de séparation -->
						<div class="form-group row">
					        <label class="col-sm-2 col-form-label"> Image :</label>
					        <div class="col-sm-10">
					           <input type="file" name="fileToUpload" class="form-control" required/>
					           <p>format accepté : png, jpg, PNG, JPG </p>
					        </div>
					    </div>
						<br>
						<button type="submit" name="submit" class="btn btn-success">Envoyer</button>
			</div>

		</form>
	</body>
</html>

