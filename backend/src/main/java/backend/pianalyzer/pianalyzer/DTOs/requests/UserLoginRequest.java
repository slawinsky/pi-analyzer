package backend.pianalyzer.pianalyzer.DTOs.requests;

import lombok.*;

@Builder
@Getter
public class UserLoginRequest {
    private final String username;
    private final String password;
}
