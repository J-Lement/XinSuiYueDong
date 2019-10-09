package com.nchu.music.service.serviceImpl.songManageServiceImpl;

import com.nchu.music.bean.Category;
import com.nchu.music.dao.songManageDao.DemoCategory;
import com.nchu.music.service.songManageService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @time
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public DemoCategory demoCategory;


    @Override
    public int insertCategory(Category category) {
        return demoCategory.insertCategory (category);
    }

    @Override
    public List<Category> queryAllCategory() {
        return demoCategory.queryAllCategory ();
    }

    @Override
    public int updateCategory(Category category) {
        return demoCategory.updateCategory (category);
    }

    @Override
    public int deleteCategory(Integer categoryId) {
        return demoCategory.deleteCategory (categoryId);
    }

    @Override
    public Category findById(Integer categoryId) {
        return demoCategory.findById (categoryId);
    }
}
