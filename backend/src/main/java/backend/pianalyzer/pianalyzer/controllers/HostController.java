package backend.pianalyzer.pianalyzer.controllers;

import backend.pianalyzer.pianalyzer.services.HostService;
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
public class HostController {
    private final HostService hostService;

    @GetMapping("/hosts/count")
    public ResponseEntity<Optional<Integer>> getConnectedHostsCount() {
        return ResponseEntity.ok(hostService.countAllByConnected());
    }

    @GetMapping("/hosts/list")
    public ResponseEntity<Optional<List<String>>> getConnectedHosts() {
        return ResponseEntity.ok(hostService.getAllByConnected());
    }
}
