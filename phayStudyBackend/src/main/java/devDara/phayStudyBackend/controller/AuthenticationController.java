package devDara.phayStudyBackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devDara.phayStudyBackend.model.AuthenticationRequest;
import devDara.phayStudyBackend.model.AuthenticationResponse;
import devDara.phayStudyBackend.model.RegisterRequest;
import devDara.phayStudyBackend.service.AuthenticationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private AuthenticationService authenticationService;
    
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
        
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
    
    
}
