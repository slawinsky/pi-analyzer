package backend.pianalyzer.pianalyzer.Models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.ZonedDateTime;

@Data
@Document
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private ZonedDateTime lastLogin;

    public User(String id, String username, String password, ZonedDateTime lastLogin) {
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
    }
}
