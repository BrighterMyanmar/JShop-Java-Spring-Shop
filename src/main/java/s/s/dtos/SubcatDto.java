package s.s.dtos;

import org.springframework.web.multipart.MultipartFile;

public class SubcatDto {
   String name;
   int catId;
   MultipartFile file;

   public SubcatDto() {
   }

   public SubcatDto(String name, int catId, MultipartFile file) {
      this.name = name;
      this.catId = catId;
      this.file = file;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getCatId() {
      return this.catId;
   }

   public void setCatId(int catId) {
      this.catId = catId;
   }

   public MultipartFile getFile() {
      return this.file;
   }

   public void setFile(MultipartFile file) {
      this.file = file;
   }

}
