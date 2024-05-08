package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.repositories.IpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IpService {
    private final IpRepository ipRepository;

    public String getThreatsNumber() {
        return ipRepository.countAllByIsDangerIsTrue();
    }

    public Optional<List<String>> getThreatsIps() {
        return ipRepository.findIpByIsDanger();
    }
}
