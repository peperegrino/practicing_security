package senai.com.praticing_security.entitiesDTO.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestAdminDTO {


    @NotNull
    private String name;

    @NotNull
    private int age;

    @Email
    private String email;

    @NotNull
    private String password;

}
