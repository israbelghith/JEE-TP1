<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Recherche Produit</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty sessionScope.nomP}">
            <h4>Produit trouvé</h4>
            <h6>Nom du produit : ${sessionScope.nomP}</h6>
            <h6>Quantité disponible : ${sessionScope.qte}</h6>
        </c:when>
    </c:choose>
</body>
</html>
