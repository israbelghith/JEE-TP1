<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
</head>
<body>
    <h2>Connexion</h2>
    
    <!-- Redirection si l'utilisateur est déjà connecté -->
    <c:choose>
        <c:when test="${not empty sessionScope.nom}">
            <c:redirect url="menu.jsp"/>
        </c:when>
        <c:otherwise>
            <form action="Connexion" method="GET">
                <label for="nom">Nom d'utilisateur :</label>
                <input type="text" id="login" name="login" required>
                <br>
                <label for="password">Mot de passe :</label>
                <input type="password" id="password" name="password" required>
                <br><br>
                <button type="submit">Se connecter</button>
            </form>
        </c:otherwise>
    </c:choose>
</body>
</html>
