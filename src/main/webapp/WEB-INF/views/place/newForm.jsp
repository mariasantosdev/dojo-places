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

        <form:form class="form-horizontal" modelAttribute="placeNewForm" method="post" action="/create/local">

            <div class="panel-body">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome:</label>
                    <div class="col-sm-5">
                        <form:input path="name" class="form-control"/>
                        <form:errors path="name" cssStyle="color: red"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Código:</label>
                    <div class="col-sm-5">
                        <form:input path="code" class="form-control"/>
                        <form:errors path="code" cssStyle="color: red"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Bairro:</label>
                    <div class="col-sm-5">
                        <form:input path="neighborhood" class="form-control"/>
                        <form:errors path="neighborhood" cssStyle="color: red"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Cidade:</label>
                    <div class="col-sm-5">
                        <form:input path="city" class="form-control"/>
                        <form:errors path="city" cssStyle="color: red"/>
                    </div>
                </div>

                <div class="col-sm-offset-7 col-sm-10">
                    <form:button class="btn btn-success">Cadastrar</form:button>
                </div>
            </div>

        </form:form>
    </body>
</html>

<script src="/js/bootstrap.min.js"></script>