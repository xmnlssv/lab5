package proga.inputUtils;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class IDGenerator {
    public static final Set<Long> IDs = new LinkedHashSet<>();

    private IDGenerator() {}

    public static void saveId(long id) {
        IDs.add(id);
    }

    public static void removeId(long id) {
        IDs.remove(id);
    }

    public static void removeAllIds() {
        IDs.clear();
    }

    public static boolean checkIfIDUnique(long id) {
        return !IDs.contains(id);
    }

    public static long generateID() {
        Random rand = new Random();
        int upperbound = 9999999;
        int int_random = rand.nextInt(upperbound);
        return int_random;
    }
}
