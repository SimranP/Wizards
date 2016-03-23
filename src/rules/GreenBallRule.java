package rules;

import balls.Ball;
import balls.Balls;
import balls.Color;
import rules.exceptions.NoSpaceForGreenBallException;

public class GreenBallRule implements Rule {
    @Override
    public void canBeAdded(Ball ball, Balls balls) {
        if(ball.isOfColor(Color.GREEN)){
            if(!(balls.noOfBalls(Color.GREEN) < 3))
                throw  new NoSpaceForGreenBallException();
        }
    }
}
