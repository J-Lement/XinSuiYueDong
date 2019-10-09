package com.nchu.music.service.songManageService;

import com.nchu.music.bean.Category;

import java.util.List;

/**
 * @author
 * @time
 */
public interface CategoryService {

    int insertCategory(Category category);

    //查询歌曲分类数据
    List<Category> queryAllCategory();

    //更新数据
    int updateCategory(Category category);

    //删除数据
    int deleteCategory(Integer categoryId);
    //查找数据
    Category findById(Integer categoryId);
}
