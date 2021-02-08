<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <style>
        body:not(.leftNav) {
            background-color: whitesmoke;
        }
    </style>
</head>
<body>

<jsp:include page="/WEB-INF/partials/profileNavbar.jsp" />
<div class="container">
    <h1 class="text-center mt-4 mb-4">Viewing all ads!</h1>
</div>
<jsp:include page="/WEB-INF/partials/leftNav.jsp" />

<div class="container-fluid d-flex flex-wrap: wrap">
    <div class="row row-cols-3 row-cols-sm-2 row-cols-md-3 row-cols-lg-4">
    <c:forEach var="ad" items="${ads}">
        <div class="col-lg-4 m-auto">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h2>${ad.title}</h2>
                    <p class="card-text">${ad.description}</p>
                    <c:forEach var="adCategory" items="${adsCategory.get(ad)}">
                        <p>${adCategory}</p>
                    </c:forEach>
                </div>
                <a href="/ads/single?ad-title=${ad.title}" name="viewbtn" class="btn btn-primary">View Ad</a>
            </div>
        </div>
    </c:forEach>
    </div>
        </div>
</body>
</html>
