<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Cadastrar lugares</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css"/>
</head>

<body>
<nav class="navbar navbar-inverse navbar-static-top"></nav>

<form:form class="form-horizontal" modelAttribute="placeEditForm" method="post" action="/update/local/${code}">

    <div class="panel-body">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="name">Nome:</label>
            <div class="col-sm-5">
                <form:input class="form-control" type="text" path="name" id="name" placeholder="Nome" maxlength="100"
                            value="${placeEditView.name}"/>
                <form:errors path="name" cssStyle="color: red"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label" for="code">Código:</label>
            <div class="col-sm-5">
                <form:input type="text" class="form-control" path="code" id="code" placeholder="Código"
                            value="${placeEditView.code}"/>
                <form:errors path="code" cssStyle="color: red"/>
            </div>
        </div>

        <div class="form-group">
            <label for="neighborhood" class="col-sm-2 control-label">Bairro:</label>
            <div class="col-sm-5">
                <form:input type="text" class="form-control" path="neighborhood" id="neighborhood" placeholder="Bairro"
                            maxlength="100" value="${placeEditView.neighborhood}"/>
                <form:errors path="neighborhood" cssStyle="color: red"/>
            </div>
        </div>

        <div class="form-group">
            <label for="city" class="col-sm-2 control-label">Cidade:</label>
            <div class="col-sm-5">
                <form:input type="text" class="form-control" path="city" id="city" placeholder="Cidade" maxlength="100"
                            value="${placeEditView.city}"/>
                <form:errors path="city" cssStyle="color: red"/>
            </div>
        </div>

        <form:input type="hidden" name="id" path="id" value="${placeEditView.id}"/>

        <div class="col-sm-offset-7 col-sm-10">
            <form:button class="btn btn-success">Cadastrar</form:button>
        </div>
    </div>

</form:form>
</body>
</html>
<script src="/js/bootstrap.min.js"></script>