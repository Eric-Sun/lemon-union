<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>新闻管理列表</title>
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
    <form name="form" class="form-horizontal" method="post" action="/content/adowner/create" id="form">
        <fieldset>
            <div class="control-group">
                <label class="control-label">标题</label>

                <div class="controls">
                    <input type="text" name="name">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">公司名称</label>

                <div class="controls">
                    <input type="text" name="company">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">备注</label>

                <div class="controls">
                    <textarea name="brief"></textarea>
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
