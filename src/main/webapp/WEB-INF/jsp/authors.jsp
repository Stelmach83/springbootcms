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
    <title>Authors</title>
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
            <h4>AUTHORS</h4>
            <br>

            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="auth" items="${authors}">
                    <tr>
                        <th scope="row">${auth.getId()}</th>
                        <td>${auth.getFirstName()}</td>
                        <td>${auth.getLastName()}</td>
                        <td><a href="<%=request.getContextPath()%>/editauth/${auth.getId()}">edit</a></td>
                        <td><a href="<%=request.getContextPath()%>/delauth/${auth.getId()}">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <a href="<%=request.getContextPath()%>/addauth">
                <button type="button" class="btn btn-primary btn-sm">add</button>
            </a>
            <c:if test="${not empty editauth}">
                <br><br>
                <h5>Edit ${author.getFirstName()} ${author.getLastName()}</h5>
                <form:form method="post" modelAttribute="author">
                    <form>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">First Name</label>
                            <form:input type="text" class="form-control" id="exampleFormControlInput1"
                                        placeholder="${author.getFirstName()}" path="firstName"/>
                            <form:errors path="firstName" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput2">Last Name</label>
                            <form:input type="text" class="form-control" id="exampleFormControlInput2"
                                        placeholder="${author.getLastName()}" path="lastName"/>
                            <form:errors path="lastName" cssClass="error"/>

                        </div>
                        <input type="submit" value="Save">
                    </form>
                </form:form>
            </c:if>

            <c:if test="${not empty addauth}">
                <br><br>
                <h5>Add author</h5>
                <form:form method="post" modelAttribute="author">
                    <form>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">First Name</label>
                            <form:input type="text" class="form-control" id="exampleFormControlInput1"
                                        placeholder="${author.getFirstName()}" path="firstName"/>
                            <form:errors path="firstName" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput2">Last Name</label>
                            <form:input type="text" class="form-control" id="exampleFormControlInput2"
                                        placeholder="${author.getLastName()}" path="lastName"/>
                            <form:errors path="lastName" cssClass="error"/>

                        </div>
                        <input type="submit" value="Save">
                    </form>
                </form:form>
            </c:if>
        </main>
    </div>
</div>
</body>
</html>
