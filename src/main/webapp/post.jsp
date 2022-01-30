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
            <c:out value="${post.model.brand.name}"/>
            <c:out value="${post.model.name}"/>
            <c:out value="${post.productionYear}"/>
            <span><c:out value="${post.price}"/> Р </span>
        </h1>
    </div>
    <div class="row">
        <div class="col s4">
            <div class="card-panel" style="font-size: 20px">
                <p>Год выпуска: <c:out value="${post.productionYear}"/></p>
                <p>Пробег: <c:out value="${post.mileage}"/></p>
                <p>Цвет: <c:out value="${post.color}"/></p>
                <p>Кузов: <c:out value="${post.carBoby.name}"/></p>
                <p>Коробка: <c:out value="${post.transmission.name}"/></p>
                <p>Привод: <c:out value="${post.driveUnit}"/></p>
                <p>Комментарий продавца: <c:out value="${post.description}"/></p>
                <p>Продавец: <c:out value="${post.user.name}"/></p>
                <p>Телефон: <c:out value="${post.user.phone}"/></p>
            </div>
        </div>
        <div class="col s8">
            <div class="card">
                <div class="carousel carousel-slider">
                    <c:forEach items="${post.photos}" var="photo">
                        <a class="carousel-item" href="#!"> <img
                                src="<c:url  value='/downloadPost?path=${photo.path}'/>" /> </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script>
    $(document).ready(function () {
        $('.carousel.carousel-slider').carousel({
            fullWidth: true,
            indicators: true
        });
    });</script>
</body>
</html>