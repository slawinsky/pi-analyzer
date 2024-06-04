package backend.pianalyzer.pianalyzer.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsernameChangeResponse {
    private final String username;
}
