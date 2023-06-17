package proga.models.helpers;

import proga.exceptions.WrongArgumentException;
import proga.inputUtils.IDGenerator;
import proga.models.Coordinates;
import proga.models.Difficulty;
import proga.models.LabWork;
import proga.models.Person;

import java.util.Objects;

/**
 * Represents lab work argument check.
 */

public class LabWorkArgumentChecker extends ArgumentChecker {
//    public static boolean checkLabWorkArguments(LabWork labWork) {
//        return checkID(labWork.getID()) && checkName(labWork.getName()) && checkCoordinates(labWork.getCoordinates()) &&
//                checkMinimalPoint(labWork.getMinimalPoint()) && checkDifficulty(labWork.getDifficulty()) &&
//                checkAuthor(labWork.getAuthor());
//    }

    public static boolean checkName(String name) {
        try {
            checkNull(name, "name");
            checkArgument(!Objects.equals(name, ""), "name cannot be empty");
            return true;
        } catch (WrongArgumentException wrongArgumentException) {
            return false;
        }
    }

    public static boolean checkXCoordinate(Double x) {
        return x != null && x > -112;
    }

    public static boolean checkYCoordinate(Long y) {
        return y != null;
    }

    public static boolean checkMinimalPoint(double minimalPoint) {
        try {
            checkArgument(minimalPoint > 0, "minimalPoint cannot be <= 0");
            return true;
        } catch (WrongArgumentException wrongArgumentException) {
            return false;
        }
    }
}
