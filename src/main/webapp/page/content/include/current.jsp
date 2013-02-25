<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <ul class="breadcrumb">
         <li<%if ("0".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/content/catalog/list">分类管理</a>
            <span class="divider">/</span></li>
        <li<%if ("1".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/content/new/list">新闻内容管理</a>
            <span class="divider">/</span></li>
        <li<%if ("2".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/content/adowner/list">广告主管理</a>
    </ul>
</div>