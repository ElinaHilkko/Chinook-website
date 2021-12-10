<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Result List</title>
	<!--  <script src="/scripts/app.js"></script>	-->
	
	<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura-dark-solarized.css" type="text/css">
	<style> ul { max-width: 400px; } ul li button { float: right;} </style>
</head>
<body>
	<h1>Result of Artist and Album Search</h1>
	
	<p>Artists</p>
	<ul>
		<c:forEach items="${ artists }" var="artist">
			<li>
				<a href=/albums?ArtistId=<c:out value='${ artist.getArtistId() }'/>><c:out value="${ artist.getName() }" /></a>
			</li>
		</c:forEach>
	</ul>
	
	<p>Albums</p>
	<ul>
		<c:forEach items="${ albums }" var="album">
			<li>
				<a href=/albums?ArtistId=<c:out value='${ album.getArtistId() }'/>><c:out value="${ album.getTitle() }" /></a>
			</li>
		</c:forEach>
	</ul>
	
	<a href="/artistlist">Return to All Artist</a>
</body>
</html>