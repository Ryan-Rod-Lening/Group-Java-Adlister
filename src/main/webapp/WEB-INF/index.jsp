<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../CSS/landingPage.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1 class="text-center mt-4 mb-4">Welcome to Adlister!</h1>
    </div>
    <jsp:include page="/WEB-INF/partials/leftNav.jsp" />
<%--    title--%>

<%--    cars for ads--%>
    <container class="container-fluid">
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
                        <a href="#" class="btn btn-primary">View Ad</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </container>
    </container>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
