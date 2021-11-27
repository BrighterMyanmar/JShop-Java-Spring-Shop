package s.s.impls;

import org.springframework.stereotype.Service;

import s.s.dtos.UserDto;
import s.s.models.User;
import s.s.repos.UserRepo;
import s.s.services.UserService;

@Service
public class UserImpl implements UserService {

   private UserRepo userRepo;

   UserImpl(UserRepo userRepo) {
      this.userRepo = userRepo;
   }

   @Override
   public String register(UserDto userDto) {
      User existUser = userRepo.findByPhone(userDto.getPhone());
      if (existUser != null) {
         try {
            throw new Exception("Phone is already in use!");
         } catch (Exception e) {
            e.printStackTrace();
         }
         return "Fail";
      } else {
         User user = new User();
         user.setName(userDto.getName());
         user.setPhone(userDto.getPhone());
         user.setPassword(userDto.getPassword());
         userRepo.save(user);

      }
      return "Register Success";
   }
}
