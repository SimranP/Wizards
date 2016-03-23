package balls;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class BallTest {

    @Test
    public void ball_can_create_a_ball_having_green_color() {
        assertTrue(Ball.createGreenBall().isOfColor(Color.GREEN));
    }

    @Test
    public void ball_can_create_a_ball_having_red_color() throws Exception {
        assertTrue(Ball.createRedBall().isOfColor(Color.RED));
    }

    @Test
    public void ball_can_create_a_ball_having_yellow_color() {
        assertTrue(Ball.createYellowBall().isOfColor(Color.YELLOW));
    }

    @Test
    public void ball_can_create_a_ball_having_blue_color() throws Exception {
        assertTrue(Ball.createBlueBall().isOfColor(Color.BLUE));
    }

    @Test
    public void is_of_color_tells_if_ball_is_of_given_color() throws Exception {
        assertTrue(Ball.createGreenBall().isOfColor(Color.GREEN));
    }

    @Test
    public void is_of_color_tells_if_ball_is_not_of_given_color() throws Exception {
        assertFalse(Ball.createGreenBall().isOfColor(Color.RED));
    }
}