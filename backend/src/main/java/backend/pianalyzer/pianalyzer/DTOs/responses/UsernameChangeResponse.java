package backend.pianalyzer.pianalyzer.DTOs.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsernameChangeResponse {
    private final String username;
}
