<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/UserNavbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
    <container class="container-fluid d-flex flex-wrap: wrap">
        <div class="row row-cols-3 row-cols-sm-2 row-cols-md-3 row-cols-lg-4">
            <c:forEach var="ad" items="${ads}">
                <div class="col-lg-4">
                    <div class="card h-100 w-100" style="width: 18rem;">
                        <div class="card-body">
                            <h2>${ad.title}</h2>
                            <p class="card-text">${ad.description}</p>
                            <c:forEach var="adCategory" items="${adsCategory.get(ad)}">
                                <p>${adCategory}</p>
                            </c:forEach>
                        </div>
                        <a href="/ads/single" class="btn btn-primary">View Ad</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </container>
</body>
</html>
