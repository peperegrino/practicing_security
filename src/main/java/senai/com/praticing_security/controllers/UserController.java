package senai.com.praticing_security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.com.praticing_security.DTO.user.RequestUserDTO;
import senai.com.praticing_security.services.UserService;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> create(@RequestBody RequestUserDTO dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @GetMapping("/admin")
    public String admin(){
        return "Acesso ADMIN";
    }

}