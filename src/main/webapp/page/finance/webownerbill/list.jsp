<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html><html>
<head>
    <title>站长收入结算</title>
    <jsp:include page="/page/common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="/page/common/top.jsp">
            <jsp:param name="top" value="3"/>
        </jsp:include>
        <jsp:include page="/page/finance/include/current.jsp">
            <jsp:param name="current" value="3"/>
        </jsp:include>
    </div>
    <form name="form2" class="well form-inline" method="post"
          action="/finance/webownerbill/query" id="form2">
        <fieldset>
            <label class="control-label">站长id：</label>
            <input name="wid" type="text"/>
            <label class="control-label">产品id：</label>
            <input name="pid" type="text"/>
            <input type="submit" class="btn btn-primary" value="查询"/>
        </fieldset>
    </form>
    <div class="body">
        <input type="submit" class="btn btn-primary" value="支付" onclick="doPay()"/>
        <input type="submit" class="btn btn-primary" value="取消支付" onclick="dontPay()"/>

        <div>
            <form name="form" action="/finance/webownerbill/pay">
                <input id="type" name="type" type="hidden" value="1"/>
                <table id="myTable" class="table table-bordered table-condensed">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="checkAll"/></th>
                        <th>ID</th>
                        <th>帐期</th>
                        <th>站长ID</th>
                        <th>产品</th>
                        <th>总金额</th>
                        <th>计费条数</th>
                        <th>计费金额</th>
                        <th>支付条数</th>
                        <th>支付金额</th>
                        <th>结算</th>
                        <th>支付时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dto" items="${list}">
                        <tr>
                            <td><input type="checkbox" name="ids" value="${dto.id}"/>
                            <td>${dto.id}</td>
                            <td><fmt:formatDate value="${dto.billdate}" type="date"/></td>
                            <td>${dto.wid}</td>
                            <td>${dto.pid}</td>
                            <td>${dto.totalincome}</td>
                            <td>${dto.feecount}</td>
                            <td>${dto.feeincome}</td>
                            <td>${dto.showcount}</td>
                            <td>${dto.showincome}</td>
                            <td><c:if test="${dto.payflag==1}">
                                <strong>已支付</strong>
                            </c:if>
                                <c:if test="${dto.payflag==0}">
                                    未支付
                                </c:if></td>
                            <td><fmt:formatDate value="${dto.paytime}" type="date"/></td>
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

    $("#checkAll").click(function () {
        if ($(this).attr("checked") != undefined) {
            $("tbody input:checkbox").attr("checked", "checked");
        } else {
            $("tbody input:checkbox").removeAttr("checked");
        }
    });

    function doPay() {
        form.submit();
    }

    function dontPay() {
        $("#type").val(0);
        form.submit();
    }
</script>
</html>
