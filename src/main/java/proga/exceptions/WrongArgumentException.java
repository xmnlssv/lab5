package proga.exceptions;

public class WrongArgumentException extends Exception{
    public WrongArgumentException(String message) {
        super("! " + message + " !");
    }
}
