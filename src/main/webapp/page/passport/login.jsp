<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理系统</title>
    <link href="/static/css/bootstrap.css" rel="stylesheet">
    <link href="/static/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="/static/js/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="/static/css/datepicker.css" rel="stylesheet">
    <link href="/static/css/cms.css" rel="stylesheet">


    <script src="/static/js/google-code-prettify/prettify.js"></script>
    <script src="/static/js/jquery.js"></script>
    <script src="/static/js/bootstrap.js"></script>
    <script src="/static/js/application.js"></script>
    <script src="/static/js/bootstrap-datepicker.js"></script>
    <script src="/static/js/cms.js"></script>
</head>
<body style="background-color: #339bb9">
<div class="modal"
     style="position: relative; top: auto; left: auto; margin: 0 auto; z-index: 1; max-width: 100%; margin-top: 15%">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>北京柠乐科技有限公司</h3>
    </div>
    <div class="modal-body">
        <form action="/passport/doLogin" method="post" name="loginForm" class="form-horizontal">
            <fieldset>
                <div class="control-group">
                    <label class="control-label">用户名</label>

                    <div class="controls">
                        <input type="text" name="name" value="${source.name}">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">密　码</label>

                    <div class="controls">
                        <input type="password" name="pwd" value="${source.name}">
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
    <c:if test="${!(empty message)}">
        <div class="alert fade in alert-error">
            <button class="close" data-dismiss="alert">×</button>
            <strong>${message}</strong>
        </div>
    </c:if>
    <div class="modal-footer">
        <a href="#" class="btn">Close</a>
        <a href="#" class="btn btn-primary" onclick="loginForm.submit();">Login</a>
    </div>
</div>


</body>
<script language="javascript">
    $(function(){
        document.onkeydown = function(e){
            var ev = document.all ? window.event : e;
            if(ev.keyCode==13) {
                loginForm.submit();
            }
        }
    });
</script>
</html>
