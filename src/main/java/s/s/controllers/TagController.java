package s.s.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import s.s.dtos.TagDto;
import s.s.services.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/tags")
public class TagController {
   @Autowired
   TagService tagService;

   @GetMapping
   public String home(Model model) {
      model.addAttribute("tags", tagService.all());
      return "tags/index";
   }

   @GetMapping("/create")
   public String create() {
      return "tags/create";
   }

   @PostMapping("/save")
   public String save(@ModelAttribute TagDto tagDto) {
      tagService.save(tagDto);
      return "redirect:";
   }

   @GetMapping("/edit/{id}")
   public String edit(@PathVariable("id") int id, Model model) {
      model.addAttribute("tag", tagService.get(id));
      return "tags/edit";
   }

   @PostMapping("/update/{id}")
   public String update(@PathVariable("id") int id, @ModelAttribute TagDto tagDto) {
      tagService.update(id, tagDto);
      return "redirect:/tags";
   }

   @GetMapping("/drop/{id}")
   public String drop(@PathVariable("id") int id) {
      tagService.drop(id);
      return "redirect:/tags";
   }

}
