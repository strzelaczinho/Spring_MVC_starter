<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="adam.projekty.util.AttributeNames" %>

<html>
<head>
    <title>Add Items</title>
</head>
<body>
    <div align="center">
        <form:form method="POST" modelAttribute="${AttributeNames.TODO_ITEM}"> <!-- Model attribute to Name of the model attribute under which the form object is exposed.-->
            <table>
                    <tr>
                        <td><label>ID</label></td>
                        <td>
                            <form:input path="id" disabled="true" /> <!--path property musi odzwierciedlac nazwe zmiennej w klasie do ktorej sie odwolujemy w modelu -->
                        </td>
                    </tr>
                    <tr>
                        <td><label>Title</label></td>
                        <td><form:input path="title"/></td>
                    </tr>
                    <tr>
                        <td><label>Deadline</label></td>
                        <td><form:input path="deadline"/></td>
                    </tr>
                    <tr>
                        <td><label>Details</label></td>
                        <td><form:textarea path="details"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit"/></td>
                    </tr>
                </table>

        </form:form>
    </div>

</body>
</html>