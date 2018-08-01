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
    <style>
        html {
            overflow-y: scroll;
        }

        /* width */
        ::-webkit-scrollbar {
            width: 10px;
        }

        /* Track */
        ::-webkit-scrollbar-track {
            background: #f1f1f1;
        }

        /* Handle */
        ::-webkit-scrollbar-thumb {
            background: #34383C;
        }

        /* Handle on hover */
        ::-webkit-scrollbar-thumb:hover {
            background: #555;
        }
    </style>
</head>
<body class="app">


<jsp:include page="/WEB-INF/jsp/header/header.jsp"/>

<div class="app-body">
    <div class="container">
        <main class="main">

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
            <c:forEach var="art" items="${articles}">
                <c:set var="cats" value="${art.getCategories()}"/>
                <div class="card">
                    <h4 class="card-header">${art.getTitle()}</h4>
                    <div class="card-body">
                        <p class="card-text">${art.getContent()} <a href="<%=request.getContextPath()%>/article/${art.getId()}">więcej</a></p>
                        <p>categories:
                            <c:forEach var="cat" items="${cats}">
                                ${cat.getName()}
                            </c:forEach>
                        </p>
                        <footer class="blockquote-footer">
                            by <cite title="Source Title">${art.getAuthor().getFirstName()} ${art.getAuthor().getLastName()}, created: ${art.getCreated().toString()}, updated: ${art.getUpdated().toString()}, #${art.getId()}</cite>
                        </footer>
                    </div>
                </div>
            </c:forEach>
            <br>

        </main>
    </div>
</div>

</body>
</html>
