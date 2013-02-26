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
    <form name="form" class="form-horizontal" method="post" action="/content/new/update" id="form">
        <fieldset>
            <input name="id" type="hidden" value="${dto.id}"/>
            <div class="control-group">
                <label class="control-label">标题</label>

                <div class="controls">
                    <input type="text" name="title" value="${dto.title}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">来源</label>

                <div class="controls">
                    <input type="text" name="orign" value="${dto.orign}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">编辑</label>

                <div class="controls">
                    <input type="text" name="editor" value="${dto.editor}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">内容简介</label>

                <div class="controls">
                    <input type="text" name="brief" value="${dto.brief}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">内容简介</label>

                <div class="controls">
                    <textarea name="content">${dto.content}</textarea>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">优先级</label>

                <div class="controls">
                    <select name="flag">
                        <option value="0">默认</option>
                    </select>
                </div>
            </div>


            <div class="control-group">
                <label class="control-label">状态</label>

                <div class="controls">
                    <input type="radio" name="delete"/> 显示
                </div>
            </div>


            <div class="control-group">
                <label class="control-label">优先级</label>

                <div class="controls">
                    <select name="catalogid">
                        <option value="jzim3u002">重要公告</option>
                        <option value="qquujv001">行业资讯</option>
                    </select>
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
<script>
    window.onload = function () {
        CKEDITOR.replace('content');
    };
</script>
