package backend.pianalyzer.pianalyzer.ip.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FrequentIpsResponse {
    private final String ip;
    private final Integer hits;
}
