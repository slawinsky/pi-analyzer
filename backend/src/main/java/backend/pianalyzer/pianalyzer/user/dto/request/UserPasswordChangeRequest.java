package backend.pianalyzer.pianalyzer.user.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserPasswordChangeRequest {
    private final String username;
    private final String changedPassword;
}
