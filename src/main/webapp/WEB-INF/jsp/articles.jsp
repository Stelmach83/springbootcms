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
    <title>Articles</title>
</head>
<body>


<jsp:include page="/WEB-INF/jsp/header/header.jsp"/>

<div class="container">

    <div class="content">

        <%--CATEGORY TITLE--%>
        <c:if test="${not empty category}">
            <c:set var="thiscat" value="${category.getName()}"/>
            <h4>${fn:toUpperCase(thiscat)}</h4>
        </c:if>

        <%--MAIN TITLE--%>
        <c:if test="${empty category}">
            <h4>MOST RECENT</h4>
        </c:if>

        <br>

        <c:forEach var="a" items="${articles}">
            <h4>${a.getTitle()}</h4>
            <h5>By ${a.getAuthor().getFirstName()} ${a.getAuthor().getLastName()}, added: ${a.getCreated()}</h5>
            <p>${a.getContent()} <a href="<%=request.getContextPath()%>/article/${a.getId()}">więcej</a></p>
            <hr>
        </c:forEach>

    </div>

</div>

</body>
</html>
