<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="css/main.css">
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<nav>
    <div class="nav-wrapper">
        <div class="container">
            <a class="brand-logo">CarSales</a>
            <ul class="right hide-on-med-and-down">
                <c:if test="${user == null}">
                    <li><a href="<%=request.getContextPath()%>/index">Главная</a></li>
                    <li><a href="<%=request.getContextPath()%>/login.jsp">Войти</a></li>
                </c:if>
                <c:if test="${user != null}">
                    <li><a href="<%=request.getContextPath()%>/index">Главная</a></li>
                    <li><a href="<%=request.getContextPath()%>/myPosts">Мои объявления</a></li>
                    <li><a href="<%=request.getContextPath()%>/login.jsp">Выйти</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <h1 class="center-align">
            Добавить фото
        </h1>
    </div>
    <div class="row">
        <div class="col s6">
            <div class="card-panel">
                <form action="<c:url value='/uploadPhoto?id=${param.id}'/>" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="file-field input-field">
                            <div class="btn">
                                <span>Выберете фото</span>
                                <input type="file" name="file">
                            </div>
                            <div class="file-path-wrapper">
                                <input class="file-path validate" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <button class="btn waves-effect waves-light" type="submit">добавить фото
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="js/filter.js"></script>

<script>
    $(document).ready(function () {
    });
</script>
</body>
</html>
