package s.s.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import s.s.dtos.UserDto;
import s.s.models.User;

@Service
public interface UserService extends UserDetailsService {

   String register(UserDto userDto);

   User getUserByName(String username);

}
