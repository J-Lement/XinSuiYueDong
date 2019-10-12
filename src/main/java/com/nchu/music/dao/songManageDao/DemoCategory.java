package com.nchu.music.dao.songManageDao;

import com.nchu.music.bean.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author
 * @time
 */
@Mapper
public interface DemoCategory {
    //插入数据
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

