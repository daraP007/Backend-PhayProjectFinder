package devDara.phayStudyBackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import devDara.phayStudyBackend.Security.JwtService;
import devDara.phayStudyBackend.model.AuthenticationRequest;
import devDara.phayStudyBackend.model.AuthenticationResponse;
import devDara.phayStudyBackend.model.Member;
import devDara.phayStudyBackend.model.RegisterRequest;
import devDara.phayStudyBackend.model.Role;
import devDara.phayStudyBackend.repository.MemberDao;

@Service
public class AuthenticationService {

    private MemberDao memberDao;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        // creating the member object the request
        var member = Member.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        memberDao.save(member);
        var jwtToken = jwtService.generateToken(member);

        // return the object with the token
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticate'");
    }

}
