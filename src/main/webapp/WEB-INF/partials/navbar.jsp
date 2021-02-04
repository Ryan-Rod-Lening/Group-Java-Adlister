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
            <li class="nav-item">
                <a class="nav-link" href="/logout" tabindex="-1" >Log out</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <label for="searchbar"></label>
            <input id="searchbar" name="searchbar" class="form-control mr-sm-2" type="search" placeholder="Search">
            <button  class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
