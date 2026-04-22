package senai.com.praticing_security.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import senai.com.praticing_security.services.CustomUserDetailsService;
import senai.com.praticing_security.services.LoginService;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final LoginService loginService;
    private final CustomUserDetailsService customUserDetailsService;


    public JwtFilter(LoginService loginService, CustomUserDetailsService customUserDetailsService) {
        this.loginService = loginService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            String email = loginService.getEmail(token);


            var user = customUserDetailsService.loadUserByUsername(email);

            if (user != null) {
                var auth = new UsernamePasswordAuthenticationToken(
                        user, null, user.getAuthorities()
                );

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }


        filterChain.doFilter(request, response);
    }
}