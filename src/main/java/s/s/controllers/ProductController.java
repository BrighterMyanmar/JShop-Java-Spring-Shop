package s.s.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import s.s.dtos.ProductDto;
import s.s.services.CategoryService;
import s.s.services.ChildcatService;
import s.s.services.ProductService;
import s.s.services.SubcatService;
import s.s.services.TagService;

@Controller
@RequestMapping("/products")
public class ProductController {

   @Autowired
   ProductService productService;
   @Autowired
   CategoryService categoryService;
   @Autowired
   SubcatService subcatService;
   @Autowired
   ChildcatService childcatService;
   @Autowired
   TagService tagService;

   @GetMapping
   public String home(Model model) {
      model.addAttribute("products", productService.all());
      return "products/index";
   }

   @GetMapping("/create")
   public String create(Model model) {
      model.addAttribute("cats", categoryService.all());
      model.addAttribute("subs", subcatService.all());
      model.addAttribute("childs", childcatService.all());
      model.addAttribute("tags", tagService.all());
      return "products/create";
   }

   @PostMapping("/save")
   public String save(@ModelAttribute ProductDto productDto) {
      productService.save(productDto);
      return "redirect:";
   }

   @GetMapping("/edit/{id}")
   public String edit(@PathVariable("id") int id, Model model) {
      model.addAttribute("cats", categoryService.all());
      model.addAttribute("subs", subcatService.all());
      model.addAttribute("childs", childcatService.all());
      model.addAttribute("tags", tagService.all());
      model.addAttribute("product", productService.get(id));
      return "products/edit";
   }

   @PostMapping("/update/{id}")
   public String update(@PathVariable("id") int id, @ModelAttribute ProductDto productDto) {
      productService.update(id, productDto);
      return "redirect:/products";
   }

}
