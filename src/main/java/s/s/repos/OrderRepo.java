package s.s.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import s.s.models.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {

}
