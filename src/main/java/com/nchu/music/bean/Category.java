package com.nchu.music.bean;

/**
 * @ClassName Category
 * @Description 歌曲类别类
 * @Author Lement
 * @Date 2019/9/12 15:19
 */
public class Category {
    private int categoryId;
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
