package s.s.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import s.s.models.Product;
import s.s.services.ProductService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/orders")
public class OrdersController {
   @Autowired
   ProductService productService;

   @PostMapping
   public String saveString(@RequestParam String orderitems) { // 1,8,5
      String[] items = orderitems.split(",");
      List<Product> products = new ArrayList<>();
      for (String item : items) {
         int id = Integer.parseInt(item);
         Product product = productService.get(id);
         System.out.println(product.getName());
         products.add(product);
      }
      System.out.println("There are " + products.size() + " products");
      return "orders/index";
   }

}
