package backend.pianalyzer.pianalyzer.DTOs.responses;

import lombok.*;

@Builder
@Getter
public class JwtResponse {
    private final String jwtToken;
}
