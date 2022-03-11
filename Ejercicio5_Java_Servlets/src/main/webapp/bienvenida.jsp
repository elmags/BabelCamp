<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/stylebienvenida.css">
	<title>Bienvenido</title>
</head>

<body>
	<h1>!Bienvenido, ${User.username}!</h1>
	<div class="content">
		<div class="borde">
			<h2>Ejercicios BabelCamp</h2>	
			<p>En esta página se encuentran enlazados los ejercicios 2 y 3.</p>
			<dl>
				<dt><a href="ej2_index.html">Ejercicio2_HTML</a></dt>
				<dd>Web con HTML y CSS dedicada a viajes. <br/>
					En cuanto a HTML, contiene divs, enlaces, imágenes, formularios, tablas y botones.</dd>
				<dt><a href="ej3_index.html">Ejercicio3_HTML_CSS</a></dt>
				<dd>Curriculum con HTML y CSS. <br/>
					En cuanto a HTML, contiene divs, imágenes, lineas, y listas.</dd>
			</dl>
		</div>
	</div>
</body>

</html>