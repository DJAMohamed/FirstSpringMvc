<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="org.eclipse.FirstSpringMvc.model.Personne"%>
<html>
<head>
<title>Result page</title>
</head>
<body>
	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" method="post">
		<input type="submit" value="Deconnection" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<%
	List<Personne> al = (List<Personne>) request.getAttribute("tab");
	for (Personne p : al) {
		out.print("<br> " + p.getNom() + " " + p.getPrenom());
	}
	%>
</body>
</html>