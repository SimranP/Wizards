package rules;

import balls.Ball;
import balls.Balls;
import balls.Color;
import rules.exceptions.NoSpaceForRedBallException;

public class RedBallRule implements Rule {
    @Override
    public void canBeAdded(Ball ball, Balls balls) {
        if(ball.isOfColor(Color.RED)) {
           if (!(balls.noOfBalls(Color.RED) < 2 * balls.noOfBalls(Color.GREEN)))
               throw new NoSpaceForRedBallException();
        }
    }
}
