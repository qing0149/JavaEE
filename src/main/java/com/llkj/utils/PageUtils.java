package com.llkj.utils;


import java.util.List;

//分页工具类
public class PageUtils<T> {
    private Integer pageIndex;//当前页码
    private Integer pageSize= Data.PAGESIZE;//每页显示条数（实际开发中对于常量值有两种处理方案：1.使用接口 2.使用枚举）
    private Integer totalCount;//总条数
    private Integer totalPages;//总页数
    private List<T> dataList;//存储分页查询的数据集合

    public Integer getPageIndex() {
        System.out.println("getpageIndex()");
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        System.out.println("getpagesize()");
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        System.out.println("getTotalCount()");
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        System.out.println("getTotalPages()");
        return totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getDataList() {
        System.out.println("getDataList()");
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}