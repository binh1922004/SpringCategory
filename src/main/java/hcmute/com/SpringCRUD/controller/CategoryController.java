package hcmute.com.SpringCRUD.controller;


import hcmute.com.SpringCRUD.entity.Category;
import hcmute.com.SpringCRUD.service.imp.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/categories")
public class CategoryController {

        @Autowired
        CategoryService categoryService;
        @GetMapping
        public String getAll(){
                return "redirect:/categories/find";
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
                return "redirect:/categories";
        }

        @GetMapping("/find")
        public String listCategory(Model model,
                                   @RequestParam("keyword") Optional<String> keyword,
                                   @RequestParam("page") Optional<Integer> page,
                                   @RequestParam("size") Optional<Integer> size){
                int currentPage = page.orElse(1);
                int pageSize = size.orElse(5);


                Page<Category> categoryPage;

                String keywordSearch = keyword.orElse("");
                if (keywordSearch.equals("")){
                        categoryPage = categoryService.paginated(PageRequest.of(currentPage - 1, pageSize));
                }
                else{
                        categoryPage = categoryService.searchKeyword(keywordSearch, PageRequest.of(currentPage - 1, pageSize));
                }

                System.out.println(categoryPage.getSize());
                model.addAttribute("categoryPage", categoryPage);
                int totalPages = categoryPage.getTotalPages();

                if (totalPages > 0){
                        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                                .boxed()
                                .collect(Collectors.toList());
                        model.addAttribute("pageNumbers", pageNumbers);
                }
                return "CRUD/category_page";
        }
}
