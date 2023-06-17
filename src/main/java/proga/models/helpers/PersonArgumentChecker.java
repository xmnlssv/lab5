package proga.models.helpers;

import proga.exceptions.WrongArgumentException;
import proga.models.*;

/**
 * Represents person argument check.
 */
public class PersonArgumentChecker extends ArgumentChecker{
    public static boolean checkPersonArguments(Person person) {
        return checkPassportID(person.getPassportID()) && checkName(person.getName()) &&
                checkEyeColor(person.getEyeColor()) && checkHairColor(person.getHairColor()) &&
                checkCountry(person.getNationality()) && checkLocation(person.getLocation());
    }

    public static boolean checkName(String name) {
        try {
            checkNull(name, "name");
            checkArgument(!name.equals(""), "name cannot be empty");
            return true;
        } catch (WrongArgumentException wrongArgumentException) {
            return false;
        }
    }

    public static boolean checkPassportID(String passportID) {
        try {
            if (passportID != null) {
                checkArgument(6 < passportID.length(), "passportID string length cannot be < 6");
                checkArgument(passportID.length() > 37, "passportID string length cannot be > 37");
                return true;
            } else return false;
        } catch (WrongArgumentException wrongArgumentException) {
            return false;
        }
    }

    public static boolean checkEyeColor(EyeColor eyeColor) {
        try {
            checkNull(eyeColor, "eyeColor");
            return true;
        } catch (WrongArgumentException wrongArgumentException) {
            return false;
        }
    }

    public static boolean checkHairColor(HairColor hairColor) {
        try {
            checkNull(hairColor, "hairColor");
            return true;
        } catch (WrongArgumentException wrongArgumentException) {
            return false;
        }
    }

    public static boolean checkCountry(Country nationality) {
        try {
            checkNull(nationality, "nationality");
            return true;
        } catch (WrongArgumentException wrongArgumentException) {
            return false;
        }
    }

    public static boolean checkXLocation(Float x) {
        return x != null;
    }

    public static boolean checkYLocation(Integer y) {
        return y != null;
    }

    public static boolean checkZLocation(Long z) {
        return z != null;
    }

    public static boolean checkLocation(Location location) {
        try {
            checkNull(location, "location");
            return checkXLocation(location.getX()) && checkYLocation(location.getY()) && checkZLocation(location.getZ());
        } catch (WrongArgumentException wrongArgumentException) {
            return false;
        }
    }
}
