<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Artist List</title>
	<!--  <script src="/scripts/app.js"></script>	-->
	
	<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura-dark-solarized.css" type="text/css">
	<style> ul { max-width: 400px; } ul li button { float: right;} </style>
</head>
<body>
	<h1>All Artists</h1>
	
	<form method="post">
    	<input name="name" type="text" required placeholder="type item here..." autofocus /> 
    	<input type="submit" value="Add to list" />
	</form>

	<ol>
		<c:forEach items="${ artists }" var="artist">
			<li>
				<c:out value="${ artist.getName() }" />
			</li>
		</c:forEach>
	</ol>
</body>
</html>