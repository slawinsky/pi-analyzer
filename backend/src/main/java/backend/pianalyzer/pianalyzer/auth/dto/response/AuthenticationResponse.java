package backend.pianalyzer.pianalyzer.auth.dto.response;

import lombok.*;

@Builder
@Getter
public class AuthenticationResponse {
    private final String token;
}
