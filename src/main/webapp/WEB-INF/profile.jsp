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
        <h1 style="text-align: center" class="my-3">Welcome to your profile!</h1>
    </div>
    <c:if test="${validationFail}">
        <div class="validation-fail-div">
            <p style="color:red;text-align: center;margin-bottom:5px"><b>${validationFailMsg}</b></p>
            <p style="color:red;text-align: center;margin-bottom:0">${userValidation}</p>
            <p style="color:red;text-align: center">${emailValidation}</p>
        </div>
    </c:if>
    <container style="justify-content: center" class="container-fluid d-flex flex-wrap: wrap">
        <form class="pre-edit-form text-center">
            <div>
                <b>Username: </b><label id="username-value" class="form-label">${sessionScope.user.username}</label>
            </div>
            <div class="mb-3">
                <b>Email address: </b><label id="email-value" class="form-label">${sessionScope.user.email}</label>
            </div>
            <button type="submit" class="btn btn-primary">Edit Profile</button>
        </form>
    </container>
    <h4 class="mt-2 mb-4" style="text-align: center">Your personal ads</h4>
    <container class="container-fluid">
        <div class="row row-cols-3 row-cols-sm-2 row-cols-md-3 row-cols-lg-4">
            <c:forEach var="ad" items="${ads}">
                <div class="col-lg-4">
                    <div class="card h-100 w-100" style="width: 18rem;">
                        <div class="card-body">
                            <h5><u>${ad.title}</u></h5>
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
