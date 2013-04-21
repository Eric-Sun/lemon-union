<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>新权限</title>
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
    <form name="roleForm" method="post" action="/auth/role/update" id="roleForm">
        <fieldset>
            <input type="hidden" name="id" value="${roleVO.id}" />

            <div class="control-group">
                <label class="control-label">名称</label>

                <div class="controls">
                    <input type="text" name="name" value=${roleVO.name}>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">选择的权限</label>

                <c:forEach items="${roleVO.permissionList}" var="item">
                    <div class="controls">
                        <input type='checkbox' name='permissionIdArray'
                               value='${item.id}'
                                <c:if test="${item.selected==true}">
                                    checked=true
                                </c:if>
                                >${item.desc}</input>
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
