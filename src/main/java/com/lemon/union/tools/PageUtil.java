package com.lemon.union.tools;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhouwang
 * Date: 12-8-30
 * Time: 下午6:08
 * To change this template use File | Settings | File Templates.
 */
public class PageUtil {
    public static <E> Page<E> getPage(int totalCount,int pageNum,List<E> items,int pageSize){
         Page<E> page=new Page<E>();
        page.setItems(items);
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setPageNum(pageNum>page.getPageCount()?1:pageNum);
        page.setHasNext(page.getPageNum()<page.getPageCount());
        page.setHasPre(page.getPageNum()>1);
        return page;
    }
    public static String toPageHtml(Page page, String uri, String query) {
        String start = uri + "?pageNum=";
        String end = "";
        int total = page.getPageCount();

        if (null != query && !"".equals(query.trim())) {
            query=UrlUtil.delNumParam(query,"pageNum");
            query=UrlUtil.delNumParam(query,"message");
            if (!"".equals(query.trim())) {
                end = "&" + query;
            }
        }
        StringBuilder res = new StringBuilder();
        res.append("<p><span>第").append(page.getPageNum()).append("页, 共").append(total).append("页 │总").append(page.getTotalCount()).append("条");
        if (page.isHasPre()) {
            res.append(" | <a href=\"").append(start).append("1").append(end).append("\">首页</a>");
            res.append(" | <a href=\"").append(start).append(page.getPageNum() - 1).append(end).append("\">上一页</a>");
        }else{
            res.append(" | 首页");
            res.append(" | 上一页");
        }
        if (page.isHasNext()) {
            res.append(" | <a href=\"").append(start).append(page.getPageNum() + 1).append(end).append("\">下一页</a>");
            res.append(" | <a href=\"").append(start).append(total).append(end).append("\">末页</a>");
        }else{
            res.append(" | 下一页");
            res.append(" | 末页");
        }
        res.append(" │ 转到第<select onchange=\"javascript:location='").append(start).append("'+this.value+'").append(end).append("'\">");
        for (int i = 1; i <= total; i++) {
            res.append("<option");
            if (i == page.getPageNum()) {
                res.append(" selected=\"selected\"");
            }
            res.append(" value=\"").append(i).append("\">").append(i).append("</option>");
        }
        res.append("</select>页</span></p>");
        return res.toString();
    }
}
