package s.s.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import s.s.models.Subcat;

@Repository
public interface SubcatRepo extends JpaRepository<Subcat, Integer> {

}
