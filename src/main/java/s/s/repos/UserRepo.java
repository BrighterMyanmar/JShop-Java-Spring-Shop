package s.s.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import s.s.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
   User findByPhone(String phone);
}
