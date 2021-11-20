package s.s.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import s.s.models.Tag;

@Repository
public interface TagRepo extends JpaRepository<Tag, Integer> {

}
