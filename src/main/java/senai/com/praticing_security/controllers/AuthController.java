package senai.com.praticing_security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import senai.com.praticing_security.DTO.LoginDTO.requestLoginDTO;
import senai.com.praticing_security.services.LoginService;

public class AuthController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private AuthenticationManager authManager;
    @PostMapping("/login")
    public String login(@RequestBody requestLoginDTO loginDTO) {}

    authManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    requestLoginDTO.getEmail()
    )
            )

}
