package backend.pianalyzer.pianalyzer.host.service;

import backend.pianalyzer.pianalyzer.host.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;

    public Optional<Integer> countAllByConnected() {
        return hostRepository.countAllByConnected();
    }

    public Optional<List<String>> getAllByConnected() {
        return hostRepository.getAllByConnected();
    }
}
