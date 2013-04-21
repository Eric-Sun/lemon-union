<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>添加新的用户</title>
    <jsp:include page="/page/common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="/page/common/top.jsp">
            <jsp:param name="top" value="1"/>
        </jsp:include>
        <jsp:include page="/page/content/include/current.jsp">
            <jsp:param name="current" value="2"/>
        </jsp:include>
    </div>
    <form name="userForm" method="post" action="/auth/user/create" id="userForm">
        <fieldset>
            <div class="control-group">
                <label class="control-label">用户名</label>

                <div class="controls">
                    <input type="text" name="name" value="${user.name}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">密码</label>

                <div class="controls">
                    <input type="text" name="pwd" value="${user.pwd}">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">权限名称</label>


                <c:forEach items="${roleList}" var="role">
                    <div class="controls">
                        <input type="radio" name="roleId" value="${role.id}">${role.name}</input>
                    </div>
                </c:forEach>
            </div>
            <div class="control-group">
                <div class="controls">
                    <input type="submit" class="btn btn-primary" value="提交"/>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
<script>
</script>
</html>
