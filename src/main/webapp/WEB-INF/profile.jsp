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
        <h1 style="text-align: center">Welcome, ${sessionScope.user.username}!</h1>
    </div>
    <container style="justify-content: center" class="container-fluid d-flex flex-wrap: wrap">
        <form class="pre-edit-form text-center">
            <div class="mb-3">
                <label class="form-label">Email address</label>
            </div>
            <div class="mb-3">
                <label class="form-label">Password</label>
            </div>
            <button type="submit" class="btn btn-primary">Edit Profile</button>
        </form>
    </container>
    <container class="container-fluid d-flex flex-wrap: wrap">
        <h4>Your personal ads</h4>
        <div class="row row-cols-3 row-cols-sm-2 row-cols-md-3 row-cols-lg-4">
            <c:forEach var="ad" items="${ads}">
                <div class="col-lg-4">
                    <div class="card h-50 w-100" style="width: 18rem;">
                        <div class="card-body">
                            <h2>${ad.title}</h2>
                            <p class="card-text">${ad.description}</p>
                            <c:forEach var="adCategory" items="${adsCategory.get(ad)}">
                                <p>${adCategory}</p>
                            </c:forEach>
                            <a href="#" class="btn btn-primary">View Ad</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </container>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/profile.js"></script>
</body>
</html>
