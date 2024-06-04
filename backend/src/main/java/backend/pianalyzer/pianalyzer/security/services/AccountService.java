package backend.pianalyzer.pianalyzer.security.services;

import backend.pianalyzer.pianalyzer.register.dto.request.UserRegisterRequest;
import backend.pianalyzer.pianalyzer.exception.UsernameExistException;
import backend.pianalyzer.pianalyzer.user.model.User;

interface AccountService {

    User register(UserRegisterRequest request) throws UsernameExistException;
}
