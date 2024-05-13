package backend.pianalyzer.pianalyzer.security.services;

import backend.pianalyzer.pianalyzer.DTOs.requests.UserLoginRequest;
import backend.pianalyzer.pianalyzer.DTOs.responses.AuthenticationResponse;
import backend.pianalyzer.pianalyzer.repositories.UserRepository;
import backend.pianalyzer.pianalyzer.utils.ZonedDateTimeWriteConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ZonedDateTimeWriteConverter zonedDateTimeWriteConverter;

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

        user.setLastLogin(zonedDateTimeWriteConverter.convert(ZonedDateTime.now(ZoneId.of("UTC+2"))));
        userRepository.save(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
