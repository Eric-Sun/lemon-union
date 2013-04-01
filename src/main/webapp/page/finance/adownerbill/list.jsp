<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>广告主结算收入表</title>
    <jsp:include page="/page/common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="/page/common/top.jsp">
            <jsp:param name="top" value="3"/>
        </jsp:include>
        <jsp:include page="/page/finance/include/current.jsp">
            <jsp:param name="current" value="0"/>
        </jsp:include>
    </div>
    <form name="form" class="form-horizontal" method="post" action="/finance/adownerbill/query" id="form">
        <fieldset>
            <label class="control-label">按时间：</label>
            <input name="beginDate" id="datepicker" data-date="" data-date-format="yyyy-mm-dd" style="width: 80px;"
                   size="16" type="text" value="${param.beginDate}"> 到
            <input name="endDate" id="datepicker2" data-date="" data-date-format="yyyy-mm-dd" style="width: 80px;"
                   size="16" type="text" value="${param.endDate}">
            <input type="submit" class="btn btn-primary" value="查询"/>
        </fieldset>
    </form>
    <div class="body">
        <div>
            <table id="myTable" class="table table-bordered table-condensed">
                <thead>
                <tr>
                    <th>广告主</th>
                    <th>总金额</th>
                    <th>计费条数</th>
                    <th>计费金额</th>
                    <th>支付条数</th>
                    <th>支付金额</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dto" items="${list}">
                    <td>${dto.servicecode}</td>
                    <td>${dto.totalincome}</td>
                    <td>${dto.feecount}</td>
                    <td>${dto.feeincome}</td>
                    <td>${dto.showcount}</td>
                    <td>${dto.showincome}</td>
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
    $(document).ready(function () {
        $("#myTable").tablesorter();
    });

    $(function () {
        $("#datepicker").datepicker();
        $("#datepicker2").datepicker();
    });
</script>
</html>
