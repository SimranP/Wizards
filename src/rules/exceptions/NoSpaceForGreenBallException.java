package rules.exceptions;

import balls.Color;

public class NoSpaceForGreenBallException extends NoSpaceForColorException {
    public NoSpaceForGreenBallException() {
        super(Color.GREEN.name());
    }
}
