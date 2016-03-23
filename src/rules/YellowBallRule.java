package rules;

import balls.Ball;
import balls.Balls;
import balls.Color;
import rules.exceptions.NoSpaceForYellowBallException;

public class YellowBallRule implements Rule {
    @Override
    public void canBeAdded(Ball ball, Balls balls) {
        if(ball.isOfColor(Color.YELLOW)) {
            if(!(balls.noOfBalls(Color.YELLOW) < (int) (0.4 * balls.size())))
                throw  new NoSpaceForYellowBallException();
        }
    }
}
