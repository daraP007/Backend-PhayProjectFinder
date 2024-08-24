// package devDara.phayStudyBackend.Security;

// import java.io.IOException;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import org.springframework.security.core.userdetails.UserDetailsService;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import lombok.RequiredArgsConstructor;

// @Component
// @RequiredArgsConstructor
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     private final JwtService jwtService;
//     private final UserDetailsService userDetailsService;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//         // grab the header with the JWT token
//         final String authHeader = request.getHeader("Authorization");

//         final String jwt;
//         final String userEmail;

//         if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//             filterChain.doFilter(request, response);
//             return;
//         }

//         jwt = authHeader.substring(7);

//         userEmail = jwtService.grabUsername(jwt);

//         if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

//             if (jwtService.isTokenValid(userDetails, jwt)) {
//                 // create new objects, passing author/credentials/authority
//                 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
//                         null, userDetails.getAuthorities());
//                 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 SecurityContextHolder.getContext().setAuthentication(authToken);
//             }

//         }
//         filterChain.doFilter(request, response);

//     }

// }
