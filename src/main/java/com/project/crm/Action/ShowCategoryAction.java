package com.project.crm.Action;

import com.project.crm.model.Category;
import com.project.crm.model.Supercategory;
import com.project.crm.services.impl.CategoryServiceImpl;
import com.project.crm.services.impl.SupercategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@SessionAttributes(value="categoryJSP")
public class ShowCategoryAction {

    @RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
    public ModelAndView main(@ModelAttribute Supercategory supercategory) {

        ModelAndView modelAndView = new ModelAndView();
        List<Supercategory> supercategoryList = null;
        supercategoryList = SupercategoryServiceImpl.getInstance().getAllSypercategories();


        modelAndView.addObject("categoryJSP", supercategoryList);
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

}
