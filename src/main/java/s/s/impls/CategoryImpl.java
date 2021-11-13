package s.s.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import s.s.dtos.CategoryDto;
import s.s.models.Category;
import s.s.repos.CategoryRepo;
import s.s.services.CategoryService;
import s.s.services.ImageUploadService;

@Service
public class CategoryImpl implements CategoryService {

   private CategoryRepo catRepo;
   private ImageUploadService imageUploadService;

   public CategoryImpl(CategoryRepo catRepo, ImageUploadService imageUploadService) {
      this.catRepo = catRepo;
      this.imageUploadService = imageUploadService;
   }

   @Override
   public String save(CategoryDto categoryDto) {
      Category category = new Category();
      category.setName(categoryDto.getName());
      category.setImage(imageUploadService.saveFile(categoryDto.getFile()));
      catRepo.save(category);
      return "Success";
   }

   @Override
   public List<Category> all() {
      return catRepo.findAll();
   }

   @Override
   public Category get(int id) {
      return catRepo.findById(id).orElse(null);
   }

   @Override
   public String update(int id, CategoryDto categoryDto) {
      Category category = catRepo.findById(id).orElse(null);

      category.setName(categoryDto.getName());
      System.out.println(category.getId());
      System.out.println("Image name is " + categoryDto.getFile().getOriginalFilename());
      category.setImage(imageUploadService.saveFile(categoryDto.getFile()));
      catRepo.save(category);
      return "Updated";
   }

   @Override
   public String drop(int id) {
      Category category = catRepo.findById(id).orElse(null);
      catRepo.delete(category);
      return "Deleted";
   }

}
