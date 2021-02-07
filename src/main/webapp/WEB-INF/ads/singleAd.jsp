<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macowner
  Date: 2/5/21
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="view ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/UserNavbar.jsp" />
<h1 style="text-align: center">Viewing Add</h1>
<div class="container">
    <div class="row">
        <c:forEach var="ad" items="${single}">
            <div class="col-md-4 col-md-offset-1 center-block">
                <h2>${ad.title}</h2>
                <p class="description">${ad.description}</p>

            </div>

        </c:forEach>
    </div>
</div>
</body>
</html>
