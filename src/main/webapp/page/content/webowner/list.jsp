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
        <jsp:include page="/page/common/top.jsp">
            <jsp:param name="top" value="2"/>
        </jsp:include>
        <jsp:include page="/page/content/include/current.jsp">
            <jsp:param name="top" value="1"/>
        </jsp:include>
    </div>
    <div class="body">
        <div>
                <table id="myTable" class="table table-bordered table-condensed">
                    <thead>
                    <tr>
                        <th>计费id</th>
                        <th>用户名</th>
                         <th>父ID</th>
                         <th>联系人</th>
                         <th>网站</th>
                        <th>地址</th>
                        <th>状态</th>
                        <th>时间</th>
                         <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dto" items="${list}">
                            <td>${dto.wid}</td>
                            <td>${dto.username}</td>
                             <td>${dto.channel}</td>
                        <td>${dto.truename}</td>
                        <td>${dto.siteurl}</td>
                        <td>${dto.address}</td>
                        <c:choose>
                            <c:when test="${dto.status==0}">
                                <td>待审</td>
                            </c:when>
                            <c:when test="${dto.status==1}">
                                <td>正常</td>
                            </c:when>
                            <c:when test="${dto.status==2}">
                                <td>不通过</td>
                            </c:when>
                            <c:otherwise>
                                <td>暂停</td>
                            </c:otherwise>
                        </c:choose>
                        <td>${dto.regtime}</td>
                               <td><div class="btn-group">
                                   <a href="/content/webowner/show?wid=${dto.wid}"  title="修改"><i
                                           class="icon-edit"></i></a>
                                   <c:choose>
                                       <c:when test="${dto.status==0}">
                                           <a href="/content/webowner/pass?wid=${dto.wid}"  title="通过"><i
                                                   class="icon-play"></i></a>
                                           <a href="/content/webowner/notpass?wid=${dto.wid}"  title="不通过"><i
                                                   class="icon-ban-circle"></i></a>
                                       </c:when>
                                       <c:when test="${dto.status==1}">
                                           <a href="/content/webowner/stop?wid=${dto.wid}"  title="暂停"><i
                                                   class="icon-pause"></i></a>
                                       </c:when>
                                       <c:when test="${dto.status==2}">
                                           -
                                       </c:when>
                                       <c:otherwise>
                                           <a href="/content/webowner/resume?wid=${dto.wid}"  title="恢复正常"><i
                                                   class="icon-play"></i></a>
                                       </c:otherwise>
                                   </c:choose>
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
