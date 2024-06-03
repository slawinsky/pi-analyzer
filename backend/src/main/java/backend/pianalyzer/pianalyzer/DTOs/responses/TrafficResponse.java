package backend.pianalyzer.pianalyzer.DTOs.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TrafficResponse {
    private final String protocol;
    private final Integer hits;
}
