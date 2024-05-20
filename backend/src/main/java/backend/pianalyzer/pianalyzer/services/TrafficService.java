package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.repositories.TrafficRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrafficService {
    private final TrafficRepository trafficRepository;

    public String getHitsByProtocol(String protocol) {
        return trafficRepository.findHitsByProtocol(protocol);
    }
}
