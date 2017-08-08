<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="file" items="${files}">
	<a href=/${file}>${file}</a>
	<br>
</c:forEach>