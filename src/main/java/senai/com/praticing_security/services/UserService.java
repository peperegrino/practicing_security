package senai.com.praticing_security.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import senai.com.praticing_security.entities.UserEntity;
import senai.com.praticing_security.entities.enums.Role;
import senai.com.praticing_security.entitiesDTO.user.RequestUserDTO;
import senai.com.praticing_security.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserEntity createUser(RequestUserDTO dto) {
        UserEntity user = new UserEntity();

        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.ROLE_USER);

        userRepository.save(user);
        return user;
    }

}
