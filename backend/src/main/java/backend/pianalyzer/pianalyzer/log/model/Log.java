package backend.pianalyzer.pianalyzer.log.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Builder
@Getter
@Document("logs")
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    @Id
    private String id;
    private ZonedDateTime date;
    private String who;
    private String what;
    private String value;
}
