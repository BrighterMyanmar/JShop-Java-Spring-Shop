package s.s.services;

import java.util.List;

import org.springframework.stereotype.Service;

import s.s.dtos.CategoryDto;
import s.s.models.Category;

@Service
public interface CategoryService {

   String save(CategoryDto categoryDto);

   List<Category> all();

   Category get(int id);

   String update(int id, CategoryDto categoryDto);

   String drop(int id);

}
