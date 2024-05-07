package backend.pianalyzer.pianalyzer.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@Document("hosts")
@AllArgsConstructor
@NoArgsConstructor
public class Host {
    @Id
    private String id;
    private String mac;
    private String name;
    private boolean isBlocked;
}
