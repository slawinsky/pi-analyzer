package backend.pianalyzer.pianalyzer.Controllers;

import backend.pianalyzer.pianalyzer.Services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
