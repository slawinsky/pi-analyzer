package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.repositories.IpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IpService {
    private final IpRepository ipRepository;
}
