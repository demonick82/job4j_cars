<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
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
    <title>Авторизация</title>
</head>

<body>
<nav>
    <div class="nav-wrapper">
        <div class="container">
            <a class="brand-logo">CarSales</a>
            <ul class="right hide-on-med-and-down">
                <li><a href="<%=request.getContextPath()%>/index">Главная</a></li>
                <li><a href="<%=request.getContextPath()%>/register.jsp">Регистрация</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col s6 offset-s3">
            <h4 class="header center-align">Авторизация</h4>
            <div class="card horizontal">
                <div class="card-stacked row">
                    <form action=<%=request.getContextPath()%>/login method="post" class="col s12">
                        <div class="card-content">
                            <div class="row">
                                <div class="input-field col s12">
                                    <input placeholder="" id="email" type="email" name="email" class="validate"
                                           required>
                                    <label class="active" for="email">Почта</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <input placeholder="" id="password" type="password" name="password" class="validate"
                                           required>
                                    <label class="active" for="password">Пароль</label>
                                </div>
                            </div>
                        </div>
                        <div class="card-action right-align">
                            <button type="submit" class="waves-effect waves-light btn">
                                Войти
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="error center-align" style="color:#ff0000; font-weight: bold"><c:out value="${error}"/>
            </div>
        </div>
    </div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>