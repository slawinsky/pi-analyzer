package backend.pianalyzer.pianalyzer.DTO.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeleteUserResponse {
    private final String username;
}
