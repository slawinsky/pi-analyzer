package backend.pianalyzer.pianalyzer.controllers;

import backend.pianalyzer.pianalyzer.DTOs.requests.TokenValidationRequest;
import backend.pianalyzer.pianalyzer.DTOs.requests.UserLoginRequest;
import backend.pianalyzer.pianalyzer.DTOs.responses.AuthenticationResponse;
import backend.pianalyzer.pianalyzer.security.services.AuthenticationService;
import backend.pianalyzer.pianalyzer.security.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

     @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody UserLoginRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/token")
    public ResponseEntity<Boolean> isTokenExpired(@RequestBody TokenValidationRequest request) {
         return ResponseEntity.ok(jwtService.isTokenExpired(request.getToken()));
    }
}
