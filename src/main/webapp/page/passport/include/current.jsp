<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <ul class="breadcrumb">
        <li<%if ("0".equals(request.getParameter("current"))) {%> class="active" <%}%>><a data-toggle="modal"
                                                                                          href="#showModal" onclick="form_add();">添加内容源</a>
            <span class="divider">/</span></li>
        <li<%if ("1".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/source/list">内容源列表</a>
            <span class="divider">/</span></li>
        <li<%if ("2".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/source/articles">内容源文章列表</a>
            <span class="divider">/</span></li>
        <li<%if ("3".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/source/html">添加html内容源</a>
        </li>
    </ul>
</div>