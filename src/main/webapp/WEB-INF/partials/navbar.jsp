<%--<nav class="navbar navbar-default">--%>
<%--    <div class="container-fluid">--%>
<%--        <!-- Brand and toggle get grouped for better mobile display -->--%>
<%--        <div class="navbar-header">--%>
<%--            <a class="navbar-brand" href="/ads">Adlister</a>--%>
<%--        </div>--%>
<%--        <ul class="nav navbar-nav navbar-right">--%>
<%--            <li><a href="/login">Login</a></li>--%>
<%--            <li><a href="/logout">Logout</a></li>--%>

<%--        </ul>--%>
<%--    </div><!-- /.navbar-collapse -->--%>
<%--    </div><!-- /.container-fluid -->--%>
<%--</nav>--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#">Adlister</a>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0 m-auto">
            <li class="nav-item">
                <a class="nav-link" href="/register" tabindex="-1">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login" tabindex="-1">Log In</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ads/create" tabindex="-1">Create Ad</a>
            </li>
            <li class="nav-item">
                <a href="/profile" class="nav-link" tabindex="-1">profile</a>
            </li>
        </ul>
        <form action="/ads/search" method="get"  class="form-inline my-2 my-lg-0 justify-content: right">
            <label for="searchbar"></label>
            <input id="searchbar" name="searchbar" class="form-control mr-sm-2" type="search" placeholder="Search">
            <button  class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
    </div>
</nav>
