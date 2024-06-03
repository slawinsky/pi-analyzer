package backend.pianalyzer.pianalyzer.DTO.request;

import lombok.*;

@Builder
@Getter
public class UserLoginRequest {
    private final String username;
    private final String password;
}
