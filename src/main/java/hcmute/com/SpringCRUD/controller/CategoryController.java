package hcmute.com.SpringCRUD.controller;


import hcmute.com.SpringCRUD.entity.Category;
import hcmute.com.SpringCRUD.service.imp.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
                return "CRUD/category_list";
        }

        @GetMapping("/signup")
        public String signup(Category category, ModelMap modelMap){
                modelMap.addAttribute("category", category);
                return "CRUD/category_add";
        }

        @PostMapping("/add")
        public String add(@Valid Category category, BindingResult result, Model model){
                if (result.hasErrors()) {
                        return "CRUD/category_add";
                }
                categoryService.save(category);
                return "redirect:/categories";
        }

        @GetMapping("/delete/{id}")
        public String delete(@PathVariable("id") long id, Model model){
                categoryService.deleteById(id);
                return "redirect:/categories";
        }

        @GetMapping("/edit/{id}")
        public String edit(@PathVariable("id") long id, Model model){
                Category category = categoryService.findById(id)
                        .orElseThrow(() -> new RuntimeException("Not found"));
                model.addAttribute("category", category);
                return "CRUD/category_update";
        }

        @PostMapping("/update/{id}")
        public String update(@PathVariable("id") long id, @Valid Category category, BindingResult result,
                             Model model){
                if (result.hasErrors()){
                        return "CRUD/category_update";
                }
                categoryService.save(category);
                return "CRUD/category_list";
        }
}
