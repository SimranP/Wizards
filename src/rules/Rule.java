package rules;

import balls.Ball;
import balls.Balls;

public interface Rule {
    void canBeAdded(Ball ball, Balls balls);
}
