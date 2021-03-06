package s.s.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Subcat {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int Id;
   String name;
   String image;

   @OneToOne
   Category category;

   @OneToMany
   @JoinColumn(name = "subcat_id")
   List<Childcat> childcats;

   public Subcat() {
   }

   public int getId() {
      return this.Id;
   }

   public void setId(int Id) {
      this.Id = Id;
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

   public Category getCategory() {
      return this.category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

}
