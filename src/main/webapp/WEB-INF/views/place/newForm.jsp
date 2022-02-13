<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Cadastro de locais</h1>
<br/>
<br/>

<form:form modelAttribute="placeNewForm" method="post" action="/create/local">

    <label>Nome:</label>
    <form:input path="name"/>
    <form:errors path="name" cssStyle="color: red"/>

    <label>Código:</label>
    <form:input path="code"/>
    <form:errors path="code" cssStyle="color: red"/>

    <label>Bairro:</label>
    <form:input path="neighborhood"/>
    <form:errors path="neighborhood" cssStyle="color: red"/>

    <label>Cidade:</label>
    <form:input path="city"/>
    <form:errors path="city" cssStyle="color: red"/>

    <br/>
    <br/>

    <form:button>Cadastrar</form:button>

</form:form>

<script src="/assets/js/locais/buscarLocal.js"></script>