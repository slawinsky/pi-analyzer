package backend.pianalyzer.pianalyzer.DTOs.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FrequentIpsResponse {
    private final String ip;
    private final Integer hits;
}
