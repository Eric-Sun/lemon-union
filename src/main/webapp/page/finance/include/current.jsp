<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <ul class="breadcrumb">
        <li<%if ("0".equals(request.getParameter("current"))) {%> class="active" <%}%>><a
                href="/page/finance/adownerbill/list.jsp">广告主结算收入表</a>
            <span class="divider">/</span></li>
        <li<%if ("1".equals(request.getParameter("current"))) {%> class="active" <%}%>><a
                href="/page/finance/webownerperiodbill/list.jsp">站长收入周期查询表</a>
            <span class="divider">/</span></li>
        <li<%if ("2".equals(request.getParameter("current"))) {%> class="active" <%}%>><a
                href="/finance/bill/query">日报表</a>
            <span class="divider">/</span></li>
        <li<%if ("3".equals(request.getParameter("current"))) {%> class="active" <%}%>><a
                href="/finance/webownerbill/query">站长收入结算</a>
            <span class="divider">/</span></li>
    </ul>
</div>