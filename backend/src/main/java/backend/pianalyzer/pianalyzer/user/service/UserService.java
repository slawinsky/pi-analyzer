package backend.pianalyzer.pianalyzer.user.service;

import backend.pianalyzer.pianalyzer.user.dto.request.UserPasswordChangeRequest;
import backend.pianalyzer.pianalyzer.user.dto.request.UsernameChangeRequest;
import backend.pianalyzer.pianalyzer.user.dto.response.DeleteUserResponse;
import backend.pianalyzer.pianalyzer.user.dto.response.UserPasswordChangeResponse;
import backend.pianalyzer.pianalyzer.user.dto.response.UserResponse;
import backend.pianalyzer.pianalyzer.user.dto.response.UsernameChangeResponse;
import backend.pianalyzer.pianalyzer.user.repository.UserRepository;
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
