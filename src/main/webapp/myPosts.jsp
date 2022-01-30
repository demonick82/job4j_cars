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
    <title>Мои объявления</title>
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
                    <li>Приветствуем <c:out value="${user.name}"/></li>
                    <li><a href="<%=request.getContextPath()%>/index">Главная</a></li>
                    <li><a href="<%=request.getContextPath()%>/createPost">Добавить объявление</a></li>
                    <li><a href="<%=request.getContextPath()%>/logout">Выйти</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <h3 class="center-align">
            Мои объявления
        </h3>
    </div>
    <div class="row">
        <c:forEach items="${posts}" var="post">
            <div class="col s6">
                <div class="card">
                    <div class="card-image">
                        <img src="<c:url  value='/download?id=${post.id}'/>"
                             height="400"/>
                    </div>
                    <div class="card-content">
                        <div class="row ">
                            <c:if test="${post.sale}">
                                <div class="card-content">
                                    <h6>Продано</h6>
                                </div>
                            </c:if>
                            <c:if test="${!post.sale}">
                                <h6>
                                    <c:out value="${post.model.brand.name}"/>
                                    <c:out value="${post.model.name}"/>
                                    (<c:out value="${post.productionYear}"/>)
                                    <c:out value="${post.price}"/>
                                </h6>
                            </c:if>

                        </div>
                        <div class="row ">
                            <a href="<c:url value="/uploadPhoto.jsp?id=${post.id}"/>">
                                <button class="btn waves-effect waves-light" type="button">Добавить фото
                                </button>
                            </a>
                            <a href="<c:url value="/editPost?id=${post.id}"/>">
                                <button class="btn waves-effect waves-light" type="submit" name="action">редактировать
                                </button>
                            </a>
                            <a href="<c:url value="/deletePost?id=${post.id}"/>">
                                <button class="btn waves-effect waves-light" type="button" name="action">
                                    удалить
                                </button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script>
    $(document).ready(function () {
        $('select').formSelect();
    });
</script>
</body>
</html>
