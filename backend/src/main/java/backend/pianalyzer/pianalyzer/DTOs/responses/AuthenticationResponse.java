package backend.pianalyzer.pianalyzer.DTOs.responses;

import lombok.*;

@Builder
@Getter
public class AuthenticationResponse {
    private final String token;
}
