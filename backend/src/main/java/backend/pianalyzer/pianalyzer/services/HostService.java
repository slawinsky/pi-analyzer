package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.repositories.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;

}
