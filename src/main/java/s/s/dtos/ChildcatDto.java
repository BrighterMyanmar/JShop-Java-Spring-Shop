package s.s.dtos;

import org.springframework.web.multipart.MultipartFile;

public class ChildcatDto {
   String name;
   MultipartFile file;
   int subcatId;

   public ChildcatDto() {
   }

   public ChildcatDto(String name, MultipartFile file, int subcatId) {
      this.name = name;
      this.file = file;
      this.subcatId = subcatId;
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

   public int getSubcatId() {
      return this.subcatId;
   }

   public void setSubcatId(int subcatId) {
      this.subcatId = subcatId;
   }

}
