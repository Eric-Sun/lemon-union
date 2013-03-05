<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>添加ivr信息</title>
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
    <form name="form" class="form-horizontal" method="post" action="/content/ivrinfo/update" id="form">
        <fieldset>
            <input type="hidden" name="id" value="${dto.id}" />
            <div class="control-group">
                <label class="control-label">网站主id</label>

                <div class="controls">
                    <input type="text" name="wid" value="${dto.wid}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">子id</label>

                <div class="controls">
                    <input type="text" name="channel" value="${dto.channel}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">业务代码</label>

                <div class="controls">
                    <input type="text" name="servicecode" value="${dto.servicecode}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">ivrnum</label>

                <div class="controls">
                    <input type="text" name="ivrnum" value="${dto.ivrnum}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">计费号码</label>

                <div class="controls">
                    <input type="text" name="feenum" value="${dto.feenum}">
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
