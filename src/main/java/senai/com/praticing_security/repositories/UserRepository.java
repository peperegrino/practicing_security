package senai.com.praticing_security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import senai.com.praticing_security.entities.UserEntity;

public interface UserRepository extends JpaRepository <UserEntity, Long> {

     UserEntity findByEmail(String email);


}
