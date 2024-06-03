package backend.pianalyzer.pianalyzer.exceptions;

public class UsernameExistException extends RuntimeException {
    public UsernameExistException() {
        super("Account with this username already exists!", null);
    }
}
