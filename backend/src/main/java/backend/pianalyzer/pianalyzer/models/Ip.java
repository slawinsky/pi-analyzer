package backend.pianalyzer.pianalyzer.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@Document("ips")
@AllArgsConstructor
@NoArgsConstructor
public class Ip {
    @Id
    private String id;
    private String ipv4;
    private boolean isDanger;
}
