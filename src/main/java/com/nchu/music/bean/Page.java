package com.nchu.music.bean;

/**
 * @ClassName Page
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/24 17:23
 */
public class Page {
    private Integer pageNow;
    private Integer pages;
    private Integer pageNum = 10;
    private Integer totalNum;

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
        if (totalNum % pageNum == 0)
            pages = totalNum / pageNum;
        else
            pages = totalNum / pageNum + 1;
    }
}
