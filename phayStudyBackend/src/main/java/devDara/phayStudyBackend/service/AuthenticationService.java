package devDara.phayStudyBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        // creating the member object the request
        var member = Member.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        memberDao.save(member);
        var jwtToken = jwtService.generateToken(member);

        // return the object with the token
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));


        var member = memberDao.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(member);
        System.out.println("it a success!");
        // return the object with the token
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

}
