package rules;

import balls.Ball;
import balls.Balls;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import rules.exceptions.NoSpaceForGreenBallException;


public class GreenBallRuleTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void should_tell_if_the_ball_can_be_added() throws Exception {
        Balls balls = new Balls();
        GreenBallRule greenBallRule = new GreenBallRule();
        greenBallRule.canBeAdded(Ball.createGreenBall(),balls);
    }

    @Test
    public void should_tell_if_the_ball_can_not_be_added() throws Exception {
        thrown.expect(NoSpaceForGreenBallException.class);
        Balls balls = new Balls();
        balls.add(Ball.createGreenBall());
        balls.add(Ball.createGreenBall());
        balls.add(Ball.createGreenBall());
        GreenBallRule greenBallRule = new GreenBallRule();
        greenBallRule.canBeAdded(Ball.createGreenBall(),balls);
    }

    @Test
    public void should_tell_if_the_ball_can_not_be_added_if_the_ball_is_not_of_green() throws Exception {
        Balls balls = new Balls();
        GreenBallRule greenBallRule = new GreenBallRule();
        greenBallRule.canBeAdded(Ball.createRedBall(),balls);
    }
}
