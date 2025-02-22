<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
</head>
<body>

<!-- Vérification de la session et si l'utilisateur est connecté -->
<c:if test="${empty sessionScope.nom}">
    <c:redirect url="index.jsp"/>
</c:if>

<h2>Bienvenue, <c:out value="${sessionScope.nom}" /> !</h2>

<a href="Ajout.jsp">Ajout</a>
<a href="Chercher.jsp">Chercher</a>
<a href="Déconnexion">Déconnexion</a>
<a href="Affichage">Affichage</a>

<c:set var="result" value="${param.result}" />

<c:if test="${result == 'true'}">
    <p>Result correct!!!!!</p>
</c:if>
<c:if test="${result == 'false'}">
    <p>Result not correct!!!!!</p>
</c:if>

<!-- Formulaire de déconnexion
<form action="Déconnexion" method="GET">
    <button type="submit">Déconnexion</button>
</form> -->


</body>
</html>
