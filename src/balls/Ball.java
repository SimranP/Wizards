package balls;


public class Ball {
    private Color color;

    public Ball(Color color) {
        this.color = color;
    }

    public static Ball createGreenBall() {
        return new Ball(Color.GREEN);
    }

    public static Ball createRedBall() {
        return new Ball(Color.RED);
    }

    public static Ball createYellowBall() {
        return new Ball(Color.YELLOW);
    }

    public static Ball createBlueBall() {
        return new Ball(Color.BLUE);
    }

    public boolean isOfColor(Color color) {
        return this.color.equals(color);
    }

}
