package backend.pianalyzer.pianalyzer.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/v1/test")
    public ResponseEntity<String> testRequest() {
        return ResponseEntity.ok("Test passed!");
    }
}
