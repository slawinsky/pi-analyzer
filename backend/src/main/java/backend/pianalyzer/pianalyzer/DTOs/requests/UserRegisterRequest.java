package backend.pianalyzer.pianalyzer.DTOs.requests;

import lombok.*;

@Builder
@Getter
public class UserRegisterRequest {
    private final String username;
    private final String password;
}
