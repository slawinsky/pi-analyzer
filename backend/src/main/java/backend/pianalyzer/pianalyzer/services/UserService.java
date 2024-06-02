package backend.pianalyzer.pianalyzer.services;

import backend.pianalyzer.pianalyzer.DTOs.requests.UserPasswordChangeRequest;
import backend.pianalyzer.pianalyzer.DTOs.requests.UsernameChangeRequest;
import backend.pianalyzer.pianalyzer.DTOs.responses.DeleteUserResponse;
import backend.pianalyzer.pianalyzer.DTOs.responses.UserPasswordChangeResponse;
import backend.pianalyzer.pianalyzer.DTOs.responses.UserResponse;
import backend.pianalyzer.pianalyzer.DTOs.responses.UsernameChangeResponse;
import backend.pianalyzer.pianalyzer.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserResponse> getUsers() {
        List<UserResponse> users = new ArrayList<>();
        userRepository.findAllBy().forEach((user) -> {
            var u = UserResponse.builder().username(user.getUsername()).lastLogin(user.getLastLogin()).build();
            users.add(u);
        });

        return users;
    }

    public UsernameChangeResponse changeUsername(UsernameChangeRequest usernameChangeRequest) {
        var user = userRepository.findByUsername(usernameChangeRequest.getUsername()).orElseThrow();
        System.out.println(usernameChangeRequest.getChangedUsername());
        user.setUsername(usernameChangeRequest.getChangedUsername());
        userRepository.save(user);

        UsernameChangeResponse response = UsernameChangeResponse.builder().username(usernameChangeRequest.getChangedUsername()).build();

        return response;
    }

    public UserPasswordChangeResponse changeUserPassword(UserPasswordChangeRequest userPasswordChangeRequest) {
        var user = userRepository.findByUsername(userPasswordChangeRequest.getUsername()).orElseThrow();
        user.setPassword(passwordEncoder.encode(userPasswordChangeRequest.getChangedPassword()));
        userRepository.save(user);

        UserPasswordChangeResponse response = UserPasswordChangeResponse.builder().username(userPasswordChangeRequest.getUsername()).build();

        return response;
    }

    public DeleteUserResponse deleteUser(String username) {
        var user = userRepository.findByUsername(username).orElseThrow();
        userRepository.delete(user);

        DeleteUserResponse response = DeleteUserResponse.builder().username(username).build();

        return response;
    }
 }
