import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BagTest {

    @Rule
    public ExpectedException thrown =  ExpectedException.none();

    @Test
    public void bag_should_have_capacity_of_12() throws Exception {
        Bag bag = new Bag();
        assertEquals(12,bag.capacity());
    }

    @Test
    public void bag_lets_put_a_ball_inside_it() throws Exception {
        Bag bag = new Bag();
        bag.putBall(Ball.Green);
        assertEquals(1,bag.size());
    }

    @Test
    public void bag_allows_to_put_maximum_three_green_balls() throws Exception {
        Bag bag = new Bag();
        bag.putBall(Ball.Green);
        bag.putBall(Ball.Green);
        bag.putBall(Ball.Green);
        assertEquals(3,bag.size());
    }

    @Test
    public void bag_throws_exception_when_the_maximum_limit_is_exceeded() throws Exception {
        thrown.expect(NoSpaceForColorException.class);
        Bag bag = new Bag();
        bag.putBall(Ball.Green);
        bag.putBall(Ball.Green);
        bag.putBall(Ball.Green);
        bag.putBall(Ball.Green);
    }

    @Test
    public void bag_throws_exception_when_red_balls_are_more_than_double_of_green_balls() throws Exception {
        thrown.expect(NoSpaceForColorException.class);
        thrown.expectMessage("No more space for Red");
        Bag bag = new Bag();
        bag.putBall(Ball.Green);
        bag.putBall(Ball.Green);
        bag.putBall(Ball.Red);
        bag.putBall(Ball.Red);
        bag.putBall(Ball.Red);
        bag.putBall(Ball.Red);
        bag.putBall(Ball.Red);
    }


    @Test
    public void bag_allows_to_add_red_balls_double_of_green_balls() throws Exception {
        Bag bag = new Bag();
        bag.putBall(Ball.Green);
        bag.putBall(Ball.Green);
        bag.putBall(Ball.Red);
        bag.putBall(Ball.Red);
        bag.putBall(Ball.Red);
        bag.putBall(Ball.Red);
        assertEquals(6,bag.size());
    }

    @Test
    public void bag_should_not_allow_to_add_a_red_ball_if_there_is_no_green_ball() throws Exception {
        thrown.expect(NoSpaceForColorException.class);
        Bag bag = new Bag();
        bag.putBall(Ball.Red);
    }

    @Test
    public void bag_should_as_many_blue_balls_as_the_capacity_of_the_bag() throws Exception {
        Bag bag = new Bag();
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        assertEquals(12,bag.size());
    }

    @Test
    public void bag_should_not_allow_balls_more_than_the_capacity_of_the_bag() throws Exception {
        thrown.expect(NoSpaceForColorException.class);
        Bag bag = new Bag();
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Blue);
        bag.putBall(Ball.Green);
    }
}
