package s.s.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
   String name;
   String image;

   @OneToMany
   @JoinColumn(name = "category_id")
   List<Subcat> subcats;

   public Category() {
   }

   public int getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getImage() {
      return this.image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public List<Subcat> getSubcats() {
      return this.subcats;
   }

   public void setSubcats(List<Subcat> subcats) {
      this.subcats = subcats;
   }

}
