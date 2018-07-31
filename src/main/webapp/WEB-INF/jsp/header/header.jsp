<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/">Spring CMS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

                <c:forEach var="cat" items="${categories}">
                    <c:set var="name" value="${cat.getName()}"/>
                    <li class="nav-item">
                        <a class="nav-link"
                           href="<%=request.getContextPath()%>/articles/${cat.getName()}">${fn:toUpperCase(name)}</a>
                    </li>
                </c:forEach>
            </ul>
            <ul class="navbar-nav mr-right">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ADMIN
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/categories">Categories Panel</a>
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/authors">Authors Panel</a>
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/artpanel">Articles Panel</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br>



