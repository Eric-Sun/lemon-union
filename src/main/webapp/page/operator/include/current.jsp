<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <ul class="breadcrumb">
        <li<%if ("0".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/page/operator/provinceincome/list.jsp">省份收入分析表</a>
            <span class="divider">/</span></li>
        <li<%if ("1".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/operator/deduct/list">利润点管理</a>
            <span class="divider">/</span></li>
        <li<%if ("2".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/page/operator/productrealtime/list.jsp">产品实时数据</a>
            <span class="divider">/</span></li>
        <li<%if ("3".equals(request.getParameter("current"))) {%> class="active" <%}%>><a href="/page/operator/realtime/list.jsp">实时数据</a>
            <span class="divider">/</span></li>
    </ul>
</div>