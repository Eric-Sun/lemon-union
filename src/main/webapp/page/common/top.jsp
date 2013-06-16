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
            <a class="brand" href="#">北京柠乐科技有限公司</a>

            <div class="nav pull-left">
                <li class="dropdown">

                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">用户管理</a>
                    <ul class="dropdown-menu">
                        <li><a href="/page/auth/modifyPassword.jsp">修改密码</a></li>
                        <shiro:hasPermission name="/auth/user/list">
                            <li><a href="/auth/user/list">用户操作</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/auth/role/list">
                            <li><a href="/auth/role/list">角色操作</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/auth/permission/list">
                            <li><a href="/auth/permission/list">权限操作</a></li>
                        </shiro:hasPermission>
                    </ul>

                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">内容管理</a>
                    <ul class="dropdown-menu">
                        <shiro:hasPermission name="/content/catalog/list">
                            <li><a href="/content/catalog/list">分类管理</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/content/new/list">
                            <li><a href="/content/new/list">新闻内容管理</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/content/adowner/list">
                            <li><a href="/content/adowner/list">广告主管理</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/content/adcode/list">
                            <li><a href="/content/adcode/list">广告主业务管理</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/content/product/list">
                            <li><a href="/content/product/list">产品管理</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/content/webowner/list">
                            <li><a href="/content/webowner/list">网站主管理</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/content/ivrinfo/list">
                            <li><a href="/content/ivrinfo/list">ivr信息管理</a></li>
                        </shiro:hasPermission>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">运营管理</a>
                    <ul class="dropdown-menu">
                        <shiro:hasPermission name="/operator/provinceincome/query">
                            <li><a href="/operator/provinceincome/query">省份收入分析表</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/operator/deduct/list">
                            <li><a href="/operator/deduct/list">利润点管理</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/operator/productrealtime/query">
                            <li><a href="/operator/productrealtime/query">产品实时数据</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/operator/realtime/query">
                            <li><a href="/operator/realtime/query">实时数据</a></li>
                        </shiro:hasPermission>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">财务管理</a>
                    <ul class="dropdown-menu">
                        <shiro:hasPermission name="/finance/adownerbill/query">
                            <li><a href="/finance/adownerbill/query">广告主结算收入表</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/finance/webownerperiodbill/query">
                            <li><a href="/finance/webownerperiodbill/query">站长收入周期查询表</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/finance/bill/query">
                            <li><a href="/finance/bill/query">日报表</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/finance/webownerbill/query">
                            <li><a href="/finance/webownerbill/query">站长收入结算</a></li>
                        </shiro:hasPermission>
                    </ul>
                </li>
                </ul>

            </div>
            <ul class="nav pull-right">
                <li><a href="#">${sessionScope.name}</a></li>
                <li><a href="/passport/logout">登出</a></li>
            </ul>
            <!-- /.nav-collapse -->
        </div>
    </div>
    <!-- /navbar-inner -->
</div>
