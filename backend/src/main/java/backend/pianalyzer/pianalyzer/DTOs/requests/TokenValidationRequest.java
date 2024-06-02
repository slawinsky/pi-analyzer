package backend.pianalyzer.pianalyzer.DTOs.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenValidationRequest {
    private final String token;
}
