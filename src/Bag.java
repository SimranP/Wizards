import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* Job Of Bag--
       - Throws exception where rules are broken.
       - Give the summary of balls in bag.
*/

public class Bag {
    private final ArrayList<Ball> balls;
    private int capacity;

    public Bag() {
        this.capacity = 12;
        balls = new ArrayList<>(capacity);
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return balls.size();
    }

    private int noOfBalls(Ball color) {
        int number = 0;
        for (Ball ball : balls) {
            if (ball == color)
                number++;
        }
        return number;
    }

    public void putBall(Ball color) {
        if (capacity <= size())
            throw new BagIsFullException();
        if (validateColor(color))
            balls.add(color);
        else
            throw new NoSpaceForColorException(color.name());
    }

    private HashMap<Ball, Integer> ballTracker() {
        HashMap<Ball, Integer> ballTracker = new HashMap<>();
        ballTracker.put(Ball.GREEN, 3);
        ballTracker.put(Ball.RED, 2 * noOfBalls(Ball.GREEN));
        ballTracker.put(Ball.YELLOW, (int) (0.4 * size()));
        ballTracker.put(Ball.BLUE, 12 - (noOfBalls(Ball.GREEN) + noOfBalls(Ball.RED)));
        return ballTracker;
    }

    private boolean validateColor(Ball color) {
        HashMap<Ball, Integer> rules = ballTracker();
        return noOfBalls(color) < rules.get(color);
    }

    public String summary() {
        String summary = "";
        summary += "BAG : " + size() + " Balls";
        HashSet<Ball> ballsSet = new HashSet<>(this.balls);
        for (Ball ball : ballsSet) {
            summary += "\n";
            summary += ball + " : " + noOfBalls(ball);
        }
        return summary;
    }

    public String orderedSummary() {
        ArrayList<Ball> duplicateBalls = (ArrayList<Ball>) balls.clone();
        duplicateBalls.add(Ball.NOCOLOR);
        String summary = "";
        summary += "BAG : " + size() + " Balls";
        int count = 0;
        Ball runningColor = duplicateBalls.get(0);
        for (Ball duplicateBall : duplicateBalls) {
            if (runningColor == duplicateBall)
                count++;
            else {
                summary += "\n";
                summary += runningColor + " : " + count;
                count = 0;
                count++;
                runningColor = duplicateBall;
            }
        }
        return summary;
    }
}
