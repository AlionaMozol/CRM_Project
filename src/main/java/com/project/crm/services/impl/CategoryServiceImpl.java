package com.project.crm.services.impl;

import com.project.crm.dao.CategoryDao;
import com.project.crm.model.Category;
import com.project.crm.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategoriesByTopCategory(String category) {
        return categoryDao.getCategoriesByTopCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public List<Category> getAllTopCategories() {
        return categoryDao.getAllTopCategories();
    }

    @Override
    public Map<Category, List<Category>> getTopCategoriesWithSubCategory() {
        Map<Category, List<Category>> categoryMap=new HashMap<>();
        List<Category> topCatigoriesList = categoryDao.getAllTopCategories();
        for(Category category:topCatigoriesList) {
            List<Category>subcategories=categoryDao.getCategoriesByTopCategory(category.getTitle());
            //category.setSubcategory(subcategories);
            categoryMap.put(category,subcategories);
        }
        return categoryMap;
    }

    public static void main(String [] args)  {

        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        Map<Category,List<Category>> categoryMap;
        categoryMap=categoryService.getTopCategoriesWithSubCategory();


        /*List<Category> topCategotiesList = new ArrayList<Category>();
        topCategotiesList=categoryDao.getAllCategories();
        Category category = new Category();
        category.setTitle("Fashion");
        topCategotiesList=categoryDao.getCategoriesByTopCategory(category);
        for (int i=0; i<topCategotiesList.size(); i++){

            System.out.println(topCategotiesList.get(i).getTitle());

        }

        for (int i=0; i<topCategotiesList.size(); i++){
            if (topCategotiesList.get(i).getSupercategory()!=null)
                System.out.println(topCategotiesList.get(i).getTitle()+" "+topCategotiesList.get(i).getSupercategory().getTitle()+ " "+ topCategotiesList.get(i).isTop());
            else{
                System.out.println(topCategotiesList.get(i).getTitle()+topCategotiesList.get(i).isTop());

            }*/
        }
}
