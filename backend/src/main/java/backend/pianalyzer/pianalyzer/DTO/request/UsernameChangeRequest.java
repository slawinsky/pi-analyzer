package backend.pianalyzer.pianalyzer.DTO.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsernameChangeRequest {
    private final String username;
    private final String changedUsername;
}
