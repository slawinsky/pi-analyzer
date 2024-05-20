package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.DTOs.responses.FrequentIpsResponse;
import backend.pianalyzer.pianalyzer.repositories.IpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<FrequentIpsResponse> getFrequentIps() {
        List<FrequentIpsResponse> frequentIps = new ArrayList<>();

        ipRepository.findAllBy(Sort.by(Sort.Direction.DESC, "hits")).stream().limit(5).forEach(ip -> {
            var i = FrequentIpsResponse.builder().ip(ip.getIp()).hits(ip.getHits()).build();
            frequentIps.add(i);
        });

        return frequentIps;
    }
}
