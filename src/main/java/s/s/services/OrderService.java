package s.s.services;

import java.util.List;

import org.springframework.stereotype.Service;

import s.s.dtos.OrderDto;
import s.s.models.Orders;

@Service
public interface OrderService {
   String save(OrderDto orderDto);

   Orders get(int id);

   List<Orders> all();

}
