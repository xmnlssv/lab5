package proga.models.helpers;

import proga.exceptions.WrongArgumentException;

/**
 * Represents argument check.
 */
public class ArgumentChecker {
    public static void checkNull(Object argument, String argumentName) throws WrongArgumentException {
        checkArgument(argument != null, argumentName + " cannot be null");
    }

    public static void checkArgument(boolean statement, String message) throws WrongArgumentException {
        if (!statement) {
            throw new WrongArgumentException(message);
        }
    }
}
