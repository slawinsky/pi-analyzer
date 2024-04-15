package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
}
