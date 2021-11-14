package s.s.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import s.s.dtos.SubcatDto;
import s.s.models.Subcat;
import s.s.repos.CategoryRepo;
import s.s.repos.SubcatRepo;
import s.s.services.ImageUploadService;
import s.s.services.SubcatService;

@Service
public class SubcatImpl implements SubcatService {

   private SubcatRepo subcatRepo;
   private CategoryRepo categoryRepo;
   private ImageUploadService imageUploadService;

   public SubcatImpl(SubcatRepo subcatRepo, CategoryRepo categoryRepo, ImageUploadService imageUploadService) {
      this.subcatRepo = subcatRepo;
      this.categoryRepo = categoryRepo;
      this.imageUploadService = imageUploadService;
   }

   @Override
   public String save(SubcatDto subcatDto) {
      Subcat subcat = new Subcat();
      subcat.setName(subcatDto.getName());
      subcat.setCategory(categoryRepo.findById(subcatDto.getCatId()).orElse(null));
      subcat.setImage(imageUploadService.saveFile(subcatDto.getFile()));
      subcatRepo.save(subcat);
      return "success";
   }

   @Override
   public Subcat get(int id) {
      return subcatRepo.findById(id).orElse(null);
   }

   @Override
   public List<Subcat> all() {
      return subcatRepo.findAll();
   }

   @Override
   public String update(int id, SubcatDto subcatDto) {
      Subcat subcat = subcatRepo.findById(id).orElse(null);
      subcat.setName(subcatDto.getName());
      subcat.setCategory(categoryRepo.findById(subcatDto.getCatId()).orElse(null));
      subcat.setImage(imageUploadService.saveFile(subcatDto.getFile()));
      subcatRepo.save(subcat);
      return "Updated";
   }

   @Override
   public String drop(int id) {
      Subcat subcat = subcatRepo.findById(id).orElse(null);
      subcatRepo.delete(subcat);
      return "Deleted";
   }

}
