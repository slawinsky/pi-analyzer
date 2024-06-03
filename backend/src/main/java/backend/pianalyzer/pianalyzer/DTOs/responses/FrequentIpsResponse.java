package backend.pianalyzer.pianalyzer.DTOs.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FrequentIpsResponse {
    private final String ip;
    private final Integer hits;
}
