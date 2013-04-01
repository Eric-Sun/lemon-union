<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>添加广告代码</title>
    <jsp:include page="/page/common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="/page/common/top.jsp">
            <jsp:param name="top" value="1"/>
        </jsp:include>
        <jsp:include page="/page/content/include/current.jsp">
            <jsp:param name="current" value="3"/>
        </jsp:include>
    </div>
    <form name="form" class="form-horizontal" method="post" action="/content/adcode/update" id="form">
        <fieldset>
            <input type="hidden" value="${dto.id}" name="id"/>
            <div class="control-group">
                <label class="control-label">广告主id</label>

                <div class="controls">
                    <input type="text" name="adownerid" value="${dto.adownerid}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">产品id</label>

                <div class="controls">
                    <input type="text" name="pid" value="${dto.pid}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">业务代码</label>

                <div class="controls">
                    <input type="text" name="servicecode" value="${dto.servicecode}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">业务名称</label>

                <div class="controls">
                    <input type="text" name="servicename" value="${dto.servicename}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">业务资费</label>

                <div class="controls">
                    <input type="text" name="servicefee"  value="${dto.servicefee}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">结算资费</label>

                <div class="controls">
                    <input type="text" name="ownerfee"  value="${dto.ownerfee}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">指令</label>

                <div class="controls">
                    <input type="text" name="ordercode"  value="${dto.ordercode}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">目的号</label>

                <div class="controls">
                    <input type="text" name="orderdest"  value="${dto.orderdest}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">客服电话</label>

                <div class="controls">
                    <input type="text" name="servicephone"  value="${dto.servicephone}">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">资费说明</label>

                <div class="controls">
                    <textarea name="brief">${dto.brief}</textarea>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">管理备注</label>

                <div class="controls">
                    <input type="text" name="remark"  value="${dto.remark}">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">扣量</label>

                <div class="controls">
                    <input type="text" name="offnum"  value="${dto.offnum}">/ <input type="text" name="offbase"  value="${dto.offbase}">
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <input type="submit" class="btn btn-primary" value="提交"/>
                </div>
            </div>
        </fieldset>


    </form>
</div>
</html>
