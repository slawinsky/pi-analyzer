package backend.pianalyzer.pianalyzer.domains.auth.controller;

import backend.pianalyzer.pianalyzer.DTO.request.UserLoginRequest;
import backend.pianalyzer.pianalyzer.DTO.response.AuthenticationResponse;
import backend.pianalyzer.pianalyzer.domains.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

     @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody UserLoginRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
