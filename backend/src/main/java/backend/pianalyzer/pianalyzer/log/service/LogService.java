package backend.pianalyzer.pianalyzer.log.service;

import backend.pianalyzer.pianalyzer.log.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
}
