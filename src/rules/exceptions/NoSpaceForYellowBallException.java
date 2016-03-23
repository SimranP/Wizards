package rules.exceptions;

import balls.Color;

public class NoSpaceForYellowBallException extends NoSpaceForColorException {
    public NoSpaceForYellowBallException() {
        super(Color.YELLOW.name());
    }
}
