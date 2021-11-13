package s.s.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import s.s.dtos.CategoryDto;
import s.s.services.CategoryService;

@Controller
@RequestMapping("/cats")
public class CategoryController {

   @Autowired
   CategoryService catService;

   @GetMapping
   public String home(Model model) {
      model.addAttribute("cats", catService.all());
      return "cats/index"; // cat/index.html
   }

   @GetMapping("/create")
   public String create() {
      return "/cats/create";
   }

   @PostMapping("/save")
   public String save(@ModelAttribute CategoryDto categoryDto) {
      catService.save(categoryDto);
      return "redirect:";
   }

   @GetMapping("/edit/{id}")
   public String edit(@PathVariable("id") int id, Model model) {
      model.addAttribute("cat", catService.get(id));
      return "/cats/edit";
   }

   @PostMapping("/update/{id}")
   public String update(@PathVariable("id") int id, @ModelAttribute CategoryDto categoryDto) {
      catService.update(id, categoryDto);
      return "redirect:/cats";
   }

   @GetMapping("/drop/{id}")
   public String drop(@PathVariable("id") int id) {
      catService.drop(id);
      return "redirect:/cats";
   }
}
