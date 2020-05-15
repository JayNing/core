package com.dynamic.code.model;

import java.util.List;

/**
 * 分页查询返回的单页数据
 *
 * @author hawods
 * @version 2018-02-28
 */
public class PageModel<T> extends BaseModel {
    private List<T> content;
    private int pageNum = 1;
    private int pageSize = 20;
    private long totalElements;
    private int pages;
    private String sort;

    public PageModel() {
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort=sort;
    }
}
