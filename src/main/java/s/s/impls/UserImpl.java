package s.s.impls;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import s.s.dtos.UserDto;
import s.s.models.Role;
import s.s.models.User;
import s.s.repos.UserRepo;
import s.s.services.UserService;

@Service
public class UserImpl implements UserService {

   @Autowired
   BCryptPasswordEncoder bCryptPasswordEncoder;

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
         user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
         user.setRoles(Arrays.asList(new Role("ROLE_USER")));
         userRepo.save(user);

      }
      return "Register Success";
   }

   @Override
   public User getUserByName(String username) {
      return userRepo.findByName(username);
   }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepo.findByPhone(username);
      if (user == null) {
         throw new UsernameNotFoundException("Invalid phone or password");
      }

      return new org.springframework.security.core.userdetails.User(
            user.getName(),
            user.getPassword(),
            mapRolesAuthorities(user.getRoles()));
   }

   private Collection<? extends GrantedAuthority> mapRolesAuthorities(Collection<Role> roles) {
      return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
   }
}
