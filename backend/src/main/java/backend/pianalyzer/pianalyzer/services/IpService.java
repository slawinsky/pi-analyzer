package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.DTOs.responses.FrequentIpsResponse;
import backend.pianalyzer.pianalyzer.repositories.IpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<FrequentIpsResponse> getFrequentIps() {
        return ipRepository.findAllBy(Sort.by(Sort.Direction.DESC, "hits")).stream().limit(5).map(ip -> FrequentIpsResponse.builder()
                        .ip(ip.getIp())
                        .hits(ip.getHits())
                        .build()
        ).collect(Collectors.toList());
    }
}
