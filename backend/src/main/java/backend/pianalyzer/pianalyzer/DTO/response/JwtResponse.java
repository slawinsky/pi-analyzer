package backend.pianalyzer.pianalyzer.DTO.response;

import lombok.*;

@Builder
@Getter
public class JwtResponse {
    private final String jwtToken;
}
