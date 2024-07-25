package devDara.phayStudyBackend.config;

import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import devDara.phayStudyBackend.Security.JwtAuthenticationFilter;
import devDara.phayStudyBackend.repository.MemberDao;
import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final MemberDao userDao;

    @Autowired
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    
    private final AuthenticationProvider authenticationProvider;
  

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity request) throws Exception{

        request
        .csrf(csrf -> csrf.disable()) // CSRF configuration
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/public/**").permitAll() // Adjust the matchers as needed
            .anyRequest().authenticated()
        )
        .sessionManagement(session -> 
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    
        return request.build();
    }
   
    

}
