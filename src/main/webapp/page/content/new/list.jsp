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
                        <th>id</th>
                        <th>标题</th>
                         <th>栏目id</th>
                         <th>状态</th>
                         <th>时间</th>
                         <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dto" items="${list}">
                    <td>${dto.id}</td>
                            <td>${dto.name}</td>
                            <td>${dto.parentid}</td>
                             <td>${dto.isleaf}</td>
                              <td>${dto.orders}</td>
                               <td>${dto.createtime}</td>
                               <div class="btn-group">
                               									<a href="#modal" data-toggle="modal" rel="tooltip"
                               										onclick="form_update(${role.id});" title="编辑"><i
                               										class="icon-edit"></i></a> <a
                               										href="/auth/role/delete?id=${role.id}" rel="tooltip"
                               										title="删除"><i class="icon-trash"></i></a>
                               								</div>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    <jsp:include page="/page/common/message.jsp"/>
</div>
<jsp:include page="modal.jsp" />
</body>
<script>
$(document).ready(function()
    {
        $("#myTable").tablesorter( {sortList: [[0,0], [1,0]]} );
    });
</script>
</html>
