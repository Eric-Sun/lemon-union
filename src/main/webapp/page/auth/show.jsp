<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>${article.title}</title>
    <jsp:include page="../common/include_static.jsp"/>
    <style>
        #gototop {
            BORDER: #FBB450 1px solid;
            PADDING-RIGHT: 10px;
            PADDING-LEFT: 10px;
            FONT-WEIGHT: bold;
            RIGHT: 5px;
            PADDING-BOTTOM: 10px;
            COLOR: #FBB450;
            BOTTOM: 5px;
            PADDING-TOP: 10px;
            POSITION: fixed;
            TEXT-DECORATION: none
        }

        #gototop {
            TEXT-DECORATION: underline
        }

        form {
            float: left;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="../common/top.jsp">
            <jsp:param name="top" value="2"/>
        </jsp:include>
        <%--<jsp:include page="include/current.jsp">--%>
        <%--<jsp:param name="current" value="2"/>--%>
        <%--</jsp:include>--%>
    </div>
    <div class="body">
        <div class="well">
            来自：<a href="/source/articles?sourceId=${article.sourceId}">${article.sourceName}</a>
            <a href="${article.originalUrl}" target="_blank" style="margin-left: 30px;">访问原文地址</a>
            <a href="javascript:;" class="btn btn-inverse" onclick="window.close();" style="margin-left: 30px;">关闭</a>
            <a href="/article/edit?articleId=${article.id}&location=${location}" class="btn btn-info"
               style="margin-left: 30px;">编辑</a>
            <%--<form method="post" name="black" action="/blackText?articleId=${article.id}&sourceId=${article.sourceId}" style="float: right; margin-top: -10px;">--%>
            <%--<textarea name="blackText" cols="100" rows="8"--%>
            <%--style="margin-left: 70px;width:500px;height:40px; " placeholder="填入垃圾信息..."></textarea>--%>
            <%--<a href="javascript:;" class="btn btn-warning" onclick="black.submit();" style="margin-left: 30px; margin-top: 10px;">提交</a>--%>
            <%--</form>--%>
        </div>
        <jsp:include page="../common/message.jsp"/>
        <div class="well">
            <h1 style="text-align: center;">${article.title}</h1>

            <%request.setAttribute("vEnter", "\n");%>
            <p style="text-align: left; min-height: 450px; margin-top: 20px; word-wrap:break-word; word-break: break-all ">${fn:replace(article.content,vEnter,'<br>')}</p>
            <c:forEach var="image" items="${list}">
                <c:choose>
                    <c:when test="${image.coverFlag eq 1}">
                        <div class="well" style="background-color:#FFD39B;">
                            <button type="button" class="close"
                                    onclick="location.href='/article/delImage?imageId=${image.id}&articleId=${article.id}'">
                                ×
                            </button>
                            <button type="button" class="close"
                                    onclick="location.href='/article/updateCover?imageId=${image.id}&articleId=${article.id}'"
                                    style="margin-top: 30px; margin-right: -16px;">首
                            </button>
                            <img src="http://t6.wap.sohu.com/${image.url}">
                        </div>
                    </c:when>
                </c:choose>
            </c:forEach>
            <c:forEach var="image" items="${list}">
                <c:choose>
                    <c:when test="${image.coverFlag eq 0}">
                        <div class="well">
                            <button type="button" class="close"
                                    onclick="location.href='/article/delImage?imageId=${image.id}&articleId=${article.id}'">
                                ×
                            </button>
                            <button type="button" class="close"
                                    onclick="location.href='/article/updateCover?imageId=${image.id}&articleId=${article.id}'"
                                    style="margin-top: 30px; margin-right: -16px;">首
                            </button>
                            <img src="http://t6.wap.sohu.com/${image.url}">
                        </div>
                    </c:when>
                </c:choose>
            </c:forEach>


        </div>

        <div class="well choose">
            <form action="/article/recommend?location=${location}" method="POST">
                <input type="hidden" name="selectArticle" value="${article.id}"/>
                <input type="hidden" name="back" value="1"/>

                <div class="form-inline ">
                    <label class="checkbox inline">
                        <input type="checkbox" value="1" name="recommendType">全局精选
                    </label>
                    <label class="checkbox inline">
                        <input type="checkbox" value="2" name="recommendType" checked="checked">频道精选
                    </label> <select name="channelId">
                    <c:forEach var="channel" items="${channels}">
                        <option value="${channel.id}" <c:out
                                value="${channel.id eq article.channelId?'selected=\"selected\"':''}"/> />
                        ${channel.name}</option>
                    </c:forEach>
                </select>
                    <input type="submit" class="btn btn-primary" value="提交">
                </div>
            </form>
            <form action="/article/addImage?articleId=${article.id}" name="imageForm" method="post" id="imageForm"
                  class="form-inline " enctype="multipart/form-data"
                  style="float: right;margin-right: 50px; width: 400px;">
                上传图片：<input type="file" name="imageFile" style="width: 150px;"/>
                <input type="submit" class="btn btn-warning" value="提交">
            </form>
        </div>


        <c:if test="${!(empty(item))&&!(item.toString() eq '{}')}">
            <div>
                <table class="table table-striped table-bordered table-condensed">

                    <tr>
                        <td> 标题热度打分</td>
                        <td> ${item.get("HotTitleScore")} </td>
                    </tr>
                    <tr>
                        <td> 内容热度打分</td>
                        <td> ${item.get("HotContentScore")} </td>
                    </tr>
                    <tr>
                        <td> 文章的发表时间打分</td>
                        <td> ${item.get("TimeScore")} </td>
                    </tr>
                    <tr>
                        <td> 内容源推荐比例打分</td>
                        <td> ${item.get("RecommendScore")} </td>
                    </tr>
                    <tr>
                        <td> 内容源打分</td>
                        <td> ${item.get("SourceScore")} </td>
                    </tr>
                    <tr>
                        <td> 重复度打分</td>
                        <td> ${item.get("DupliArticleScore")} </td>
                    </tr>
                    <tr>
                        <td> 图片打分</td>
                        <td> ${item.get("ImageScore")} </td>
                    </tr>
                    <tr>
                        <td> 标题长度打分</td>
                        <td> ${item.get("TitleLengthScore")} </td>
                    </tr>
                    <tr>
                        <td> pageRank打分</td>
                        <td> ${item.get("PageRankScore")} </td>
                    </tr>
                    <tr>
                        <td> 内容长度打分</td>
                        <td> ${item.get("ContentLengthScore")} </td>
                    </tr>
                    <tr>
                        <td> 源的文章更新频度打分</td>
                        <td> ${item.get("UpdateFreqScore")} </td>
                    </tr>
                    <tr>
                        <td> 抓取频度打分</td>
                        <td> ${item.get("CrawlFreqScore")} </td>
                    </tr>
                    <tr>
                        <td> 主题度打分</td>
                        <td> ${item.get("TopicScore")} </td>
                    </tr>
                </table>
            </div>
        </c:if>

        <iframe id="baidu" style="width: 100%; margin-bottom: 50px;" frameborder=no width="100%"
                height="600px"></iframe>
    </div>
</div>
<a id="gototop" href="javascript:void(0);" onclick="goTop();return false;" style="float: right">Top</a>
<script>
    $(document).ready(function () {
        $("#baidu").attr("src", "http://gate.baidu.com/tc?bd_page_type=1&src=" + encodeURIComponent('${article.originalUrl}'));
    });
    function goTop(acceleration, time) {
        acceleration = acceleration || 0.1;
        time = time || 16;

        var x1 = 0;
        var y1 = 0;
        var x2 = 0;
        var y2 = 0;
        var x3 = 0;
        var y3 = 0;

        if (document.documentElement) {
            x1 = document.documentElement.scrollLeft || 0;
            y1 = document.documentElement.scrollTop || 0;
        }
        if (document.body) {
            x2 = document.body.scrollLeft || 0;
            y2 = document.body.scrollTop || 0;
        }
        var x3 = window.scrollX || 0;
        var y3 = window.scrollY || 0;

        // 滚动条到页面顶部的水平距离
        var x = Math.max(x1, Math.max(x2, x3));
        // 滚动条到页面顶部的垂直距离
        var y = Math.max(y1, Math.max(y2, y3));

        // 滚动距离 = 目前距离 / 速度, 因为距离原来越小, 速度是大于 1 的数, 所以滚动距离会越来越小
        var speed = 1 + acceleration;
        window.scrollTo(Math.floor(0), Math.floor(0));
//        window.scrollTo(Math.floor(x / speed), Math.floor(y / speed));
//
//        // 如果距离不为零, 继续调用迭代本函数
//        if(x > 0 || y > 0) {
//            var invokeFunction = "goTop(" + acceleration + ", " + time + ")";
//            window.setTimeout(invokeFunction, time);
//        }
    }
</script>
</body>
</html>