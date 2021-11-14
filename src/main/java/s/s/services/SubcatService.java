package s.s.services;

import java.util.List;

import org.springframework.stereotype.Service;

import s.s.dtos.SubcatDto;
import s.s.models.Subcat;

@Service
public interface SubcatService {
   String save(SubcatDto subcatDto);

   Subcat get(int id);

   List<Subcat> all();

   String update(int id, SubcatDto subcatDto);

   String drop(int id);
}
