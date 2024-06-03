package backend.pianalyzer.pianalyzer.security.services;

import backend.pianalyzer.pianalyzer.DTO.request.UserRegisterRequest;
import backend.pianalyzer.pianalyzer.exception.UsernameExistException;
import backend.pianalyzer.pianalyzer.model.User;

interface AccountService {

    User register(UserRegisterRequest request) throws UsernameExistException;
}
