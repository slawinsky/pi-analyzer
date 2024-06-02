package backend.pianalyzer.pianalyzer.controllers;

import backend.pianalyzer.pianalyzer.DTOs.requests.UserPasswordChangeRequest;
import backend.pianalyzer.pianalyzer.DTOs.requests.UsernameChangeRequest;
import backend.pianalyzer.pianalyzer.DTOs.responses.DeleteUserResponse;
import backend.pianalyzer.pianalyzer.DTOs.responses.UserPasswordChangeResponse;
import backend.pianalyzer.pianalyzer.DTOs.responses.UserResponse;
import backend.pianalyzer.pianalyzer.DTOs.responses.UsernameChangeResponse;
import backend.pianalyzer.pianalyzer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PutMapping("/user/name")
    public ResponseEntity<UsernameChangeResponse> changeUsername(@RequestBody UsernameChangeRequest usernameChangeRequest) {
        return ResponseEntity.ok(userService.changeUsername(usernameChangeRequest));
    }

    @PutMapping("/user/password")
    public ResponseEntity<UserPasswordChangeResponse> changePassword(@RequestBody UserPasswordChangeRequest userPasswordChangeRequest) {
        return ResponseEntity.ok(userService.changeUserPassword(userPasswordChangeRequest));
    }

    @DeleteMapping("/user/{username}")
    public ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.deleteUser(username));
    }
}
