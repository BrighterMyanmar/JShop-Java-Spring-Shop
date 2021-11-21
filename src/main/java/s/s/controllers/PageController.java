package s.s.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import s.s.services.ProductService;

@Controller
public class PageController {
   @Autowired
   ProductService productService;

   @GetMapping
   public String home(Model model) {
      model.addAttribute("products", productService.all());
      return "index"; // index.html
   }

}
