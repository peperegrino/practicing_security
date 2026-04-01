package senai.com.praticing_security.entitiesDTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequestUserDTO {

    @NotNull
    private String name;

    @NotNull
    private int age;

    @Email
    private String email;

}
