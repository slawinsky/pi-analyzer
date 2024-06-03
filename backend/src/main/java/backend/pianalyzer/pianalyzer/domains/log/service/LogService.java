package backend.pianalyzer.pianalyzer.domains.log.service;

import backend.pianalyzer.pianalyzer.domains.log.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
}
