package backend.pianalyzer.pianalyzer.traffic.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Document("traffic")
@AllArgsConstructor
@NoArgsConstructor
public class Traffic {
    @Id
    private String id;
    private String protocol;
    private int hits;
}
