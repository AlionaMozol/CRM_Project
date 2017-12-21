package com.project.crm.junit;

/**
 * Created by 1 on 02.12.2017.
 */
public class categoryDaoImplTest {
    /*@Test
    public void getAllTopCategoriesTest(){
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        Category subCategory1 = new Category();
        subCategory1.setTop(true);
        subCategory1.setTitle("shoes");

        Category topCategory1 = new Category();
        topCategory1.setTop(true);
        topCategory1.setTitle("Fashion");

        Category topCategory2 = new Category();
        topCategory2.setTop(true);
        topCategory2.setTitle("Fashion");

        List<Category> topCategotiesList =categoryDao.getAllTopCategories();
        Category category = new Category();
        for (int i=0; i<topCategotiesList.size(); i++){
            Assert.assertTrue(topCategotiesList.get(i).isTop());
        }
        List<Category> CategotiesList =categoryDao.getCategoriesByTopCategory("Fashion");

        for (int i=0; i<CategotiesList.size(); i++){

            System.out.println(CategotiesList.get(i).getTitle());

        }

        /*for (int i=0; i<topCategotiesList.size(); i++){
            if (topCategotiesList.get(i).getSupercategory()!=null)
                System.out.println(topCategotiesList.get(i).getTitle()+" "+topCategotiesList.get(i).getSupercategory().getTitle()+ " "+ topCategotiesList.get(i).isTop());
            else{
                System.out.println(topCategotiesList.get(i).getTitle()+topCategotiesList.get(i).isTop());

            }
        }}
    }*/
}
