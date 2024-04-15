package backend.pianalyzer.pianalyzer.security.services;

import backend.pianalyzer.pianalyzer.DTOs.requests.UserRegisterRequest;
import backend.pianalyzer.pianalyzer.exceptions.UsernameExistException;
import backend.pianalyzer.pianalyzer.models.User;

interface AccountService {

    User register(UserRegisterRequest request) throws UsernameExistException;
}
