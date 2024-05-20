package backend.pianalyzer.pianalyzer.controllers;

import backend.pianalyzer.pianalyzer.services.TrafficService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TrafficController {
    private final TrafficService trafficService;

    @GetMapping("/protocol/{protocol}")
    public ResponseEntity<String> getHitsByProtocol(@PathVariable String protocol) {
        return ResponseEntity.ok(trafficService.getHitsByProtocol(protocol));
    }
}
