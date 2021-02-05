<%--
  Created by IntelliJ IDEA.
  User: macowner
  Date: 2/3/21
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">About Adlister</a>
    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarToggleDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggle-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarToggleDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="/register">Register <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Log In</a>
            </li>
            </ul>
        <form action="/ads/search" method="get"  class="form-inline my-2 my-lg-0">
            <label for="searchbar" name="searchbar"></label>
            <input id="searchbar"  class="form-control mr-sm-2" type="search" placeholder="Search">
            <button  class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
