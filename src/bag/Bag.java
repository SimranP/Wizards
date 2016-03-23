package bag;

import balls.Ball;
import balls.Balls;
import rules.Rule;
import rules.Rules;

public class Bag {
    private final int capacity;
    private final Rules rules;
    private Balls balls;

    public Bag(int capacity, Rules rules) {
        this.capacity = capacity;
        this.rules = rules;
        balls = new Balls();
    }

    public int size() {
        return balls.size();
    }

    public void add(Ball ball) {
        if (isFull()) throw new BagIsFullException();
        for (Rule rule : rules)
            rule.canBeAdded(ball, balls);
        balls.add(ball);
    }

    private boolean isFull() {
        return size() >= capacity;
    }
}
