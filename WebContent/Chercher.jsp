<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${empty sessionScope.nom}">
        <c:redirect url="index.jsp"/>
    </c:when>
</c:choose>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Recherche Produit</title>
</head>
<body>
    <h2>Rechercher un produit</h2>

    <form action="Traitement" method="GET">
        <label for="id">ID du produit :</label>
        <input type="text" id="id" name="id" required>
        <br><br>
        <label for="quantite">Quantité à acheter :</label>
        <input type="number" id="quantite" name="quantite" min="1" required>
        <br><br>
        <button type="submit">Rechercher</button>
    </form>

   

    <!-- Affichage des erreurs -->
    <c:if test="${param.error == 1}">
        <p style="color:red;">Erreur : Veuillez remplir tous les champs.</p>
    </c:if>
    <c:if test="${param.error == 3}">
        <p style="color:red;">Erreur : Format incorrect.</p>
    </c:if>
    <c:if test="${param.error == 4}">
        <p style="color:red;">Erreur : Problème de connexion à la base.</p>
    </c:if>
</body>
</html>
