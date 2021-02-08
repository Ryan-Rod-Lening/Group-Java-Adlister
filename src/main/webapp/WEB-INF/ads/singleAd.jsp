<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="view ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/UserNavbar.jsp" />
<h1 style="text-align: center">Viewing Ad</h1>
<div class="container">
    <div class="row">
<c:forEach var="ad" items="${ads}">
    <div class="col-lg-12">
    <div class="card h-100 w-100" style="width: 18rem;">
    <div class="card-body">
    <h5 class="text-center"><u>${ad.title}</u></h5>
    <p class="card-text text-center">${ad.description}</p>
    <c:forEach var="adCategory" items="${adsCategory.get(ad)}">
        <p class="text-center">${adCategory}</p>
    </c:forEach>
    </div>
    </div>
    </div>
    </c:forEach>
</body>
</html>
