<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>内容源文章列表</title>
<jsp:include page="../../common/include_static.jsp" />
</head>
<body>
	<div class="container">
		<div class="top">
			<jsp:include page="../../common/top.jsp">
				<jsp:param name="top" value="2" />
			</jsp:include>
			<jsp:include page="../include/current.jsp">
				<jsp:param name="top" value="2" />
			</jsp:include>
		</div>
		<ul class="breadcrumb">
			<li <%if ("0".equals(request.getParameter("current"))) {%>
				class="active" <%}%>><a data-toggle="modal" href="#roleModal"
				onclick="role_form_add();">添加新的权限</a>
		</ul>
		<div class="body">
			<div>
				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<td>id</td>
							<td>name</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="role" items="${roleList}">
							<td>${role.id}</td>
							<td>${role.name}</td>
							<td class="tooltip-demo">
								<div class="btn-group">
									<a href="#roleModal" data-toggle="modal" rel="tooltip"
										onclick="form_update(${role.id});" title="编辑"><i
										class="icon-edit"></i></a> <a
										href="/auth/role/delete?id=${role.id}" rel="tooltip"
										title="删除"><i class="icon-trash"></i></a>
								</div>
							</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</form>
			</div>
		</div>
		<jsp:include page="../../common/message.jsp" />
	</div>
	<jsp:include page="modal.jsp" />
	</div>
</body>
</html>
<script type="text/javascript">
	function role_form_add() {
	    $("#lastTime").hide();
	    $("#id").remove();
	    roleForm.reset();
	    $("#cb").html("");
	    roleForm.action = "/auth/role/create";
	    add_permissions();
	}
	
	function add_permissions(){
		  $.post("/auth/permission/jlist", {}, function (data) {
		        if (null == data || "" == data) {
		            do_alert(0);
		            return false;
		        }
		        for(var i=0;i<data.length;i++){
		        	var checkstr = "";
		        	if(data[i].selected=='true'){
		        		checkstr = "checked";
		        	}
		        	$("#cb").append("<label class=\"checkbox inline\"><input type='checkbox' name='permissionIdArray' "
		        			+checkstr+" value='"+data[i].id+"'>"+data[i].name+"</input></label>");
		        }
		        
		    }, "json");
	}
	
	function form_update(id) {
	    $("#id").remove();
        $("#cb").html("");
	    roleForm.action = "/auth/role/update";
	    $.post("/auth/role/fetch", {"id":id}, function (data) {
	    	 
	        if (null == data || "" == data) {
	            do_alert(0);
	            return false;
	        }

	        $("#roleForm").append("<input type='hidden' name='id' id='id' value='" + data.id + "'/>");
	        
	        for(var i=0;i<data.permissionList.length;i++){
	        	var checkstr = "";
	        	if(data.permissionList[i].selected==true){
	        		checkstr = "checked";
	        	}
	        	$("#cb").append("<label class=\"checkbox inline\"><input type='checkbox' name='permissionIdArray' "
	        			+checkstr+" value='"+data.permissionList[i].id+"'>"+data.permissionList[i].name+"</input></label>");
	        }
	        
	        roleForm.name.value = data.name;
	    }, "json");
	}
	function form_add() {
	    $("#lastTime").hide();
	    $("#id").remove();
	    $("#iconInfo").remove();
	    roleForm.reset();
	    roleForm.action = "/source/add?location=${location}";
	}

</script>