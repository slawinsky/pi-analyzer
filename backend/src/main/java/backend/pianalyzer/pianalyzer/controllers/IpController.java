package backend.pianalyzer.pianalyzer.controllers;

import backend.pianalyzer.pianalyzer.environment.Environment;
import backend.pianalyzer.pianalyzer.services.IpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class IpController {
    private final IpService ipService;
    private final String FRONTEND_URL = Environment.FRONTEND_URL;

    @CrossOrigin(origins = FRONTEND_URL)
    @GetMapping("/threats")
    public ResponseEntity<String> getThreats() {
        return ResponseEntity.ok(ipService.getThreatsNumber());
    }

    @CrossOrigin(origins = FRONTEND_URL)
    @GetMapping("/threats/ip")
    public ResponseEntity<Optional<List<String>>> getDangerIps() {
        return ResponseEntity.ok(ipService.getThreatsIps());
    }
}
