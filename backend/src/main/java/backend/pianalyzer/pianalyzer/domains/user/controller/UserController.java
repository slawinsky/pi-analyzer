package backend.pianalyzer.pianalyzer.domains.user.controller;

import backend.pianalyzer.pianalyzer.DTO.request.UserPasswordChangeRequest;
import backend.pianalyzer.pianalyzer.DTO.request.UsernameChangeRequest;
import backend.pianalyzer.pianalyzer.DTO.response.DeleteUserResponse;
import backend.pianalyzer.pianalyzer.DTO.response.UserPasswordChangeResponse;
import backend.pianalyzer.pianalyzer.DTO.response.UserResponse;
import backend.pianalyzer.pianalyzer.DTO.response.UsernameChangeResponse;
import backend.pianalyzer.pianalyzer.domains.user.service.UserService;
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
