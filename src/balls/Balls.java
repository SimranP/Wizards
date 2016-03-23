package balls;

import java.util.ArrayList;

public class Balls {
    ArrayList<Ball> balls = new ArrayList<>();

    public void add(Ball ball) {
        balls.add(ball);
    }

    public int size() {
        return balls.size();
    }

    public int noOfBalls(Color color) {
        int count = 0;
        for (Ball ball : balls)
            if(ball.isOfColor(color))
                count++;
        return count;
    }
}
