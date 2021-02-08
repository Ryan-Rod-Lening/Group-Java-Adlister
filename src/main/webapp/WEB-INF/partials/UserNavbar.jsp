<%--
  Created by IntelliJ IDEA.
  User: macowner
  Date: 2/3/21
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#">Adlister</a>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0 m-auto">
            <li class="nav-item">
                <a class="nav-link" href="/ads" tabindex="-1" >View Ads</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout" tabindex="-1" >Log Out</a>
            </li>
            <li class="nav-item">
                <a href="/ads/create" class="nav-link" tabindex="-1">Create an Ad</a>
            </li>
            <li class="nav-item">
                <a href="/profile" class="nav-link" tabindex="-1">profile</a>
            </li>
        </ul>
            <form action="/ads/search" method="get"  class="form-inline my-2 my-lg-0">
            <label for="searchbar"></label>
            <input id="searchbar" name="searchbar"  class="form-control mr-sm-2" type="search" placeholder="Search">
            <button  class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
    </div>
</nav>

