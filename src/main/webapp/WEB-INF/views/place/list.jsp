<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Lista de lugares</title>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css"/>
    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-static-top"></nav>

        <div class="col-sm-offset--1 col-sm-10">
            <h1>Lista de lugares</h1>
            <a class="btn btn-primary" href="/create/local/form">Novo lugar</a><br/><br/><br/>
        </div>
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th class="text-center col-md-2">Id</th>
                    <th class="text-center col-md-2">Nome</th>
                    <th class="text-center col-md-2">Código</th>
                    <th class="text-center col-md-2">Data criação</th>
                    <th class="text-center col-md-2">Dias desde a última atualização</th>
                    <th class="text-center col-md-2"></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${places}" var="place">
                    <tr>
                        <td class="text-center">${place.id()} </td>
                        <td class="text-center">${place.name()} </td>
                        <td class="text-center">${place.code()}</td>
                        <td class="text-center">${place.createdAt()}</td>
                        <td class="text-center">${place.updatedAt()}</td>
                        <td class="text-center"><a class="btn btn-link aw-link-panel" href="/update/local/form/${place.code()}">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
<script src="/js/bootstrap.min.js"></script>