package s.s.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import s.s.dtos.ProductDto;
import s.s.models.Product;
import s.s.repos.CategoryRepo;
import s.s.repos.ChildcatRepo;
import s.s.repos.ProductRepo;
import s.s.repos.SubcatRepo;
import s.s.repos.TagRepo;
import s.s.services.ImageUploadService;
import s.s.services.ProductService;

@Service
public class ProductImpl implements ProductService {

   private ImageUploadService imageUploadService;
   private CategoryRepo categoryRepo;
   private SubcatRepo subcatRepo;
   private ChildcatRepo childcatRepo;
   private TagRepo tagRepo;
   private ProductRepo productRepo;

   public ProductImpl(ImageUploadService imageUploadService, CategoryRepo categoryRepo, SubcatRepo subcatRepo,
         ChildcatRepo childcatRepo, TagRepo tagRepo, ProductRepo productRepo) {
      this.imageUploadService = imageUploadService;
      this.categoryRepo = categoryRepo;
      this.subcatRepo = subcatRepo;
      this.childcatRepo = childcatRepo;
      this.tagRepo = tagRepo;
      this.productRepo = productRepo;

   }

   @Override
   public String save(ProductDto productDto) {
      Product product = new Product();
      product.setName(productDto.getName());
      product.setImages(imageUploadService.saveFiles(productDto.getFiles()));
      product.setBrand(productDto.getBrand());
      product.setPrice(productDto.getPrice());
      product.setCategory(categoryRepo.findById(productDto.getCatId()).orElse(null));
      product.setSubcat(subcatRepo.findById(productDto.getSubcatId()).orElse(null));
      product.setChildcat(childcatRepo.findById(productDto.getChildcatId()).orElse(null));
      product.setTag(tagRepo.findById(productDto.getTagId()).orElse(null));
      productRepo.save(product);
      return "Category Saved";
   }

   @Override
   public Product get(int id) {
      return productRepo.findById(id).orElse(null);
   }

   @Override
   public List<Product> all() {
      return productRepo.findAll();
   }

   @Override
   public String update(int id, ProductDto productDto) {
      Product product = productRepo.findById(id).orElse(null);
      product.setName(productDto.getName());
      product.setImages(imageUploadService.saveFiles(productDto.getFiles()));
      product.setBrand(productDto.getBrand());
      product.setPrice(productDto.getPrice());
      product.setCategory(categoryRepo.findById(productDto.getCatId()).orElse(null));
      product.setSubcat(subcatRepo.findById(productDto.getSubcatId()).orElse(null));
      product.setChildcat(childcatRepo.findById(productDto.getChildcatId()).orElse(null));
      product.setTag(tagRepo.findById(productDto.getTagId()).orElse(null));
      productRepo.save(product);
      return "Success";
   }

   @Override
   public String drop(int id) {
      Product product = productRepo.findById(id).orElse(null);
      productRepo.delete(product);
      return "Dropped";
   }
}
