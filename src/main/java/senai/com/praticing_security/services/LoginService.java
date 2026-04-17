package senai.com.praticing_security.services;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Signature;

import static java.security.KeyRep.Type.SECRET;


@Service
public class LoginService {

    private final String SECRET = "minhachavesupersecretacom32caracteresparadarcerto";

    public String generateToken(String email) {
        return  Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgotithm.HS256,SECRET)
                .compact();
    }


}
