package s.s.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import s.s.dtos.TagDto;
import s.s.models.Tag;
import s.s.repos.TagRepo;
import s.s.services.ImageUploadService;
import s.s.services.TagService;

@Service
public class TagImpl implements TagService {
   private TagRepo tagRepo;
   private ImageUploadService imageUploadService;

   public TagImpl(TagRepo tagRepo, ImageUploadService imageUploadService) {
      this.tagRepo = tagRepo;
      this.imageUploadService = imageUploadService;
   }

   @Override
   public String save(TagDto tagDto) {
      Tag tag = new Tag();
      tag.setName(tagDto.getName());
      tag.setImage(imageUploadService.saveFile(tagDto.getFile()));
      tagRepo.save(tag);
      return "Success";
   }

   @Override
   public Tag get(int id) {
      return tagRepo.findById(id).orElse(null);
   }

   @Override
   public List<Tag> all() {
      return tagRepo.findAll();
   }

   @Override
   public String update(int id, TagDto tagDto) {
      Tag tag = tagRepo.findById(id).orElse(null);
      tag.setName(tagDto.getName());
      tag.setImage(imageUploadService.saveFile(tagDto.getFile()));
      tagRepo.save(tag);
      return "Success";
   }

   @Override
   public String drop(int id) {
      Tag tag = tagRepo.findById(id).orElse(null);
      tagRepo.delete(tag);
      return "Success";
   }

}
