package s.s.services;

import java.util.List;

import org.springframework.stereotype.Service;

import s.s.dtos.TagDto;
import s.s.models.Tag;

@Service
public interface TagService {

   String save(TagDto tagDto);

   Tag get(int id);

   List<Tag> all();

   String update(int id, TagDto tagDto);

   String drop(int id);

}
