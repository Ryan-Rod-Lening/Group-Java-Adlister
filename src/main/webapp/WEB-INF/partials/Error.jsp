<%--
  Created by IntelliJ IDEA.
  User: ryanmcguire
  Date: 2/5/21
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.Error}"><p>${ sessionScope.Error}</p></c:if>
