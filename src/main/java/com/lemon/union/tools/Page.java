package com.lemon.union.tools;

import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhouwang
 * Date: 12-8-30
 * Time: 下午6:04
 * To change this template use File | Settings | File Templates.
 */
public class Page<E> {
    private boolean hasPre;//是否首页
    private boolean hasNext;//是否尾页
    private List<E> items;//当前页包含的记录列表

    public boolean isHasPre() {
        return hasPre;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<E> getItems() {
        return this.items == null ? Collections.<E>emptyList() : this.items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        int div = totalCount / pageSize;
        return (totalCount % pageSize == 0) ? div : div + 1;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    private int pageNum;//当前页页码(起始为1)
    private int pageCount;
    private int totalCount;
    private int pageSize;


}
