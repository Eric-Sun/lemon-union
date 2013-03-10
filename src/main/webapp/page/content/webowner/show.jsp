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
            <jsp:param name="top" value="1"/>
        </jsp:include>
        <jsp:include page="/page/content/include/current.jsp">
            <jsp:param name="current" value="5"/>
        </jsp:include>
    </div>
    <form name="form" class="form-horizontal" method="post" action="/content/webowner/update" id="form">
        <fieldset>
            <div class="control-group">
                <label class="control-label">网站主id</label>

                <div class="controls">
                    <input type="text" name="wid" value="${dto.wid}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">真实姓名</label>

                <div class="controls">
                    <input type="text" name="truename" value="${dto.truename}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">联系电话</label>

                <div class="controls">
                    <input type="text" name="mobile" value="${dto.mobile}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">座机</label>

                <div class="controls">
                    <input type="text" name="telephone" value="${dto.telephone}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">联系地址</label>

                <div class="controls">
                    <input type="text" name="address" value="${dto.address}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">qq</label>

                <div class="controls">
                    <input type="text" name="qq" value="${dto.qq}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">网站名称</label>

                <div class="controls">
                    <input type="text" name="sitename" value="${dto.sitename}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">网址</label>

                <div class="controls">
                    <input type="text" name="siteurl" value="${dto.siteurl}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">网站类型</label>

                <div class="controls">
                    <input type="text" name="sitetype" value="${dto.sitetype}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">银行</label>

                <div class="controls">
                    <input type="text" name="banktype" value="${dto.banktype}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">所在地</label>

                <div class="controls">
                    <input type="text" name="bankaddr"  value="${dto.bankaddr}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">卡号</label>

                <div class="controls">
                    <input type="text" name="bankcard" value="${dto.bankcard}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">开户人</label>

                <div class="controls">
                    <input type="text" name="account"  value="${dto.account}">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">注册时间</label>

                <div class="controls">
                    <input type="text" name="regtime" value="${dto.regtime}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">父id</label>

                <div class="controls">
                    <input type="text" name="channel" value="${dto.channel}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">备注</label>

                <div class="controls">
                    <textarea name="remark">${dto.remark}</textarea>
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
