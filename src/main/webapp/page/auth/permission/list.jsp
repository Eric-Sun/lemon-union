<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>内容源文章列表</title>
    <jsp:include page="../../common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="../../common/top.jsp">
            <jsp:param name="top" value="2"/>
        </jsp:include>
        <jsp:include page="../include/current.jsp">
            <jsp:param name="top" value="2"/>
        </jsp:include>
    </div>
    <div class="body">
        <div>
                <table class="table table-bordered table-condensed">
                    <thead>
                    <tr>
                        <td>id</td>
                        <td>用户名</td>
                         <td>路径</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="permission" items="${permissionList}">
                            <td>${permission.id}</td>
                            <td>${permission.name}</td>
                            <td>${permission.url}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    <jsp:include page="../../common/message.jsp"/>
</div>
</body>
</html>
