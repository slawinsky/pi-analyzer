package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.DTOs.responses.TrafficResponse;
import backend.pianalyzer.pianalyzer.repositories.TrafficRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrafficService {
    private final TrafficRepository trafficRepository;

    public String getHitsByProtocol(String protocol) {
        return trafficRepository.findHitsByProtocol(protocol);
    }
    public List<TrafficResponse> getProtocolsInfo() {
        List<TrafficResponse> protocols = new ArrayList<>();
        trafficRepository.findAllBy().forEach((protocol) -> {
            var p = TrafficResponse.builder().protocol(protocol.getProtocol()).hits(protocol.getHits()).build();
            protocols.add(p);
        });

        return protocols;
    }
}
