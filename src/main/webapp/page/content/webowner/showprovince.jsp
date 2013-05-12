<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>网站主省份限量列表</title>
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
    <form name="form" class="form-horizontal" method="post" action="/content/webowner/modifyprovince" id="form">
        <fieldset>
            <div class="control-group">
                <label class="control-label">网站主id</label>

                <div class="controls">
                    <input type="text" name="wid"  readonly="true" value="${wid}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">青海</label>

                <div class="controls">
                    <input type="text" name="qinghai"  value="${map['qinghai']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">新疆</label>

                <div class="controls">
                    <input type="text" name="xinjiang"  value="${map['xizang']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">河南</label>

                <div class="controls">
                    <input type="text" name="henan"  value="${map['xizang']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">西藏</label>

                <div class="controls">
                    <input type="text" name="xizang"  value="${map['xizang']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">宁夏</label>

                <div class="controls">
                    <input type="text" name="ningxia"  value="${map['ningxia']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">四川</label>

                <div class="controls">
                    <input type="text" name="sichuan"  value="${map['sichuan']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">广东</label>

                <div class="controls">
                    <input type="text" name="guangdong"  value="${map['guangdong']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">内蒙古</label>

                <div class="controls">
                    <input type="text" name="neimenggu"  value="${map['neimenggu']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">北京</label>

                <div class="controls">
                    <input type="text" name="beijing"  value="${map['beijing']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">甘肃</label>

                <div class="controls">
                    <input type="text" name="gansu"  value="${map['gansu']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">山西</label>

                <div class="controls">
                    <input type="text" name="shan1xi1"  value="${map['shan1xi']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">云南</label>

                <div class="controls">
                    <input type="text" name="yunnan"  value="${map['yunnan']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">福建</label>

                <div class="controls">
                    <input type="text" name="fujian"  value="${map['fujian']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">辽宁</label>

                <div class="controls">
                    <input type="text" name="liaoning"  value="${map['liaoning']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">贵州</label>

                <div class="controls">
                    <input type="text" name="guizhou"  value="${map['guizhou']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">江西</label>

                <div class="controls">
                    <input type="text" name="jiangxi"  value="${map['jiangxi']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">山东</label>

                <div class="controls">
                    <input type="text" name="shandong"  value="${map['shandong']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">上海</label>

                <div class="controls">
                    <input type="text" name="shanghai"  value="${map['shanghai']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">广西</label>

                <div class="controls">
                    <input type="text" name="guangxi"  value="${map['guangxi']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">江苏</label>

                <div class="controls">
                    <input type="text" name="jiangsu"  value="${map['jiangsu']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">黑龙江</label>

                <div class="controls">
                    <input type="text" name="heilongjiang"  value="${map['heilongjiang']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">天津</label>

                <div class="controls">
                    <input type="text" name="tianjin"  value="${map['tianjin']}">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">浙江</label>

                <div class="controls">
                    <input type="text" name="zhejiang"  value="${map['zhejiang']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">重庆</label>

                <div class="controls">
                    <input type="text" name="chongqing"  value="${map['chongqing']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">河北</label>

                <div class="controls">
                    <input type="text" name="hebei"  value="${map['hebei']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">吉林</label>

                <div class="controls">
                    <input type="text" name="jilin"  value="${map['jilin']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">海南</label>

                <div class="controls">
                    <input type="text" name="hainan"  value="${map['hainan']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">陕西</label>

                <div class="controls">
                    <input type="text" name="shan3xi"  value="${map['shan3xi']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">湖北</label>

                <div class="controls">
                    <input type="text" name="hubei"  value="${map['hubei']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">安徽</label>

                <div class="controls">
                    <input type="text" name="anhui"  value="${map['anhui']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">湖南</label>

                <div class="controls">
                    <input type="text" name="hunan"  value="${map['hunan']}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">未知</label>

                <div class="controls">
                    <input type="text" name="weizhi"  value="${map['weizhi']}">
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
