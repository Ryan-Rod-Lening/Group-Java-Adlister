<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">

        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
    <jsp:include page="/WEB-INF/partials/UserNavbar.jsp" />
    <jsp:include page="/WEB-INF/partials/leftNav.jsp" />
    <script>
        function myFunction() {
            document.getElementById("demo").innerHTML = "Paragraph changed.";
        }
    </script>
</head>
<body>
    ${title_error}
    ${description_error}
    ${category_error}
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <div class="form-group">
                <fieldset>
                    <label>Category</label><br>
                    <input type="checkbox" id="electronics" name="category" value="Electronics">Electronics<br>
                    <input type="checkbox" id="animals" name="category" value="Animals">Animals<br>
                    <input type="checkbox" id="food" name="category" value="Food">Food<br>
                    <input type="checkbox" id="events" name="category" value="Events">Events<br>
                </fieldset>
                <br>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
