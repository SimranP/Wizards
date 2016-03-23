package rules.exceptions;

public class NoSpaceForColorException extends RuntimeException {
    public NoSpaceForColorException(String name) {
        super("No more space for "+name);
    }
}
