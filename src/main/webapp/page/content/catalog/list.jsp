<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>分类管理列表</title>
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
                        <th>栏目名称</th>
                         <th>父id</th>
                         <th>类型</th>
                         <th>排序</th>
                         <th>时间</th>
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
