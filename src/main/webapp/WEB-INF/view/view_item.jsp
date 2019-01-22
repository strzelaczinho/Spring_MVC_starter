<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="adam.projekty.util.Mappings" %>

<html>
<head>
    <title>View Items</title>
</head>
<body>
    <div align="center">
        <table>
            <tr>
                <td><label>ID</label></td>
                <td>
                    <c:out value="${todoItem.id}" /> <!-- todoItem to jest nazwa atrybutu z kontrolera -->
                </td>
            </tr>
            <tr>
               <td><label>Tytuł</label></td>
                <td><c:out value="${todoItem.title}" /></td>
            </tr>
            <tr>
                <td><label>Details</label></td>
                <td><c:out value="${todoItem.details}" /></td>
            </tr>
            <tr>
                <td><label>Deadline</label></td>
                <td><c:out value="${todoItem.deadline}" /></td>

            </tr>

        </table>
            <c:url var="tableUrl" value="${Mappings.ITEMS}"/>
            <a href="${tableUrl}">Show table</a>
    </br>
        <a href="items">Show table2</a>
        
    </div>

</body>
</html>