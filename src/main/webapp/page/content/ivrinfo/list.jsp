<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>ivr信息管理</title>
    <jsp:include page="/page/common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="/page/common/top.jsp">
            <jsp:param name="top" value="1"/>
        </jsp:include>
        <jsp:include page="/page/content/include/current.jsp">
            <jsp:param name="current" value="6"/>
        </jsp:include>
    </div>
    <ul class="breadcrumb">
    			<li> <a href="/page/content/ivrinfo/create.jsp">添加ivr信息</a> </li>

    </ul>
    <div class="body">
        <div>
                <table id="myTable" class="table table-bordered table-condensed">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>网站主id</th>
                         <th>子id</th>
                         <th>业务代码</th>
                         <th>ivr号段</th>
                        <th>计费号码</th>
                        <th>状态</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dto" items="${list}">
                            <td>${dto.id}</td>
                            <td>${dto.wid}</td>
                             <td>${dto.channel}</td>
                        <td>${dto.servicecode}</td>
                        <td>${dto.ivrnum}</td>
                        <td>${dto.feenum}</td>
                        <c:choose>
                            <c:when test="${dto.status==1}">
                                <td>正常</td>
                            </c:when>
                            <c:otherwise>
                                <td>异常</td>
                            </c:otherwise>
                        </c:choose>

                               <td>${dto.subtime}</td>
                               <td><div class="btn-group">
                               									<a href="/content/ivrinfo/show?id=${dto.id}"  title="编辑"><i
                               										class="icon-edit"></i></a> <a
                               										href="/content/ivrinfo/delete?id=${dto.id}" rel="tooltip"
                               										title="删除"><i class="icon-trash"></i></a>
                               								</div></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    <jsp:include page="/page/common/message.jsp"/>
</div>
</body>
<script>
$(document).ready(function()
    {
        $("#myTable").tablesorter( {sortList: [[0,0], [1,0]]} );
    });

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

    window.onload = function() {
        CKEDITOR.replace( 'editor1' );
    };
</script>
</html>
