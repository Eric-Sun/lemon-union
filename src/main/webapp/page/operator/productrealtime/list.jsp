<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>产品实时数据</title>
    <jsp:include page="/page/common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="/page/common/top.jsp">
            <jsp:param name="top" value="2"/>
        </jsp:include>
        <jsp:include page="/page/operator/include/current.jsp">
            <jsp:param name="current" value="2"/>
        </jsp:include>
    </div>
    <form name="form" class="well form-inline" method="post"
          action="/operator/productrealtime/query" id="form">
        <fieldset>
            <label class="control-label">按时间：</label>
            <input name="startTime" id="datepicker" data-date="" data-date-format="yyyy-mm-dd" style="width: 80px;"
                   size="16" type="text" value="${param.startTime}"> 到
            <input name="endTime" id="datepicker2" data-date="" data-date-format="yyyy-mm-dd" style="width: 80px;"
                   size="16" type="text" value="${param.endTime}">
            <label class="control-label">按站长id：</label>
            <input name="wid" type="text"/>
            <label class="control-label">按手机号码：</label>
            <input name="mobile" type="text"/>
            <label class="control-label">按结算金额：</label>
            <input name="totalincome" type="text"/>
            <label class="control-label">按指令：</label>
            <input name="cmdid" type="text"/>
            <label class="control-label">点播号：</label>
            <input name="orderdest" type="text"/>
            <label class="control-label">扣量（0或者1）：</label>
            <input name="feeflag" type="text"/>
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
