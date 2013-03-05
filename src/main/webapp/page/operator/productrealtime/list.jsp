<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>省份收入查询</title>
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
                    <th>id</th>
                    <th>站长id</th>
                    <th>子id</th>
                    <th>产品id</th>
                    <th>手机号</th>
                    <th>点播号</th>
                    <th>指令</th>
                    <th>结算金额</th>
                    <th>分成佣金</th>
                    <th>扣点</th
                    <th>接收时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dto" items="${list}">
                    <td>${dto.id}</td>
                    <td>${dto.wid}</td>
                    <td>${dto.channel}</td>
                    <td>${dto.pid}</td>
                    <td>${dto.mobile}</td>
                    <td>${dto.orderdest}</td>
                    <td>${dto.ordercode}</td>
                    <td>${dto.totalincome}</td>
                    <td>${dto.feeincome}</td>
                    <td>${dto.feeflag}</td>
                    <td>${dto.subtime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </form>
        </div>
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
