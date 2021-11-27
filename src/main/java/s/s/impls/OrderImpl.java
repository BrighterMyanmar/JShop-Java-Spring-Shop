package s.s.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import s.s.dtos.OrderDto;
import s.s.models.OrderItem;
import s.s.models.Orders;
import s.s.models.Product;
import s.s.repos.OrderItemRepo;
import s.s.repos.OrderRepo;
import s.s.services.OrderService;
import s.s.services.ProductService;

@Service
public class OrderImpl implements OrderService {

   private OrderRepo orderRepo;
   private OrderItemRepo orderItemRepo;
   private ProductService productService;

   public OrderImpl(OrderRepo orderRepo, OrderItemRepo orderItemRepo, ProductService productService) {
      this.orderRepo = orderRepo;
      this.orderItemRepo = orderItemRepo;
      this.productService = productService;
   }

   @Override
   public String save(OrderDto orderDto) {
      Orders orders = new Orders();

      List<OrderItem> orderItems = new ArrayList<>();

      String[] items = orderDto.getOrderItems().split(",");
      int total = 0;
      for (String item : items) {
         int id = Integer.parseInt(item);
         Product product = productService.get(id);
         total += product.getPrice();
         OrderItem orderItem = new OrderItem();
         orderItem.setCount(2);
         orderItem.setPrice(product.getPrice());
         orderItem.setProduct(product);
         orderItems.add(orderItem);
      }

      orders.setCount(orderItems.size());
      orders.setTotal(total);
      orders.setOrderItems(orderItems);
      orderRepo.save(orders);

      return "success";
   }

   @Override
   public Orders get(int id) {
      return orderRepo.findById(id).orElse(null);
   }

   @Override
   public List<Orders> all() {
      return orderRepo.findAll();
   }

}
