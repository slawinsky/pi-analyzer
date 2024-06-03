package backend.pianalyzer.pianalyzer.domains.ip.service;

import backend.pianalyzer.pianalyzer.DTO.response.FrequentIpsResponse;
import backend.pianalyzer.pianalyzer.domains.ip.repository.IpRepository;
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
