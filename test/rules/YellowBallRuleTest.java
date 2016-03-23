package rules;

import balls.Ball;
import balls.Balls;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import rules.exceptions.NoSpaceForYellowBallException;


public class YellowBallRuleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_tell_if_the_ball_can_not_be_added() throws Exception {
        thrown.expect(NoSpaceForYellowBallException.class);
        Balls balls = new Balls();
        YellowBallRule yellowBallRule = new YellowBallRule();
        yellowBallRule.canBeAdded(Ball.createYellowBall(), balls);
    }

    @Test
    public void should_tell_if_the_ball_can_be_added() throws Exception {
        Balls balls = new Balls();
        balls.add(Ball.createBlueBall());
        balls.add(Ball.createBlueBall());
        balls.add(Ball.createBlueBall());
        YellowBallRule yellowBallRule = new YellowBallRule();
        yellowBallRule.canBeAdded(Ball.createYellowBall(),balls);
    }

    @Test
    public void should_tell_if_the_ball_can_not_be_added_if_the_ball_is_not_of_yellow() throws Exception {
        Balls balls = new Balls();
        YellowBallRule yellowBallRule = new YellowBallRule();
        yellowBallRule.canBeAdded(Ball.createRedBall(),balls);
    }
}
