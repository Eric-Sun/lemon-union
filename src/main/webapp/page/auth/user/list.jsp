<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>内容源文章列表</title>
    <jsp:include page="../../common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="../../common/top.jsp">
            <jsp:param name="top" value="0"/>
        </jsp:include>
        <jsp:include page="../include/current.jsp">
            <jsp:param name="current" value="0"/>
        </jsp:include>
    </div>
    <ul class="breadcrumb">
        <li<%if ("0".equals(request.getParameter("current"))) {%> class="active" <%}%>><a data-toggle="modal"
                                                                                          href="#userModal" onclick=user_form_add();">添加用户</a>
    </ul>
    <div class="body">
        <div>
                <table class="table table-bordered table-condensed">
                    <thead>
                    <tr>
                        <td>id</td>
                        <td>用户名</td>
                        <td>密码</td>
                        <td>权限名称</td>
                        <td>操作</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${userList}">
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.pwd}</td>
                             <td>${user.roleName}</td>
                            <td class="tooltip-demo">
                                <div class="btn-group">
                                    <a href="#userModal" data-toggle="modal" rel="tooltip"
                                           onclick="form_update(${user.id});"
                                           title="编辑"><i
                                                class="icon-edit"></i></a>
                                    <a href="/auth/user/delete?userId=${user.id}"
                                       rel="tooltip" title="删除"><i
                                            class="icon-trash"></i></a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    <jsp:include page="../../common/message.jsp"/>
</div>
<jsp:include page="modal.jsp"/>
</div>
</body>
</html>
<script>
	function user_form_add() {
	    $("#lastTime").hide();
	    $("#id").remove();
	    channelForm.reset();
	    channelForm.action = "/auth/user/add";
	}
	function form_update(id) {
	    $("#id").remove();
	    userForm.action = "/auth/user/update";
	    $.post("/auth/user/fetch", {"userId":id}, function (data) {
	        if (null == data || "" == data) {
	            do_alert(0);
	            return false;
	        }
	        $("#userForm").append("<input type='hidden' name='userId' id='id' value='" + data.id + "'/>");
	        userForm.name.value = data.name;
	        userForm.pwd.value = data.pwd;
	        userForm.roleName.value=data.roleName;
	    }, "json");
	}
	function form_add() {
	    $("#lastTime").hide();
	    $("#id").remove();
	    $("#iconInfo").remove();
	    save.reset();
	    save.action = "/source/add?location=${location}";
	}

</script>