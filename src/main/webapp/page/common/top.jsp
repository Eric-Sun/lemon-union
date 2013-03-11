<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Reader CMS</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li<%if ("0".equals(request.getParameter("top"))) {%> class="active"<%}%>><a href="/auth/user/list">用户管理</a>
                    </li>
                    <li<%if ("1".equals(request.getParameter("top"))) {%> class="active"<%}%>><a
                            href="/content/adcode/list">内容管理</a>
                    </li>
                    <li<%if ("2".equals(request.getParameter("top"))) {%> class="active"<%}%>><a
                            href="/page/operator/provinceincome/list.jsp">运营管理</a>
                    </li>
                    <shiro:hasRole name="sss">
                        <li<%if ("3".equals(request.getParameter("top"))) {%> class="active"<%}%>><a
                                href="/page/finance/adownerbill/list.jsp">财务管理</a>
                        </li>
                    </shiro:hasRole>
                </ul>
                <ul class="nav pull-right">
                    <li><a href="#">${sessionScope.name}</a></li>
                    <li><a href="/admin/logout">登出</a></li>
                    <li class="divider-vertical"></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">设置<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.nav-collapse -->
        </div>
    </div>
    <!-- /navbar-inner -->
</div>
