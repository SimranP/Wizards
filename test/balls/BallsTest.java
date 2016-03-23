package balls;

import org.junit.Test;

import static org.junit.Assert.*;

public class BallsTest {
    @Test
    public void balls_can_add_a_ball_in_it() throws Exception {
        Balls balls = new Balls();
        balls.add(Ball.createGreenBall());
        assertEquals(1,balls.size());
    }

    @Test
    public void number_of_balls_tells_number_of_balls_in_thecollection_of_a_given_color() throws Exception {
        Balls balls = new Balls();
        balls.add(Ball.createGreenBall());
        assertEquals(1,balls.noOfBalls(Color.GREEN));
    }
}