package backend.pianalyzer.pianalyzer.controllers;

import backend.pianalyzer.pianalyzer.DTOs.requests.UserLoginRequest;
import backend.pianalyzer.pianalyzer.DTOs.responses.AuthenticationResponse;
import backend.pianalyzer.pianalyzer.environment.Environment;
import backend.pianalyzer.pianalyzer.security.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
    private final String FRONTEND_URL = Environment.FRONTEND_URL;

    @CrossOrigin(origins = FRONTEND_URL)
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody UserLoginRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
