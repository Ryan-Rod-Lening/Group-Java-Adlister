<%--
  Created by IntelliJ IDEA.
  User: ryanmcguire
  Date: 2/4/21
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Error Please Try Again" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<h1>Oops!</h1>
<h3>Someone already has that username and/or email. Click on register and try again.</h3>
</body>
</html>
