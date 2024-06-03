package backend.pianalyzer.pianalyzer.domains.auth.service;

import backend.pianalyzer.pianalyzer.DTO.request.UserLoginRequest;
import backend.pianalyzer.pianalyzer.DTO.response.AuthenticationResponse;
import backend.pianalyzer.pianalyzer.domains.user.repository.UserRepository;
import backend.pianalyzer.pianalyzer.security.services.JwtService;
import backend.pianalyzer.pianalyzer.time.ZonedDateTimeWriteConverter;
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
