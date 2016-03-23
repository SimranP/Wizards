package rules;

import balls.Ball;
import balls.Balls;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RedBallRuleTest {
    @Test
    public void should_tell_if_the_ball_can_be_added() throws Exception {
        Balls balls = new Balls();
        balls.add(Ball.createGreenBall());
        Rule redBallRule = new RedBallRule();
//        assertTrue(redBallRule.canBeAdded(Ball.createRedBall(),balls));
    }

    @Test
    public void should_tell_if_the_ball_can_not_be_added() throws Exception {
        Balls balls = new Balls();
        Rule redBallRule = new RedBallRule();
//        assertFalse(redBallRule.canBeAdded(Ball.createRedBall(),balls));
    }
}
