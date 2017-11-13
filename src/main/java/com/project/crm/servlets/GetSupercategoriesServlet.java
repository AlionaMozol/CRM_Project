package com.project.crm.servlets;

import com.project.crm.model.Supercategory;
import com.project.crm.services.impl.SupercategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.json.*;

@WebServlet("/GetSupercategoriesServlet")
public class GetSupercategoriesServlet extends HttpServlet {

    private SupercategoryServiceImpl supercategoryService = SupercategoryServiceImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Supercategory> supercategories = supercategoryService.getAllSypercategories();
            JSONArray jsonArray = new JSONArray();
            for (Supercategory item : supercategories) {
                jsonArray.put(item.getTitle());
            }
            String forResponse = jsonArray.toString();

            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().write(forResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
