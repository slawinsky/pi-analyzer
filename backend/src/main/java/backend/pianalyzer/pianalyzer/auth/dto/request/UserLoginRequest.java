package backend.pianalyzer.pianalyzer.auth.dto.request;

import lombok.*;

@Builder
@Getter
public class UserLoginRequest {
    private final String username;
    private final String password;
}
