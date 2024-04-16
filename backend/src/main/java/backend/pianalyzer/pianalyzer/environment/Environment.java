package backend.pianalyzer.pianalyzer.environment;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Environment {
    public static final Dotenv dotenv = Dotenv.load();
    public static final String JWT_KEY = dotenv.get("SECRET_KEY");
    public static final String FRONTEND_URL = "http://localhost:3000";
}
