package homework;

public class InvalidBookArguments extends Exception {
    public InvalidBookArguments(Exception exception) {
        super("Book entry isn't valid.", exception);
    }
}
