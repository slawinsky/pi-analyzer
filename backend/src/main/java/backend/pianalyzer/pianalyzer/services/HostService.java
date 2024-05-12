package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.repositories.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;

    public Optional<Integer> countAllByIsConnectedTrue() {
        return hostRepository.countAllByIsConnectedTrue();
    }

    public Optional<List<String>> getAllByIsConnectedTrue() {
        return hostRepository.getAllByIsConnectedTrue();
    }
}
