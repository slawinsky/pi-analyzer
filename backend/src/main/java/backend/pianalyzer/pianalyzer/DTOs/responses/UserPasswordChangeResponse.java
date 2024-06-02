package backend.pianalyzer.pianalyzer.DTOs.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserPasswordChangeResponse {
    private final String username;
}
