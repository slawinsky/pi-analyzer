package backend.pianalyzer.pianalyzer.Exceptions;

import javax.security.sasl.AuthenticationException;

public class UsernameExistException extends AuthenticationException {
    public UsernameExistException() {
        super("Account with this username already exists!");
    }
}
