package s.s.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import s.s.models.Childcat;

@Repository
public interface ChildcatRepo extends JpaRepository<Childcat, Integer> {

}
