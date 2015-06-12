<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adelin
  Date: 15-6-11
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <title></title>
</head>
<body>
<div class="row">

    <div class="col-md-2" style="margin-top: 20px">


    </div>

    <div class="col-md-8">
        <div>
            <form action="crawl" method="get">
                <div class="form-group">
                    <label>URL: </label>
                    <input class="form-control" placeholder="Enter Website URL: " name="url">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>


        <div>
            <label>Top Level Page</label>
            <table class="table table-striped">

                <thead>
                <tr>
                    <th>Page url</th>
                    <th>Text length</th>
                    <th>Html length</th>
                    <th>Number of pages links</th>

                    <th>page links</th>
                </tr>

              </thead>
                <c:forEach items="${topLevel}" var="page">
                    <tr>
                        <td><c:out value="${page.url}"/></td>
                        <td><c:out value="${page.textLength}"/></td>
                        <td><c:out value="${page.htmlLength}"/></td>
                        <td><c:out value="${page.links.size()}"/></td>

                        <td>
                         <ul>
                             <c:if test="${not empty page.links}">
                                 <c:forEach var="link" items="${page.links}">
                                     <li>
                                         <c:out value="${link}"/>
                                     </li>
                                 </c:forEach>
                             </c:if>
                         </ul>

                     </td>
                    </tr>
                </c:forEach>
            </table>
        </div>



        <div>
        <label>All domain</label>
        <table class="table table-striped">

            <thead>
            <tr>
                <th>Page url</th>
                <th>Text length</th>
                <th>Html length</th>
                <th>Number of pages links</th>

                <th>page links</th>
            </tr>

            </thead>
            <c:forEach items="${allDomain}" var="page">
                <tr>
                    <td><c:out value="${page.url}"/></td>
                    <td><c:out value="${page.textLength}"/></td>
                    <td><c:out value="${page.htmlLength}"/></td>
                    <td><c:out value="${page.links.size()}"/></td>

                    <td>
                        <ul>
                            <c:if test="${not empty page.links}">
                                <c:forEach var="link" items="${page.links}">
                                    <li>
                                        <c:out value="${link}"/>
                                    </li>
                                </c:forEach>
                            </c:if>
                        </ul>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </div>


    <div class="col-md-2">

    </div>
    <%--<c:if test="${not empty topLevel}">--%>

    <%--</c:if>--%>

</div>


</body>
</html>
