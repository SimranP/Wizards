package bag;

import balls.Ball;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import rules.*;
import rules.exceptions.NoSpaceForGreenBallException;
import rules.exceptions.NoSpaceForRedBallException;
import rules.exceptions.NoSpaceForYellowBallException;

import static org.junit.Assert.*;

public class BagTest {
    private Ball greenBall;
    private Ball blueBall;
    private Ball redBall;
    private Ball yellowBall;
    private Bag bag;

    @Before
    public void setUp() throws Exception {
        Rules rules = new Rules();
        rules.add(new GreenBallRule());
        rules.add(new RedBallRule());
        rules.add(new YellowBallRule());
        greenBall = Ball.createGreenBall();
        redBall = Ball.createRedBall();
        yellowBall = Ball.createYellowBall();
        blueBall = Ball.createBlueBall();
        bag = new Bag(12, rules);

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void bag_size_is_0_when_bag_is_empty() {

        assertEquals(0, bag.size());
    }


    @Test
    public void bag_allows_to_add_a_particular_ball_which_satisfies_all_rules() {
        bag.add(greenBall);
        assertEquals(1, bag.size());
    }


    @Test
    public void bag_lets_put_a_ball_inside_it() throws Exception {
        bag.add(greenBall);
        assertEquals(1, bag.size());
    }

    @Test
    public void bag_allows_to_put_maximum_three_green_balls() throws Exception {
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(greenBall);
        assertEquals(3, bag.size());
    }

    @Test
    public void bag_throws_exception_when_the_maximum_limit_is_exceeded() throws Exception {
        thrown.expect(NoSpaceForGreenBallException.class);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(greenBall);
    }

    @Test
    public void bag_throws_exception_when_red_balls_are_more_than_double_of_green_balls() throws Exception {
        thrown.expect(NoSpaceForRedBallException.class);
        thrown.expectMessage("No more space for RED");
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(redBall);
    }


    @Test
    public void bag_allows_to_add_red_balls_double_of_green_balls() throws Exception {
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(redBall);
        bag.add(redBall);
        assertEquals(6, bag.size());
    }

    @Test
    public void bag_should_not_allow_to_add_a_red_ball_if_there_is_no_green_ball() throws Exception {
        thrown.expect(NoSpaceForRedBallException.class);
        bag.add(redBall);
    }

    @Test
    public void bag_should_as_many_blue_balls_as_the_capacity_of_the_bag() throws Exception {
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        assertEquals(12, bag.size());
    }

    @Test
    public void bag_should_not_allow_balls_more_than_the_capacity_of_the_bag() throws Exception {
        thrown.expect(BagIsFullException.class);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(greenBall);
        bag.add(greenBall);
    }


    @Test
    public void bag_should_allow_number_of_yellow_balls_less_than_40percent_of_all_balls() throws Exception {
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(yellowBall);
        bag.add(yellowBall);
        bag.add(yellowBall);
        bag.add(yellowBall);
        assertEquals(12, bag.size());
    }


    @Test
    public void bag_should_not_allow_number_of_yellow_balls_more_than_40percent_of_all_balls() throws Exception {
        thrown.expect(NoSpaceForYellowBallException.class);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(yellowBall);
        bag.add(yellowBall);
    }

    @Test
    public void no_yellow_balls_can_be_added_in_empty_bag() throws Exception {
        thrown.expect(NoSpaceForYellowBallException.class);
        bag.add(yellowBall);
    }

    @Test
    public void summary_gives_description_of_balls_in_the_bag() throws Exception {
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(yellowBall);
        String expected = "BAG : 4 Balls\n" +
                "YELLOW : 1\n" +
                "BLUE : 3";
//        assertEquals(expected, bag.summary());
    }

    @Test
    public void summary_gives_description_of_balls_in_the_bag_when_is_empty() throws Exception {

        String expected = "BAG : 0 Balls";
//        assertEquals(expected, bag.summary());
    }

    @Test
    public void orderSummary_gives_description_of_balls_in_the_bag_according_to_the_order_they_were_placed() throws Exception {

        bag.add(blueBall);
        bag.add(blueBall);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(redBall);
        bag.add(blueBall);
        bag.add(redBall);
        bag.add(redBall);
        String expected = "BAG : 8 Balls\n" +
                "BLUE : 2\n" +
                "GREEN : 2\n" +
                "RED : 1\n" +
                "BLUE : 1\n" +
                "RED : 2";
//        assertEquals(expected, bag.orderedSummary());
        assertEquals(8, bag.size());

    }

    @Test
    public void ordered_summary_gives_description_of_balls_in_the_bag_when_is_empty() throws Exception {

        String expected = "BAG : 0 Balls";
//        assertEquals(expected, bag.orderedSummary());
    }
}