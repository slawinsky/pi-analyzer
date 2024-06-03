package backend.pianalyzer.pianalyzer.DTO.request;

import lombok.*;

@Builder
@Getter
public class UserRegisterRequest {
    private final String username;
    private final String password;
}
