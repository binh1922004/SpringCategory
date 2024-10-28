package hcmute.com.SpringCRUD.controller;


import hcmute.com.SpringCRUD.entity.Category;
import hcmute.com.SpringCRUD.service.imp.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

        @Autowired
        CategoryService categoryService;
        @GetMapping
        public String getAll(ModelMap modelMap){
                List<Category> list = categoryService.findAll();
                System.out.println(list.size());
                modelMap.addAttribute("list", list);
                return "index";
        }

        @GetMapping("/signup")
        public String signup(Category category, ModelMap modelMap){
                modelMap.addAttribute("category", category);
                return "CRUD/category_add";
        }

        @PostMapping("/add")
        public String add(@Valid Category category, BindingResult result, Model model){
//                if (result.hasErrors()) {
//
//                        return "CRUD/category_add";
//                }
                System.out.println("Go here");
                categoryService.save(category);
                return "redirect:/categories";
        }
}
