package backend.pianalyzer.pianalyzer.exceptions;

import javax.security.sasl.AuthenticationException;

public class UsernameExistException extends AuthenticationException {
    public UsernameExistException() {
        super("Account with this username already exists!", null);
    }
}
