package s.s.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
   String name;
   String images;
   String brand;
   int price;

   @ManyToOne
   Category category;
   @ManyToOne
   Subcat subcat;
   @ManyToOne
   Childcat childcat;
   @ManyToOne
   Tag tag;

   public Product(){}

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

   public String getImages() {
      return this.images;
   }

   public void setImages(String images) {
      this.images = images;
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

   public Category getCategory() {
      return this.category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public Subcat getSubcat() {
      return this.subcat;
   }

   public void setSubcat(Subcat subcat) {
      this.subcat = subcat;
   }

   public Childcat getChildcat() {
      return this.childcat;
   }

   public void setChildcat(Childcat childcat) {
      this.childcat = childcat;
   }

   public Tag getTag() {
      return this.tag;
   }

   public void setTag(Tag tag) {
      this.tag = tag;
   }

}
