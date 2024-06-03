package backend.pianalyzer.pianalyzer.domains.register.controller;

import backend.pianalyzer.pianalyzer.DTO.request.UserRegisterRequest;
import backend.pianalyzer.pianalyzer.exception.UsernameExistException;
import backend.pianalyzer.pianalyzer.security.services.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody UserRegisterRequest request
    ) {
        try {
            registerService.register(request);
        } catch (UsernameExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exist.");
        }
        return ResponseEntity.ok("Account created.");
    }
}
