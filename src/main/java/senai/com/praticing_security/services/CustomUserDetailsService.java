package senai.com.praticing_security.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import senai.com.praticing_security.repositories.UserRepository;
import senai.com.praticing_security.entities.UserEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         UserEntity user = userRepository.findByEmail(email);
        return User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .roles(user.getRole().name().replace("ROLE",""))
                .build()

                ;
    }
}
