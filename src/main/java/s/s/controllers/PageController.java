package s.s.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import s.s.dtos.UserDto;
import s.s.services.ProductService;
import s.s.services.UserService;

@Controller
public class PageController {
   @Autowired
   ProductService productService;
   @Autowired
   UserService userService;

   @GetMapping
   public String home(Model model) {
      model.addAttribute("products", productService.all());
      return "index"; // index.html
   }

   @GetMapping("/register")
   public String register() {
      return "users/register";
   }

   @PostMapping("/register")
   public String saveUser(@ModelAttribute UserDto userDto) {
      userService.register(userDto);
      return "redirect:login";
   }

   @GetMapping("/login")
   public String login() {
      return "users/login";
   }

}
