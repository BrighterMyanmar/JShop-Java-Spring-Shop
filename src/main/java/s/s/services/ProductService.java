package s.s.services;

import java.util.List;

import org.springframework.stereotype.Service;

import s.s.dtos.ProductDto;
import s.s.models.Product;

@Service
public interface ProductService {
   String save(ProductDto productDto);

   Product get(int id);

   List<Product> all();

   String update(int id, ProductDto productDto);

   String drop(int id);
}
