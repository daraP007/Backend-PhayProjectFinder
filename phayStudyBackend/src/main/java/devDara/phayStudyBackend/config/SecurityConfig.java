package devDara.phayStudyBackend.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import org.springframework.security.authentication.AuthenticationProvider;

// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import devDara.phayStudyBackend.Security.JwtAuthenticationFilter;
// import devDara.phayStudyBackend.repository.MemberDao;
// import lombok.RequiredArgsConstructor;

// @EnableWebSecurity
// @Configuration
// @RequiredArgsConstructor
// public class SecurityConfig {
//     @Autowired
//     private final MemberDao memberDao;

//     @Autowired
//     private final JwtAuthenticationFilter jwtAuthenticationFilter;

//     private final AuthenticationProvider authenticationProvider;

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity request) throws Exception {
//         request
//                 .csrf(csrf -> csrf.disable()) // CSRF configuration
//                 .authorizeHttpRequests(authorize -> authorize
//                         .requestMatchers("api/auth/register").permitAll()
//                         .requestMatchers("api/auth/authenticate").permitAll()  // The connection must have this string to pass through security
//                         .requestMatchers("member/allMember").permitAll()
//                         .requestMatchers("api/project/addProject").permitAll()
//                         .anyRequest()
//                         .authenticated())
//                 .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                 .authenticationProvider(authenticationProvider)
//                 .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

//         return request.build();
//     }

// }
