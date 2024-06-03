package backend.pianalyzer.pianalyzer.DTO.response;

import lombok.*;

@Builder
@Getter
public class AuthenticationResponse {
    private final String token;
}
