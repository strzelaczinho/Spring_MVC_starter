<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="adam.projekty.util.Mappings" %>
<html>
<head>
    <title>APLIKACJA LISTA START</title>
</head>
<body>
    <div align="center">
        <c:url var="itemsLink" value="${Mappings.ITEMS}"/> <!-- var reprezentuje zmienna ktora trzyma sformatowana url aa value to base url-->
        <h2><a href="${itemsLink}">Pokaz itemy Listy</a></h2>
    </div>

</body>
</html>