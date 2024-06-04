package backend.pianalyzer.pianalyzer.traffic.controller;

import backend.pianalyzer.pianalyzer.traffic.dto.response.TrafficResponse;
import backend.pianalyzer.pianalyzer.traffic.service.TrafficService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TrafficController {
    private final TrafficService trafficService;

    @GetMapping("/protocol/{protocol}")
    public ResponseEntity<String> getHitsByProtocol(@PathVariable String protocol) {
        return ResponseEntity.ok(trafficService.getHitsByProtocol(protocol));
    }

    @GetMapping("/protocol")
    public ResponseEntity<List<TrafficResponse>> getProtocolInfo() {
        return ResponseEntity.ok(trafficService.getProtocolInfo());
    }
}
