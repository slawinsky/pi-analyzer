package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.DTOs.responses.UserResponse;
import backend.pianalyzer.pianalyzer.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponse> getUsers() {
        List<UserResponse> users = new ArrayList<>();
        userRepository.findAllBy().forEach((user) -> {
            var u = UserResponse.builder().username(user.getUsername()).lastLogin(user.getLastLogin()).build();
            users.add(u);
        });

        return users;
    }
}
