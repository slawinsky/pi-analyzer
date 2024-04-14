package backend.pianalyzer.pianalyzer.Controllers;

import backend.pianalyzer.pianalyzer.DTOs.Requests.UserLoginRequest;
import backend.pianalyzer.pianalyzer.DTOs.Requests.UserRegisterRequest;
import backend.pianalyzer.pianalyzer.DTOs.Responses.AuthenticationResponse;
import backend.pianalyzer.pianalyzer.Exceptions.UsernameExistException;
import backend.pianalyzer.pianalyzer.Security.Services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody UserRegisterRequest request
    ) {
        try {
            authenticationService.register(request);
        } catch (UsernameExistException e) {
            return ResponseEntity.status(409).body("Username already exist.");
        }
        return ResponseEntity.ok("Account created.");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody UserLoginRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
