package backend.pianalyzer.pianalyzer.traffic.service;

import backend.pianalyzer.pianalyzer.traffic.dto.response.TrafficResponse;
import backend.pianalyzer.pianalyzer.traffic.repository.TrafficRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrafficService {
    private final TrafficRepository trafficRepository;

    public String getHitsByProtocol(String protocol) {
        return trafficRepository.findHitsByProtocol(protocol);
    }
    public List<TrafficResponse> getProtocolInfo() {
        return trafficRepository.findAllBy().stream().map(protocol -> TrafficResponse.builder()
                .protocol(protocol.getProtocol())
                .hits(protocol.getHits()).build()
        ).collect(Collectors.toList());
    }
}
