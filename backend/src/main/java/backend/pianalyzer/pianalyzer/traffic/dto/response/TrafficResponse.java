package backend.pianalyzer.pianalyzer.traffic.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TrafficResponse {
    private final String protocol;
    private final Integer hits;
}
