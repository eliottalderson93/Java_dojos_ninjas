<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make a Ninja</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/app.js"></script>
</head>

<body>
<h1>New Ninja</h1>
<form:form action = "/ninjas/new" method = "post" modelAttribute = "ninja">
	<form:label path = "dojo">Dojo: </form:label>
	<form:select path = "dojo">
	   <c:forEach items = "${allDojos}" var = "dojo">
	   		<form:option value = "${dojo.id}" label = "${dojo.name}"/>
	   </c:forEach>
	</form:select>
	<p>
	<form:label path = "firstName">First Name: </form:label>
	<form:errors path = "firstName"/>
	<form:input path = "firstName"/>
	</p>
	<p>
	<form:label path = "lastName"> Last Name: </form:label>
	<form:errors path = "lastName"/>
	<form:input path = "lastName"/>
	</p>
	<p>
	<form:label path = "age"> Age: </form:label>
	<form:errors path = "age"/>
	<form:input path = "age" type = "number"/>
	</p>
	<button type = "submit">Create</button>
</form:form>	
</body>
</html>