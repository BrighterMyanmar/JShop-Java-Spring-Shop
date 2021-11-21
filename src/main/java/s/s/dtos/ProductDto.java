package s.s.dtos;


import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
   int id;
   String name;
   MultipartFile files[];
   String brand;
   int price;
   int catId;
   int subcatId;
   int childcatId;
   int tagId;

   public ProductDto() {
   }

   public ProductDto(int id, String name, MultipartFile files[], String brand, int price, int catId, int subcatId,
         int childcatId, int tagid) {
      this.id = id;
      this.name = name;
      this.files = files;
      this.brand = brand;
      this.price = price;
      this.catId = catId;
      this.subcatId = subcatId;
      this.childcatId = childcatId;
      this.tagId = tagid;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public MultipartFile[] getFiles() {
      return this.files;
   }

   public void setFiles(MultipartFile[] files) {
      this.files = files;
   }

   public String getBrand() {
      return this.brand;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public int getPrice() {
      return this.price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getCatId() {
      return this.catId;
   }

   public void setCatId(int catId) {
      this.catId = catId;
   }

   public int getSubcatId() {
      return this.subcatId;
   }

   public void setSubcatId(int subcatId) {
      this.subcatId = subcatId;
   }

   public int getChildcatId() {
      return this.childcatId;
   }

   public void setChildcatId(int childcatId) {
      this.childcatId = childcatId;
   }

   public int getTagId() {
      return this.tagId;
   }

   public void setTagId(int tagId) {
      this.tagId = tagId;
   };

}
