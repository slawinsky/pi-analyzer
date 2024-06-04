package backend.pianalyzer.pianalyzer.ip.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Document("ips")
@AllArgsConstructor
@NoArgsConstructor
public class Ip {
    @Id
    private String id;
    private String ip;
    private Integer hits;
    private boolean isDanger;
}
