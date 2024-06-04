package backend.pianalyzer.pianalyzer.register.dto.request;

import lombok.*;

@Builder
@Getter
public class UserRegisterRequest {
    private final String username;
    private final String password;
}
