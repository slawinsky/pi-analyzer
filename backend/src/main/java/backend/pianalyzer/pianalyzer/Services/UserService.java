package backend.pianalyzer.pianalyzer.Services;

import backend.pianalyzer.pianalyzer.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
