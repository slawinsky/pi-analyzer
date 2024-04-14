package backend.pianalyzer.pianalyzer.Security.Services;

import backend.pianalyzer.pianalyzer.DTOs.Requests.UserLoginRequest;
import backend.pianalyzer.pianalyzer.DTOs.Requests.UserRegisterRequest;
import backend.pianalyzer.pianalyzer.DTOs.Responses.AuthenticationResponse;
import backend.pianalyzer.pianalyzer.Exceptions.UsernameExistException;
import backend.pianalyzer.pianalyzer.Models.User;
import backend.pianalyzer.pianalyzer.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public User register(UserRegisterRequest request) throws UsernameExistException {
        if(userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new UsernameExistException();
        }
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        return userRepository.save(user);
    }

    public AuthenticationResponse authenticate(UserLoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
