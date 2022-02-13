<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<h1>Lista de locais</h1>
<br/>
<br/>

<table class="table table-bordered table-striped">
    <thead>
    <tr>
        <th class="text-center col-md-2">Id</th>
        <th class="text-center col-md-2">Nome</th>
        <th class="text-center col-md-2">Código</th>
        <th class="text-center col-md-2">Bairro</th>
        <th class="text-center col-md-2">Cidade</th>
        <th class="text-center col-md-2"></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${places}" var="place">
        <tr>
            <td class="text-center">${place.id} </td>
            <td class="text-center">${place.name} </td>
            <td class="text-center">${place.code}</td>
            <td class="text-center">${place.neighborhood}</td>
            <td class="text-center">${place.city}</td>
            <td class="text-center"><a class="btn btn-link aw-link-panel" href="/update/local/form/${place.code}">Editar</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>