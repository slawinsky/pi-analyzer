package backend.pianalyzer.pianalyzer.controllers;

import backend.pianalyzer.pianalyzer.services.IpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/threats")
    public ResponseEntity<String> getThreats() {
        return ResponseEntity.ok(ipService.getThreatsNumber());
    }

    @GetMapping("/threats/ip")
    public ResponseEntity<Optional<List<String>>> getDangerIps() {
        return ResponseEntity.ok(ipService.getThreatsIps());
    }
}
