import java.util.HashMap;

/* Job Of Bag--
       - throws exception where rules are broken.
*/

public class Bag {

    private final HashMap<Ball, Integer> balls;
    private int capacity;

    public Bag() {
        this.capacity = 12;
        balls = new HashMap<>(capacity);
    }

    public int noOfBalls(Ball color) {
        if (balls.containsKey(color))
            return balls.get(color);
        return 0;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        int size = 0;
        for (Ball color : balls.keySet()) {
            size += balls.get(color);
        }
        return size;
    }

    public void putBall(Ball color) {
        if (validateColor(color))
            balls.put(color, noOfBalls(color) + 1);
        else
            throw new NoSpaceForColorException(color.name());
    }

    public HashMap<Ball, Integer> ballTracker() {
        HashMap<Ball, Integer> ballTracker = new HashMap<>();
        ballTracker.put(Ball.Green, 3);
        ballTracker.put(Ball.Red, 2 * noOfBalls(Ball.Green));
        ballTracker.put(Ball.Blue, 12 - (noOfBalls(Ball.Green) + noOfBalls(Ball.Red)));
        return ballTracker;
    }

    private boolean validateColor(Ball color) {
        HashMap<Ball, Integer> rules = ballTracker();
        return noOfBalls(color) < rules.get(color) && capacity > size();
    }
}
