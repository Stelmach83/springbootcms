<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/@coreui/coreui/dist/js/coreui.min.js"></script>
    <title>Article</title>
</head>
<body>

<div class="container">

    <h4>
        <c:forEach var="cat" items="${categories}">
            <c:set var="name" value="${cat.getName()}"/>
            <a href="<%=request.getContextPath()%>/articles/${cat.getName()}"
               style="padding-right: 1em">${fn:toUpperCase(name)}</a>
        </c:forEach>
    </h4>
    <br>
    <p>${artic.toString()}</p>
    <hr>
    <a href="#" onClick="history.go(-1);return true;">Go back</a>

</div>

</body>
</html>
