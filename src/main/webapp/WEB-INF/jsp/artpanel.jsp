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

            <c:if test="${not empty editart}">
                <br><br>
                <h5>Edit article</h5>
                <form:form method="post" modelAttribute="editart">
                    <form>
                        <form:input type="hidden" class="form-control" id="exampleFormControlInput0"
                                    value="${editart.getId()}" path="id"/>

                        <form:input type="hidden" class="form-control" id="exampleFormControlInputDate"
                                    path="created" name="created" value="${editart.getCreated().toString()}"/>

                        <div class="form-group">
                            <label for="exampleFormControlInput1">Title</label>
                            <form:input type="text" class="form-control" id="exampleFormControlInput1"
                                        placeholder="${editart.getTitle()}" path="title"/>
                        </div>

                        <div class="form-group">
                            <label for="exampleFormControlInput2">Content</label>
                            <form:textarea class="form-control" rows="4" id="exampleFormControlInput2"
                                           placeholder="${editart.getContent()}" path="content"/>
                        </div>

                        <div class="form-group">
                            <label for="exampleFormControlInput3">Author</label>
                            <form:select items="${authors}" itemValue="id" itemLabel="fullName" class="form-control" id="exampleFormControlInput3" path="author.id"/>
                        </div>

                        <div class="form-group">
                            <label for="exampleFormControlInput4">Categories</label>
                            <form:select items="${categories}" itemValue="id" multiple="true" itemLabel="name" class="form-control" id="exampleFormControlInput4" path="categories"/>
                        </div>

                        <input type="submit" value="Save">
                    </form>
                </form:form>
            </c:if>

            <c:if test="${not empty addart}">
                <br><br>
                <h5>Add article</h5>
                <form:form method="post" modelAttribute="addart">
                    <form>

                        <div class="form-group">
                            <label for="exampleFormControlInput1">Title</label>
                            <form:input type="text" class="form-control" id="exampleFormControlInput1"
                                        placeholder="${addart.getTitle()}" path="title"/>
                        </div>

                        <div class="form-group">
                            <label for="exampleFormControlInput2">Content</label>
                            <form:textarea class="form-control" rows="4" id="exampleFormControlInput2"
                                           placeholder="${addart.getContent()}" path="content"/>
                        </div>

                        <div class="form-group">
                            <label for="exampleFormControlInput3">Author</label>
                            <form:select items="${authors}" itemValue="id" itemLabel="fullName" class="form-control" id="exampleFormControlInput3" path="author.id"/>
                        </div>

                        <div class="form-group">
                            <label for="exampleFormControlInput4">Categories</label>
                            <form:select items="${categories}" itemValue="id" multiple="true" itemLabel="name" class="form-control" id="exampleFormControlInput4" path="categories"/>
                        </div>

                        <input type="submit" value="Save">
                    </form>
                </form:form>
            </c:if>

            <div class="table">
                <div class="row">
                    <div class="col-6">
                        <h4 style="float: left">ARTICLES</h4>
                    </div>
                    <div class="col-6">
                        <a href="<%=request.getContextPath()%>/addart" style="float: right">
                            <button type="button" class="btn btn-primary btn-sm">add article</button>
                        </a>
                    </div>
                </div>
                <br>
            </div>

            <c:forEach var="art" items="${articles}">
                <c:set var="cats" value="${art.getCategories()}"/>
                <div class="card">
                    <h4 class="card-header">${art.getTitle()}</h4>
                    <div class="card-body">
                        <p class="card-text">${art.getContent()}</p>
                        <p>categories:
                            <c:forEach var="cat" items="${cats}">
                                ${cat.getName()}
                            </c:forEach>
                        </p>
                        <footer class="blockquote-footer">
                            by <cite title="Source Title">${art.getAuthor().getFirstName()} ${art.getAuthor().getLastName()}, created: ${art.getCreated().toString()}, updated: ${art.getUpdated().toString()}, #${art.getId()}</cite>
                        </footer>
                        <div style="float: right">
                            <a href="<%=request.getContextPath()%>/editart/${art.getId()}" class="btn btn-primary btn-sm">edit</a> <a href="<%=request.getContextPath()%>/deleteart/${art.getId()}" class="btn btn-primary btn-sm">delete</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <br>


        </main>
    </div>
</div>
</body>
</html>
