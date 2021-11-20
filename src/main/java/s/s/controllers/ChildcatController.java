package s.s.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import s.s.dtos.ChildcatDto;
import s.s.services.ChildcatService;
import s.s.services.SubcatService;

@Controller
@RequestMapping("/childcats")
public class ChildcatController {
   @Autowired
   ChildcatService childcatService;
   @Autowired
   SubcatService subcatService;

   @GetMapping
   public String home(Model model) {
      model.addAttribute("childcats", childcatService.all());
      return "childcats/index";
   }

   @GetMapping("/create")
   public String create(Model model) {
      model.addAttribute("subs", subcatService.all());
      return "/childcats/create";
   }

   @PostMapping("/save")
   public String save(@ModelAttribute ChildcatDto childcatDto) {
      childcatService.save(childcatDto);
      return "redirect:";
   }

   @GetMapping("/edit/{id}")
   public String edit(@PathVariable("id") int id, Model model) {
      model.addAttribute("subs", subcatService.all());
      model.addAttribute("childcat", childcatService.get(id));
      return "/childcats/edit";
   }

   @PostMapping("/update/{id}")
   public String update(@PathVariable("id") int id, @ModelAttribute ChildcatDto childcatDto) {
      childcatService.update(id, childcatDto);
      return "redirect:/childcats";
   }

   @GetMapping("/drop/{id}")
   public String drop(@PathVariable("id") int id) {
      childcatService.drop(id);
      return "redirect:/childcats";
   }

}
