package backend.pianalyzer.pianalyzer.DTOs.responses;

import lombok.Builder;
import lombok.Getter;
import java.util.Date;

@Builder
@Getter
public class UserResponse {
    private final String username;
    private final Date lastLogin;
}
