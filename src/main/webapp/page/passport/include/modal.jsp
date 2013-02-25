<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--  cover start  --%>

<div id="showModal" class="modal hide fade">
    <div class="modal-header">
        <button class="close" data-dismiss="modal">×</button>
        <h3>登录</h3>
    </div>
    <div class="modal-body">
        <form action="/source/add?location=${location}" name="save" method="post" id="showForm" class="form-horizontal" enctype="multipart/form-data">
            <input type="hidden" name="orderWeight" value="0">
            <fieldset>
                <div class="control-group">
                    <label class="control-label">用户名</label>

                    <div class="controls">
                        <input type="text" name="username" value="${source.name}">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">密码</label>

                    <div class="controls">
                        <input type="password" name="password" value="${source.name}">
                    </div>
                </div>

            </fieldset>
        </form>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="javascript:;" class="btn btn-primary" onclick="javascript:save.submit();">Submit</a>
    </div>
</div>
<%--   cover stop  --%>