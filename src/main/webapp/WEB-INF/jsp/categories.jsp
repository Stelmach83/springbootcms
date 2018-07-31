<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/@coreui/coreui/dist/js/coreui.min.js"></script>
    <title>Categories</title>
</head>
<body>


<jsp:include page="/WEB-INF/jsp/header/header.jsp"/>
<div class="container">
    <div class="content">

        <h4>CATEGORIES</h4>
        <br>

        <table class="table">
            <thead>
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
                    <c:set var="name" value="${cat.getName()}"/>
                    <th scope="row">${cat.getId()}</th>
                    <td>${cat.getName()}</td>
                    <td>${cat.getDescription()}</td>
                    <td><a href="<%=request.getContextPath()%>/editcat/${cat.getName()}">edit</a></td>
                    <td><a href="<%=request.getContextPath()%>/categories/${cat.getName()}">delete</a></td>
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
            <h5>Edit ${editcat.getName()}</h5>
            <form:form method="post" modelAttribute="editcat">
                <form>
                    <form:input type="hidden" class="form-control" id="exampleFormControlInput0"
                                value="${editcat.getId()}" path="id"/>
                    <div class="form-group">
                        <label for="exampleFormControlInput1">Name</label>
                        <form:input type="text" class="form-control" id="exampleFormControlInput1"
                                    placeholder="${editcat.getName()}" path="name"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlInput2">Description</label>
                        <form:input type="text" class="form-control" id="exampleFormControlInput2"
                                    placeholder="${editcat.getDescription()}" path="description"/>
                    </div>
                    <input type="submit" value="Save">
                </form>
            </form:form>
        </c:if>

        <c:if test="${not empty addcat}">
            <br><br>
            <h5>Add category</h5>
            <form:form method="post" modelAttribute="addcat">
                <form>
                    <div class="form-group">
                        <label for="exampleFormControlInput3">Name</label>
                        <form:input type="text" class="form-control" id="exampleFormControlInput3"
                                    placeholder="name" path="name"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlInput4">Description</label>
                        <form:input type="text" class="form-control" id="exampleFormControlInput4"
                                    placeholder="description" path="description"/>
                    </div>
                    <input type="submit" value="Save">
                </form>
            </form:form>
        </c:if>


    </div>
</div>

</body>
</html>
