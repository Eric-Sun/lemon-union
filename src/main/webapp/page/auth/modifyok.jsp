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
      <h1>修改成功!</h1>
    </div>
</body>
</html>