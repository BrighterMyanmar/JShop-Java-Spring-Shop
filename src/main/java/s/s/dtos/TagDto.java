package s.s.dtos;

import org.springframework.web.multipart.MultipartFile;

public class TagDto {
   String name;
   MultipartFile file;

   public TagDto() {
   }

   public TagDto(String name, MultipartFile file) {
      this.name = name;
      this.file = file;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public MultipartFile getFile() {
      return this.file;
   }

   public void setFile(MultipartFile file) {
      this.file = file;
   }

}
