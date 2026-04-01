package senai.com.praticing_security.entities;


import jakarta.persistence.*;
import lombok.*;
import senai.com.praticing_security.entities.enums.Roles;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserEntity {

    //creating the atributes of user class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int age;

    // @Column(unique =)
    private String email;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    private String password;
}
