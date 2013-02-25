<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>内容源文章列表</title>
    <jsp:include page="../common/include_static.jsp"/>

    <link rel="stylesheet" href="../editor/themes/default/default.css"/>
    <link rel="stylesheet" href="../editor/plugins/code/prettify.css"/>
    <script charset="utf-8" src="../editor/kindeditor.js"></script>
    <script charset="utf-8" src="../editor/lang/zh_CN.js"></script>
    <script charset="utf-8" src="../editor/plugins/code/prettify.js"></script>
    <%--<script>--%>
        <%--KindEditor.ready(function (K) {--%>
            <%--var editor = K.create('textarea[name="content"]', {--%>
                <%--cssPath:'../editor/plugins/code/prettify.css',--%>
                <%--uploadJson:'../jsp/upload_json.jsp',--%>
                <%--fileManagerJson:'../jsp/file_manager_json.jsp',--%>
                <%--allowFileManager:true,--%>
<%--//                items:['source', '|', 'undo', 'redo', '|', 'preview', 'print',  'cut', 'copy', 'paste',--%>
<%--//                    'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',--%>
<%--//                    'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',--%>
<%--//                    'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',--%>
<%--//                    'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',--%>
<%--//                    'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage', 'table', 'hr',  'pagebreak',--%>
<%--//                    'anchor', 'link', 'unlink'],--%>
                <%--afterCreate:function () {--%>
                    <%--var self = this;--%>
                    <%--K.ctrl(document, 13, function () {--%>
                        <%--self.sync();--%>
                        <%--document.forms['example'].submit();--%>
                    <%--});--%>
                    <%--K.ctrl(self.edit.doc, 13, function () {--%>
                        <%--self.sync();--%>
                        <%--document.forms['example'].submit();--%>
                    <%--});--%>
                <%--}--%>
            <%--});--%>
            <%--prettyPrint();--%>
        <%--});--%>
    <%--</script>--%>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="../common/top.jsp">
            <jsp:param name="top" value="2"/>
        </jsp:include>
        <jsp:include page="include/current.jsp">
            <jsp:param name="current" value="2"/>
        </jsp:include>
    </div>
    <div class="body">
        <%--<div>--%>
        <%--<div class="btn-group" style="margin: 18px 5px 25px 20px ; float: left">--%>
        <%--<button onclick="recommend(1);" class="btn<c:out value="${recommend == 1?' choose':''}"/>">已推荐</button>--%>
        <%--<button onclick="recommend(0);" class="btn<c:out value="${recommend < 1?' choose':''}"/>">待推荐</button>--%>
        <%--</div>--%>
        <%--<form action="/article/list" name="search" id="search" method="get" class="well form-inline">--%>
        <%--<input type="hidden" name="channelId" value="${channelId}">--%>
        <%--<input type="hidden" name="recommend" value="${recommend}">--%>
        <%--<input type="hidden" name="bestFlag" value="${bestFlag}">--%>

        <%--<c:if test="${bestFlag != 1||recommend != 1}">--%>
        <%--<label class="control-label">按时间：</label>--%>
        <%--<input name="startTime" id="datepicker" data-date="" data-date-format="yyyy-mm-dd" class="span2"--%>
        <%--size="16" type="text" value="${param.startTime}"> 到--%>
        <%--<input name="endTime" id="datepicker2" data-date="" data-date-format="yyyy-mm-dd" class="span2"--%>
        <%--size="16" type="text" value="${param.endTime}">--%>
        <%--<label class="checkbox"><input--%>
        <%--<c:if test="${param.pvOrder>0}"> checked="checked"</c:if> name="pvOrder" type="checkbox" value="1">--%>
        <%--按Pv排序</label>--%>
        <%--<label class="control-label">按权重：</label>--%>
        <%--<select name="weight" style="width: 70px;">--%>
        <%--<option value="-1">全部</option>--%>
        <%--<option value="1" <c:if test="${param.weight eq 1}">selected="selected"</c:if>>1--%>
        <%--</option>--%>
        <%--<option value="2" <c:if test="${param.weight eq 2}">selected="selected"</c:if>>2--%>
        <%--</option>--%>
        <%--<option value="3" <c:if test="${param.weight eq 3}">selected="selected"</c:if>>3--%>
        <%--</option>--%>
        <%--<option value="4" <c:if test="${param.weight eq 4}">selected="selected"</c:if>>4--%>
        <%--</option>--%>
        <%--<option value="5" <c:if test="${param.weight eq 5}">selected="selected"</c:if>>5--%>
        <%--</option>--%>
        <%--</select>--%>
        <%--<label class="control-label">新闻ID：</label>--%>
        <%--<input type="text" name="articleId" class="search-query" value="${param.articleId}"/>--%>
        <%--<input type="submit" value="查询" class="btn">--%>
        <%--</c:if>--%>
        <%--</form>--%>
        <%--</div>--%>
        <div>
            <form name="article" method="post" action="/article/edit?location=${location}">
                <input type="hidden" name="articleId" value="${article.id}"/>
                <input type="text" name="title" style="width: 100%; height: 35px;font-size: 16px; font-weight: 700;"
                       value="<c:out value="${article.title}"/>">

                <div style="margin-top: 8px;">
                    <textarea name="content" cols="100" rows="8"
                              style="width:100%;height:700px;"><c:out value="${article.content}"/></textarea>
                </div>
                <div class="form-actions" style="text-align: center">
                    <button type="submit" class="btn btn-primary">Save changes</button>
                    <button class="btn" onclick="history.go(-1);">Cancel</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>