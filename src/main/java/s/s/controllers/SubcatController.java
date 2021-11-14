package s.s.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import s.s.dtos.SubcatDto;
import s.s.services.CategoryService;
import s.s.services.SubcatService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/subcats")
public class SubcatController {

   @Autowired
   CategoryService catService;
   @Autowired
   SubcatService subcatService;

   @GetMapping
   public String home(Model model) {
      model.addAttribute("subs", subcatService.all());
      return "subcats/index";
   }

   @GetMapping("/create")
   public String create(Model model) {
      model.addAttribute("cats", catService.all());
      return "/subcats/create";
   }

   @PostMapping("/save")
   public String save(@ModelAttribute SubcatDto subcatDto) {
      subcatService.save(subcatDto);
      return "redirect:";
   }

   @GetMapping("/edit/{id}")
   public String edit(@PathVariable("id") int id, Model model) {
      model.addAttribute("sub", subcatService.get(id));
      model.addAttribute("cats", catService.all());
      return "subcats/edit";
   }

   @PostMapping("/update/{id}")
   public String update(@PathVariable("id") int id, @ModelAttribute SubcatDto subcatDto) {
      subcatService.update(id, subcatDto);
      return "redirect:/subcats";
   }

   @GetMapping("/drop/{id}")
   public String edit(@PathVariable("id") int id) {
      subcatService.drop(id);
      return "redirect:/subcats";
   }

}
