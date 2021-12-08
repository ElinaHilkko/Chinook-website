<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Album List</title>
	<!--  <script src="/scripts/app.js"></script>	-->
	
	<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura-dark-solarized.css" type="text/css">
	<style> ul { max-width: 400px; } ul li button { float: right;} </style>
</head>
<body>
	<h1>Albums of ${ artist.getName() }</h1>

	<ul>
		<c:forEach items="${ albums }" var="albums">
			<li>
				<c:out value="${ albums.getTitle() }" />
			</li>
		</c:forEach>
	</ul>
	
	<a href="/artistlist">Back</a>
</body>
</html>