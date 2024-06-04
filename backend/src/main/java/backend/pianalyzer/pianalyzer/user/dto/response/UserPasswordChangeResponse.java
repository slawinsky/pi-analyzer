package backend.pianalyzer.pianalyzer.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserPasswordChangeResponse {
    private final String username;
}
