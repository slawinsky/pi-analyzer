package backend.pianalyzer.pianalyzer.DTOs.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsernameChangeRequest {
    private final String username;
    private final String changedUsername;
}
