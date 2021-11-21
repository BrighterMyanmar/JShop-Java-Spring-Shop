package s.s.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import s.s.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
