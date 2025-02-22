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
    <title>Ajout de Produit</title>
</head>
<body>
    <h2>Ajouter un produit</h2>
    
    <form action="Traitement" method="POST">
        <label for="id">ID du produit :</label>
        <input type="text" id="id" name="id" required>
        <br><br>
        <label for="nom">Nom du produit :</label>
        <input type="text" id="nom" name="nom" required>
        <br><br>
        <label for="quantite">Quantité :</label>
        <input type="number" id="quantite" name="quantite" min="1" required>
        <br><br>
        <button type="submit">Ajouter</button>
    </form>

    <!-- Affichage des erreurs -->
    <c:if test="${param.error == 1}">
        <p style="color:red;">Erreur : Tous les champs sont obligatoires.</p>
    </c:if>
    <c:if test="${param.error == 2}">
        <p style="color:red;">Erreur : Impossible d'ajouter le produit.</p>
    </c:if>
</body>
</html>
