<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html><html>
<head>
    <title>内容源文章列表</title>
    <jsp:include page="../common/include_static.jsp"/>
</head>
<body>
<div class="container">
    <div class="top">
        <jsp:include page="../common/top.jsp">
            <jsp:param name="top" value="2"/>
        </jsp:include>
        <jsp:include page="include/channels.jsp"/>
    </div>
    <div class="body">
        <div>
            <form action="/article/list" name="search" id="search" method="get" class="well form-inline">
                <input type="hidden" name="channelId" value="${channelId}">
                <input type="hidden" name="recommend" value="${recommend}">
                <input type="hidden" name="bestFlag" value="${bestFlag}">
                <input type="hidden" name="recommendType" value="${recommendType}">

                <%--<c:if test="${bestFlag != 1||recommend != 1}">--%>
                <label class="control-label">按时间：</label>
                <input name="startTime" id="datepicker" data-date="" data-date-format="yyyy-mm-dd" style="width: 80px;"
                       size="16" type="text" value="${param.startTime}"> 到
                <input name="endTime" id="datepicker2" data-date="" data-date-format="yyyy-mm-dd" style="width: 80px;"
                       size="16" type="text" value="${param.endTime}">
                <label class="checkbox"><input
                <c:if test="${param.imageOnly>0}"> checked="checked"</c:if> name="imageOnly" type="checkbox" value="1">
                    只看有图</label>
                <label class="checkbox"><input
                <c:if test="${param.pvOrder>0}"> checked="checked"</c:if> name="pvOrder" type="checkbox" value="1">
                    按Pv排序</label>
                <label class="control-label">按权重：</label>
                <select name="weight" style="width: 50px;">
                    <option value="-99">all</option>
                    <option value="1" <c:if test="${param.weight eq 1}">selected="selected"</c:if>>1
                    </option>
                    <option value="2" <c:if test="${param.weight eq 2}">selected="selected"</c:if>>2
                    </option>
                    <option value="3" <c:if test="${param.weight eq 3}">selected="selected"</c:if>>3
                    </option>
                    <option value="4" <c:if test="${param.weight eq 4}">selected="selected"</c:if>>4
                    </option>
                    <option value="5" <c:if test="${param.weight eq 5}">selected="selected"</c:if>>5
                    </option>
                </select>
                <label class="control-label">新闻ID：</label>
                <input type="text" name="articleId" class="search-query" value="${param.articleId}" style="width: 50px;"/>
                <label class="control-label">按标题：</label>
                <input type="text" name="title" value="${param.title}" class="input-medium search-query">
                <input type="submit" value="查询" class="btn">
                <%--</c:if>--%>
            </form>
        </div>
        <div>
            <form action="/article/recommend?location=${location}" method="POST">
                <%--<table class="table table-striped table-bordered table-condensed">--%>
                <table class="table table-bordered table-condensed">
                    <thead>
                    <tr>
                        <td><input type="checkbox" id="checkAll"/></td>
                     <c:if test="${sessionScope.admin.level>=10}"><td>ID</td></c:if>
                        <td>权重</td>
                        <td>打分</td>
                        <td>标题</td>
                        <td>pv</td>
                        <%--<td>关键字</td>--%>
                        <td>频道</td>
                        <%--<td>主题</td>--%>
                        <td>内容源</td>
                        <td>创建时间</td>
                        <%--<td>创建人</td>--%>
                        <%--<td>推荐人</td>--%>
                        <td>已推荐到</td>
                        <td>操作</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="article" items="${list}">
                        <c:choose>
                            <c:when test="${article.recommendType eq 0}"><tr class="recommendPool"></c:when>
                            <c:when test="${article.recommendChannel gt 1 && article.springBreezeRecommend eq 0 }"><tr class="recommendChannel"></c:when>
                            <c:when test="${article.springBreezeRecommend eq 0 && article.recommendChannel lt 1}"><tr></c:when>
                            <c:otherwise><tr class="recommendSpringBreeze"></c:otherwise>
                        </c:choose>
                            <td><input type="checkbox" name="selectArticle" value="${article.id}"/>
                            </td>
                            <c:if test="${sessionScope.admin.level>=10}"><td>${article.id}</td></c:if>
                            <td>${article.level}</td>
                            <td>${article.score}</td>
                                <%--<td<c:out value="${article.recommend?' style=color:#B94A48;':''}"/>>${article.title}</td>--%>
                            <td><a href="/article/show?location=${location}&articleId=${article.id}" target="_blank">
                                <c:choose>
                                    <c:when test="${fn:length(article.title)>40}">
                                        ${fn:substring(article.title,0 ,39 )}...
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${fn:length(article.title)>0 }">
                                                ${article.title}
                                            </c:when>
                                            <c:otherwise>
                                                暂无标题
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                                <c:if test="${!(article.picType eq 'onlyText')}"><img
                                        src="../static/img/picicon.gif"></c:if>
                            </a></td>
                            <td>${article.viewCount}</td>
                                <%--<td>${article.keyword}</td>--%>
                            <td>
                                <a href="/article/list?channelId=${article.channelId}&recommend=1">${article.channelName}</a>
                            </td>
                                <%--<td>暂无主题</td>--%>
                            <td><a href="/source/articles?sourceId=${article.sourceId}">${article.sourceName}</a></td>
                            <td>${article.createdAt}</td>
                                <%--<td>小抓</td>--%>
                                <%--<td>某人</td>--%>
                            <td>${channelMap[article.recommendChannel]}
                            <c:if test="${article.springBreezeRecommend eq 1}">全局</c:if>
                            </td>
                            <td class="tooltip-demo">
                                <div class="btn-group">

                                    <a href="/article/edit?articleId=${article.id}&location=${location}"
                                       rel="tooltip" title="编辑"><i
                                            class="icon-edit"></i></a>
                                    <c:choose>
                                        <c:when test="${article.commentFlag eq 0}">
                                            <a href="/article/speech?articleId=${article.id}&speechFlag=1&location=${location}"
                                               rel="tooltip"
                                               title="禁评"><i class="icon-ban-circle"></i></a></c:when>
                                        <c:otherwise>
                                            <a href="/article/speech?articleId=${article.id}&speechFlag=0&location=${location}"
                                               rel="tooltip"
                                               title="可评"><i class="icon-ok"></i></a></c:otherwise>
                                    </c:choose>
                                    <c:if test="${recommend>0&&recommendType!=0}">
                                        <a href="/article/unRecommend?articleId=${article.id}&channelId=${channelId}&bestFlag=${bestFlag}&location=${location}"
                                           rel="tooltip" title="取消推荐"><i
                                                class="icon-thumbs-down"></i></a>
                                    </c:if>
                                    <a href="/article/delArticle?articleId=${article.id}&location=${location}"
                                       rel="tooltip" title="删除"><i
                                            class="icon-trash"></i></a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="page">${pageHtml}</div>
                <%--<c:if test="${bestFlag != 1||recommend != 1}">--%>
                    <div class="well form-inline choose">
                        <c:if test="${bestFlag != 1||recommend !=1||recommendType==0}">
                        <label class="checkbox inline">
                            <input type="checkbox" value="1" name="recommendType">全局精选
                        </label>
                        </c:if>
                        <%--<c:if test="${channelId > 0&&recommend != 1}">--%>
                            <label class="checkbox inline">
                                <input type="checkbox" value="2" name="recommendType" checked="checked">频道精选
                            </label> <select name="channelId">
                            <c:forEach var="channel" items="${channels}">
                                <option value="${channel.id}" <c:out
                                        value="${channel.id eq channelId?'selected=\"selected\"':''}"/> />
                                ${channel.name}</option>
                            </c:forEach>
                        </select>
                        <%--</c:if>--%>
                        <input type="submit" class="btn btn-primary" value="提交">
                    </div>
                <%--</c:if>--%>
            </form>
        </div>
    </div>
    <jsp:include page="../common/message.jsp"/>
</div>
<%--<jsp:include page="include/modal.jsp"/>--%>
</div>
<script type="text/javascript">
    $(function () {
        $("#datepicker").datepicker();
        $("#datepicker2").datepicker();
    });
    function recommend(x) {
        search.recommendType.value = -99;
        search.recommend.value = x;
        search.submit();
    }

    function recommendType(x) {
        search.recommendType.value = x;
        search.recommend.value = 1;
        search.submit();
    }


    function form_sub(x) {
        if (-99 == x) {
            search.bestFlag.value = '1';
            search.channelId.value = '-99';
        } else {
            search.bestFlag.value = '0';
            search.channelId.value = x;
        }
        search.submit();
    }
    $("#checkAll").click(function () {
        if ($(this).attr("checked") != undefined) {
            $("tbody input:checkbox").attr("checked", "checked");
        }else{
            $("tbody input:checkbox").removeAttr("checked");
        }
    });

</script>
</body>
</html>