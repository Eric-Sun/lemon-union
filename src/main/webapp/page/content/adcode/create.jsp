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
            <jsp:param name="top" value="2"/>
        </jsp:include>
        <jsp:include page="/page/content/include/current.jsp">
            <jsp:param name="top" value="1"/>
        </jsp:include>
    </div>
    <form name="form" class="form-horizontal" method="post" action="/content/adcode/create" id="form">
        <fieldset>
            <div class="control-group">
                <label class="control-label">广告主id</label>

                <div class="controls">
                    <input type="text" name="adownerid">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">产品id</label>

                <div class="controls">
                    <input type="text" name="pid">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">业务代码</label>

                <div class="controls">
                    <input type="text" name="servicecode">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">业务名称</label>

                <div class="controls">
                    <input type="text" name="servicename">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">业务资费</label>

                <div class="controls">
                    <input type="text" name="servicefee">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">结算资费</label>

                <div class="controls">
                    <input type="text" name="ownerfee">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">结算资费</label>

                <div class="controls">
                    <input type="text" name="ordercode">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">结算资费</label>

                <div class="controls">
                    <input type="text" name="orderdest">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">客服电话</label>

                <div class="controls">
                    <input type="text" name="servicephone">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">资费说明</label>

                <div class="controls">
                    <textarea name="brief"></textarea>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">管理备注</label>

                <div class="controls">
                    <input type="text" name="remark">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">扣量</label>

                <div class="controls">
                    <input type="text" name="offnum">/ <input type="text" name="offbase">
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
