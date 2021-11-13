package s.s.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import s.s.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
