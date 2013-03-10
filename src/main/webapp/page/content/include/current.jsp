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
            <span class="divider">/</span></li>
        <li<%if ("3".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/content/adcode/list">广告主业务管理</a>
            <span class="divider">/</span></li>
        <li<%if ("4".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/content/product/list">产品管理</a>
            <span class="divider">/</span></li>
        <li<%if ("5".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/content/webowner/list">网站主管理</a>
            <span class="divider">/</span></li>
        <li<%if ("6".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/content/ivrinfo/list">ivr信息管理</a>
    </ul>
</div>