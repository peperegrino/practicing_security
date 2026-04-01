package senai.com.praticing_security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senai.com.praticing_security.entitiesDTO.RequestUserDTO;
import senai.com.praticing_security.services.UserService;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody RequestUserDTO dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }
}
