package s.s.services;

import java.util.List;

import org.springframework.stereotype.Service;

import s.s.dtos.ChildcatDto;
import s.s.models.Childcat;
@Service
public interface ChildcatService {
   String save(ChildcatDto childcatDto);

   List<Childcat> all();

   Childcat get(int id);

   String update(int id, ChildcatDto childcatDto);

   String drop(int id);
}
