<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>新闻管理列表</title>
    <jsp:include page="/page/common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <div class="top">
            <jsp:include page="/page/common/top.jsp">
                <jsp:param name="top" value="1"/>
            </jsp:include>
            <jsp:include page="/page/content/include/current.jsp">
                <jsp:param name="current" value="2"/>
            </jsp:include>
        </div>
    </div>
    <ul class="breadcrumb">
    			<li> <a href="/page/content/adowner/create.jsp">添加广告主</a> </li>

    </ul>
    <div class="body">
        <div>
                <table id="myTable" class="table table-bordered table-condensed">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>名称</th>
                         <th>公司名</th>
                         <th>状态</th>
                         <th>时间</th>
                         <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dto" items="${list}">
                            <td>${dto.adownerid}</td>
                            <td>${dto.name}</td>
                             <td>${dto.company}</td>
                        <c:choose>
                            <c:when test="${dto.status==1}">
                                <td>正常</td>
                            </c:when>
                            <c:otherwise>
                                <td>异常</td>
                            </c:otherwise>
                        </c:choose>

                               <td>${dto.createtime}</td>
                               <td><div class="btn-group">
                               									<a href="/content/adowner/show?id=${dto.adownerid}"  title="编辑"><i
                               										class="icon-edit"></i></a> <a
                               										href="/content/adowner/delete?id=${dto.adownerid}" rel="tooltip"
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
