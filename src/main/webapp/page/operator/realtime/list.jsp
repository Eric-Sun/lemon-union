<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>实时数据</title>
    <jsp:include page="/page/common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="/page/common/top.jsp">
            <jsp:param name="top" value="2"/>
        </jsp:include>
        <jsp:include page="/page/operator/include/current.jsp">
            <jsp:param name="current" value="3"/>
        </jsp:include>
    </div>
    <form name="form" class="form-horizontal" method="post" action="/operator/realtime/query" id="form">
        <fieldset>
            <input type="submit" class="btn btn-primary" value="查询"/>
        </fieldset>
    </form>
    <div class="body">
        <div>
            <table id="myTable" class="table table-bordered table-condensed">
                <thead>
                <tr>
                    <th>站长id</th>
                    <th>产品id</th>
                    <th>条数</th>
                    <th>支付金额</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dto" items="${list}">
                    <td>${dto.wid}</td>
                    <td>${dto.pid}</td>
                    <td>${dto.total}</td>
                    <td>${dto.feeincome}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </form>
        </div>
        <div class="page">${pageHtml}</div>
    </div>
</div>
</body>
<script>
    //    $(document).ready(function () {
    //        $("#myTable").tablesorter({sortList: [
    //            [0, 0],
    //            [1, 0]
    //        ]});
    //    });

    $(function () {
        $("#datepicker").datepicker();
        $("#datepicker2").datepicker();
    });
</script>
</html>
