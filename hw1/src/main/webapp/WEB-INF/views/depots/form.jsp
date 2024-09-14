<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<%--@elvariable id="depot" type=""--%>
<form:form action="/addDepot" modelAttribute="depot">
    <form:label path="id">ID:</form:label>
    <form:input path="id"/>
    <form:errors path="id"/>
    <form:label path="location">Location:</form:label>
    <form:input path="location"/>
    <form:errors path="location"/>
    <form:label path="owner">Owner:</form:label>
    <form:input path="owner"/>
    <form:errors path="owner"/>
    <input type="submit"/>
</form:form>
</body>
</html>