<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html><html>
<head>
    <title>省份收入查询</title>
    <jsp:include page="/page/common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="/page/common/top.jsp">
            <jsp:param name="top" value="3"/>
        </jsp:include>
        <jsp:include page="/page/finance/include/current.jsp">
            <jsp:param name="current" value="2"/>
        </jsp:include>
    </div>
    <div class="body">
        <div>
            <table id="myTable" class="table table-bordered table-condensed">
                <thead>
                <tr>
                    <th>帐期</th>
                    <th>总金额</th>
                    <th>计费条数</th>
                    <th>计费金额</th>
                    <th>支付条数</th>
                    <th>支付金额</th>
                    <th>公司收益</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dto" items="${list}">
                    <td><fmt:formatDate value="${dto.billdate}" type="date"/>  </td>
                    <td>${dto.totalincome}</td>
                    <td>${dto.feecount}</td>
                    <td>${dto.feeincome}</td>
                    <td>${dto.showcount}</td>
                    <td>${dto.showincome}</td>
                    <td>${dto.ownerincome}</td>
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
        $("#myTable").tablesorter({sortList: [[0,0], [1,0]]});
    });
</script>
</html>
