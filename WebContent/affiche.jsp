<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Liste Produit
<ul>
<c:forEach var="prod" items="${requestScope.liste}">
<li>id du prod est :<c:out value="${prod.id}"/> nom est : ${prod.nom}, la qte est :${prod.quantite}</li>
</c:forEach>
</ul>
</body>
</html>