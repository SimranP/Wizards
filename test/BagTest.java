import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BagTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void bag_should_have_capacity_of_12() throws Exception {
        Bag bag = new Bag();
        assertEquals(12, bag.capacity());
    }

    @Test
    public void bag_lets_put_a_ball_inside_it() throws Exception {
        Bag bag = new Bag();
        bag.putBall(Ball.GREEN);
        assertEquals(1, bag.size());
    }

    @Test
    public void bag_allows_to_put_maximum_three_green_balls() throws Exception {
        Bag bag = new Bag();
        bag.putBall(Ball.GREEN);
        bag.putBall(Ball.GREEN);
        bag.putBall(Ball.GREEN);
        assertEquals(3, bag.size());
    }

    @Test
    public void bag_throws_exception_when_the_maximum_limit_is_exceeded() throws Exception {
        thrown.expect(NoSpaceForColorException.class);
        Bag bag = new Bag();
        bag.putBall(Ball.GREEN);
        bag.putBall(Ball.GREEN);
        bag.putBall(Ball.GREEN);
        bag.putBall(Ball.GREEN);
    }

    @Test
    public void bag_throws_exception_when_red_balls_are_more_than_double_of_green_balls() throws Exception {
        thrown.expect(NoSpaceForColorException.class);
        thrown.expectMessage("No more space for RED");
        Bag bag = new Bag();
        bag.putBall(Ball.GREEN);
        bag.putBall(Ball.GREEN);
        bag.putBall(Ball.RED);
        bag.putBall(Ball.RED);
        bag.putBall(Ball.RED);
        bag.putBall(Ball.RED);
        bag.putBall(Ball.RED);
    }


    @Test
    public void bag_allows_to_add_red_balls_double_of_green_balls() throws Exception {
        Bag bag = new Bag();
        bag.putBall(Ball.GREEN);
        bag.putBall(Ball.GREEN);
        bag.putBall(Ball.RED);
        bag.putBall(Ball.RED);
        bag.putBall(Ball.RED);
        bag.putBall(Ball.RED);
        assertEquals(6, bag.size());
    }

    @Test
    public void bag_should_not_allow_to_add_a_red_ball_if_there_is_no_green_ball() throws Exception {
        thrown.expect(NoSpaceForColorException.class);
        Bag bag = new Bag();
        bag.putBall(Ball.RED);
    }

    @Test
    public void bag_should_as_many_blue_balls_as_the_capacity_of_the_bag() throws Exception {
        Bag bag = new Bag();
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        assertEquals(12, bag.size());
    }

    @Test
    public void bag_should_not_allow_balls_more_than_the_capacity_of_the_bag() throws Exception {
        thrown.expect(NoSpaceForColorException.class);
        Bag bag = new Bag();
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.GREEN);
    }


    @Test
    public void bag_should_allow_number_of_yellow_balls_less_than_40percent_of_all_balls() throws Exception {
        Bag bag = new Bag();
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.YELLOW);
        bag.putBall(Ball.YELLOW);
        bag.putBall(Ball.YELLOW);
        bag.putBall(Ball.YELLOW);
        assertEquals(12,bag.size());
    }



    @Test
    public void bag_should_not_allow_number_of_yellow_balls_more_than_40percent_of_all_balls() throws Exception {
        thrown.expect(NoSpaceForColorException.class);
        Bag bag = new Bag();
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.YELLOW);
        bag.putBall(Ball.YELLOW);
    }

    @Test
    public void no_yellow_balls_can_be_added_in_empty_bag() throws Exception {
        thrown.expect(NoSpaceForColorException.class);
        Bag bag = new Bag();
        bag.putBall(Ball.YELLOW);
    }

    @Test
    public void summary_gives_description_of_balls_in_the_bag() throws Exception {
        Bag bag = new Bag();
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.BLUE);
        bag.putBall(Ball.YELLOW);
        String expected = "BAG : 4 Balls\n"+
                            "BLUE : 3\n"+
                            "YELLOW : 1";
        assertEquals(expected,bag.summary());
    }

    @Test
    public void summary_gives_description_of_balls_in_the_bag_when_is_empty() throws Exception {
        Bag bag = new Bag();
        String expected = "BAG : 0 Balls";
        assertEquals(expected,bag.summary());
    }
}
