public class BagIsFullException extends RuntimeException {
    public BagIsFullException() {
        super("Your bag has a maximum capacity of 12 balls");
    }
}
