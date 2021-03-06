<%--
  Created by IntelliJ IDEA.
  User: macowner
  Date: 2/4/21
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Search Page" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/UserNavbar.jsp" />
<div class="container-fluid">
    <div class="row" style="background-color: #E6F0E8">
        <div class="col-xs-offset-4 col-xs-4">
            <h1 class="text-center">Search Page</h1>
        </div>
    </div>
</div>
<hr>
<div class="container-fluid d-flex justify-content: center" >

    <c:forEach var="ad" items="${search}">
        <div class="card col-sm-6 col-md-4 col-lg-3 m-auto" style="height: 24rem;">
                <%--<img class="card-img-top" src="..." alt="Card image cap">--%>
            <div class="card-body" style="border: 1px solid black">
                <h5 class="card-title">${ad.title}</h5>
                <p class="card-text">${ad.description}</p>
            </div>
            <a href="/ads/single?ad-title=${ad.title}" name="viewbtn" class="text-center center-block">View Full Ad</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
