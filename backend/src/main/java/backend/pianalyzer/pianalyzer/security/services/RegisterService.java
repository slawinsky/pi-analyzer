package backend.pianalyzer.pianalyzer.security.services;

import backend.pianalyzer.pianalyzer.DTOs.requests.UserRegisterRequest;
import backend.pianalyzer.pianalyzer.exceptions.UsernameExistException;
import backend.pianalyzer.pianalyzer.models.User;
import backend.pianalyzer.pianalyzer.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService implements AccountService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(UserRegisterRequest request) throws UsernameExistException {
        if(userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new UsernameExistException();
        }
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        return userRepository.save(user);
    }
}
