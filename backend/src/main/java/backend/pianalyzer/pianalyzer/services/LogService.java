package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.repositories.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
}
