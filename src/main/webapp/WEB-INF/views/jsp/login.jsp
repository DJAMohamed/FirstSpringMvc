<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<div>
			<input type="text" name="username" placeholder="Login" />
		</div>
		<div>
			<input type="password" name="password" placeholder="Password" />
		</div>
		<div>
			<input type="submit" value="Connection" />
		</div>
		<c:if test="${param.error ne null}">
			<div>Invalid username and password.</div>
		</c:if>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.
token}" />
	</form>
</body>
</html>