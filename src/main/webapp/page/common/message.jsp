<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${!empty message}">
    <c:choose>
        <c:when test="${message eq 1}">
            <div class="alert fade in alert-success">
                <button class="close" data-dismiss="alert">×</button>
                <strong>操作成功！</strong>
            </div>
        </c:when>
        <c:otherwise>
            <div class="alert fade in alert-error">
                <button class="close" data-dismiss="alert">×</button>
                <strong>操作失败！</strong>
            </div>
        </c:otherwise>
    </c:choose>
</c:if>
