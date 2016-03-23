package rules.exceptions;

import balls.Color;

public class NoSpaceForRedBallException extends NoSpaceForColorException {
    public NoSpaceForRedBallException() {
        super(Color.RED.name());
    }
}
