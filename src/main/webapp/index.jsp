<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="css/main.css">

    <!--Let browser know website is optimized for mobile-->
    <title>Главная</title>
</head>
<body>
<nav>
    <div class="nav-wrapper">
        <div class="container">
            <a class="brand-logo">CarSales</a>
            <ul class="right hide-on-med-and-down">
                <c:if test="${user == null}">
                    <li>Приветствуем    Гость</li>
                    <li><a href="<%=request.getContextPath()%>/index">Главная</a></li>
                    <li><a href="<%=request.getContextPath()%>/login.jsp">Войти</a></li>
                </c:if>
                <c:if test="${user != null}">
                    <li>Приветствуем <c:out value="${user.name}"/></li>
                    <li><a href="<%=request.getContextPath()%>/index">Главная</a></li>
                    <li><a href="<%=request.getContextPath()%>/createPost">Добавить объявление</a></li>
                    <li><a href="<%=request.getContextPath()%>/myPosts">Мои объявления</a></li>
                    <li><a href="<%=request.getContextPath()%>/logout">Выйти</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col s3">
            <div class="card-panel">
                <h5 class="center-align">Поиск автомобиля</h5>

                <form action="<%=request.getContextPath()%>/findPosts" method="get">
                    <div class="row">
                        <div class="input-field col s12">
                            <select id="mark" name="mark">
                            </select>
                            <label>Выберете марку</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <input id="priceStart" type="text" name="priceStart" class="validate" value="0"
                                   required pattern="^[0-9]+$">
                            <label for="priceStart">Цена от</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="priceFinish" type="text" name="priceFinish" class="validate" value="3000000"
                                   required pattern="^[0-9]+$">
                            <label for="priceFinish">Цена до</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="yearStart" type="text" class="validate" name="yearStart" value="1970"
                                       required pattern="^[0-9]+$">
                                <label for="yearStart">Год выпуска от</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="yearFinish" type="text" class="validate" name="yearFinish" value="2022"
                                       required pattern="^[0-9]+$">
                                <label for="yearFinish">Год выпуска до</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <select id="carBody" name="carBody">
                            </select>
                            <label>Выберете кузов</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <select id="transmission" name="transmission">
                            </select>
                            <label>Выберете коробку</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <select id="driveUnit" name="driveUnit">
                                <option value="Передний">Передний</option>
                                <option value="Задний">Задний</option>
                                <option value="Полный">Полный</option>
                            </select>
                            <label>Выберете привод</label>
                        </div>
                    </div>
                    <div class="row">Показать только с фото</div>

                    <div class="row">
                        <div class="switch ">
                            <label>
                                нет
                                <input type="checkbox" name="withPhoto" checked>
                                <span class="lever"></span>
                                да
                            </label>
                        </div>
                        <c:if test="">
                        </c:if>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <button class="btn waves-effect waves-light" type="submit" name="action"
                            >Найти
                                <i class="material-icons right">send</i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <c:forEach items="${posts}" var="post">
            <div class="col s3">
                <a href='<c:url value="/post?id=${post.id}"/>'>
                    <div class="card">
                        <div class="card-image">
                            <img src="<c:url  value='/download?id=${post.id}'/>"
                                 height="200px"/>
                        </div>
                        <c:if test="${post.sale}">
                            <div class="card-content" style="background-color: cornsilk">
                                <p style="">Продано</p>
                            </div>
                        </c:if>
                        <c:if test="${!post.sale}">
                            <div class="card-content">
                                <p>
                                    <c:out value="${post.model.brand.name}"/>
                                    <c:out value="${post.model.name}"/>
                                    (<c:out value="${post.productionYear}"/>)
                                    <br>
                                    <c:out value="${post.price}"/> р
                                </p>
                            </div>
                        </c:if>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="js/filter.js"></script>
<script>
    $(document).ready(function () {
        $('select').formSelect();
        loadBrands();
        loadTransmissions();
        loadCarBodies();
    });
</script>
</body>
</html>
