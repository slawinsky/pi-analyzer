package backend.pianalyzer.pianalyzer.DTO.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsernameChangeResponse {
    private final String username;
}
