package devDara.phayStudyBackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devDara.phayStudyBackend.model.AuthenticationRequest;
import devDara.phayStudyBackend.model.AuthenticationResponse;
import devDara.phayStudyBackend.model.Member;
import devDara.phayStudyBackend.model.RegisterRequest;
import devDara.phayStudyBackend.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/auth")
@CrossOrigin("http://localhost:5174")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
        System.out.println(request.getEmail());
        
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Member>login(@RequestBody AuthenticationRequest request){
        authenticationService.retrieveUser(request);
        return null;
    }
    
    
}
