package s.s.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import s.s.dtos.OrderDto;
import s.s.models.User;
import s.s.services.OrderService;
import s.s.services.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/orders")
public class OrdersController {
   @Autowired
   OrderService orderService;
   @Autowired
   UserService userService;

   @PostMapping
   public String saveString(@ModelAttribute OrderDto orderDto) { // 1,8,5

      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      String username = "";
      if (principal instanceof UserDetails) {
         username = ((UserDetails) principal).getUsername();
      } else {
         username = principal.toString();
      }
      User user = userService.getUserByName(username);
      orderDto.setUserId(user.getId());
      orderService.save(orderDto);
      return "orders/index";
   }

}

// String[] items = orderitems.split(",");
// List<Product> products = new ArrayList<>();
// for (String item : items) {
// int id = Integer.parseInt(item);
// Product product = productService.get(id);
// System.out.println(product.getName());
// products.add(product);
// }
// System.out.println("There are " + products.size() + " products");
