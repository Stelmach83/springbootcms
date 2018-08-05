<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/@coreui/coreui/dist/js/coreui.min.js"></script>
    <title>Categories</title>
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

        .error {
            color: red;
        }
    </style>
</head>
<body class="app">
<jsp:include page="/WEB-INF/jsp/header/header.jsp"/>
<div class="app-body">
    <div class="container">
        <main class="main">

            <h4>CATEGORIES</h4>
            <br>

            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Category</th>
                    <th scope="col">Description</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cat" items="${categories}">
                    <tr>
                        <th scope="row">${cat.getId()}</th>
                        <td>${cat.getName()}</td>
                        <td>${cat.getDescription()}</td>
                        <td><a href="<%=request.getContextPath()%>/editcat/${cat.getId()}">edit</a></td>
                        <td><a href="<%=request.getContextPath()%>/delcat/${cat.getId()}">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <a href="<%=request.getContextPath()%>/addcat">
                <button type="button" class="btn btn-primary btn-sm">add</button>
            </a>
            <c:if test="${not empty editcat}">
                <br><br>
                <h5>Edit ${category.getName()}</h5>
                <form:form method="post" modelAttribute="category">
                    <form>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Name</label>
                            <form:input type="text" class="form-control" id="exampleFormControlInput1"
                                        placeholder="${category.getName()}" path="name"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput2">Description</label>
                            <form:input type="text" class="form-control" id="exampleFormControlInput2"
                                        placeholder="${category.getDescription()}" path="description"/>
                            <form:errors path="description" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput4">Aricles</label>
                            <form:select items="${articles}" itemValue="id" multiple="true" itemLabel="title" class="form-control" id="exampleFormControlInput4" path="articles"/>
                            <form:errors path="articles" cssClass="error"/>
                        </div>
                        <input type="submit" value="Save">
                    </form>
                </form:form>
            </c:if>

            <c:if test="${not empty addcat}">
                <br><br>
                <h5>Add category</h5>
                <form:form method="post" modelAttribute="category">
                    <form>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Name</label>
                            <form:input type="text" class="form-control" id="exampleFormControlInput1"
                                        placeholder="${category.getName()}" path="name"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput2">Description</label>
                            <form:input type="text" class="form-control" id="exampleFormControlInput2"
                                        placeholder="${category.getDescription()}" path="description"/>
                            <form:errors path="description" cssClass="error"/>
                        </div>
                            <%--<div class="form-group">--%>
                            <%--<label for="exampleFormControlInput4">Aricles</label>--%>
                            <%--<form:select items="${articles}" itemValue="id" multiple="true" itemLabel="title" class="form-control" id="exampleFormControlInput4" path="articles"/>--%>
                            <%--<form:errors path="articles" cssClass="error"/>--%>
                            <%--</div>--%>
                        <input type="submit" value="Save">
                    </form>
                </form:form>
            </c:if>
        </main>
    </div>
</div>
</body>
</html>
