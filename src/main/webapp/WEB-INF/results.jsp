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
				<!-- <c:out value="${ artist.getName() }" /> -->
				<a href=/albums?ArtistId=${ artist.getArtistId() }>${ artist.getName() }</a>
			</li>
		</c:forEach>
	</ul>
	
	<p>Albums</p>
	<ul>
		<c:forEach items="${ albums }" var="album">
			<li>
				<!-- <c:out value="${ artist.getName() }" /> -->
				<a href=/albums?ArtistId=${ album.getArtistId() }>${ album.getTitle() }</a>
			</li>
		</c:forEach>
	</ul>
	
	<a href="/artistlist">Back</a>
</body>
</html>