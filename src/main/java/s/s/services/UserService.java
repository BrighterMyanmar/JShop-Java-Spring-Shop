package s.s.services;

import org.springframework.stereotype.Service;

import s.s.dtos.UserDto;

@Service
public interface UserService {

   String register(UserDto userDto);

}
