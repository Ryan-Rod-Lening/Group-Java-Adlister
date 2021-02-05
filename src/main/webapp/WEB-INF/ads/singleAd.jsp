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

<div class="container-fluid d-flex flex-wrap" >
        <hr>
        <c:forEach var="ad" items="${single}">
            <div class="card col-sm-6 col-md-4 col-lg-3" style="height: 24rem;">
                    <%--<img class="card-img-top" src="..." alt="Card image cap">--%>
                <div class="card-body" style="border: 1px solid black">
                    <h5 class="card-title">${ad.title}</h5>
                    <p class="card-text">${ad.description}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>
