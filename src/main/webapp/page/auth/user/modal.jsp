<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--  cover start  --%>

<div id="userModal" class="modal hide fade" name="userModal">
    <div class="modal-header">
        <button class="close" data-dismiss="modal">×</button>
        <h3>用户操作</h3>
    </div>
    <div class="modal-body">
        <form name="userForm" method="post" action="/auth/user/create" id="userForm">
            <fieldset>
                <div class="control-group">
                    <label class="control-label">用户名</label>

                    <div class="controls">
                        <input type="text" name="name" value="${user.name}">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">密码</label>

                    <div class="controls">
                        <input type="text" name="pwd" value="${user.pwd}">
                    </div>
                </div>
                
                <div class="control-group">
                    <label class="control-label">权限名称</label>
                    <div class="controls">
                        <input type="text" name="roleName" value="${user.roleName}">
                    </div>
                </div>

            </fieldset>
        </form>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="javascript:;" class="btn btn-primary" onclick="javascript:userForm.submit();">Submit</a>
    </div>
</div>
<%--   cover stop  --%>