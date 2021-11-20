package s.s.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import s.s.dtos.ChildcatDto;
import s.s.models.Childcat;
import s.s.repos.ChildcatRepo;
import s.s.repos.SubcatRepo;
import s.s.services.ChildcatService;
import s.s.services.ImageUploadService;

@Service
public class ChildcatImpl implements ChildcatService {

   private SubcatRepo subcatRepo;
   private ChildcatRepo childcatRepo;
   private ImageUploadService imageUploadService;

   public ChildcatImpl(SubcatRepo subcatRepo, ChildcatRepo childcatRepo, ImageUploadService imageUploadService) {
      this.subcatRepo = subcatRepo;
      this.childcatRepo = childcatRepo;
      this.imageUploadService = imageUploadService;
   }

   @Override
   public String save(ChildcatDto childcatDto) {
      Childcat childcat = new Childcat();
      childcat.setName(childcatDto.getName());
      childcat.setImage(imageUploadService.saveFile(childcatDto.getFile()));
      childcat.setSubcat(subcatRepo.findById(childcatDto.getSubcatId()).orElse(null));
      childcatRepo.save(childcat);
      return null;
   }

   @Override
   public List<Childcat> all() {
      return childcatRepo.findAll();
   }

   @Override
   public Childcat get(int id) {
      return childcatRepo.findById(id).orElse(null);
   }

   @Override
   public String update(int id, ChildcatDto childcatDto) {
      Optional<Childcat> opChildcat = childcatRepo.findById(id);
      if (opChildcat.isPresent()) {
         Childcat childcat = opChildcat.get();
         childcat.setName(childcatDto.getName());
         childcat.setImage(imageUploadService.saveFile(childcatDto.getFile()));
         childcat.setSubcat(subcatRepo.findById(childcatDto.getSubcatId()).orElse(null));
         childcatRepo.save(childcat);
         return "Success";
      }
      return "Fail";
   }

   @Override
   public String drop(int id) {
      Optional<Childcat> opChildcat = childcatRepo.findById(id);
      if (opChildcat.isPresent()) {
         Childcat childcat = opChildcat.get();
         childcatRepo.delete(childcat);
         return "Success";
      }
      return "Fail";
   }

}
