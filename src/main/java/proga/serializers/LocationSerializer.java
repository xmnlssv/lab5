package proga.serializers;

import proga.models.LabWork;
import proga.models.Location;

public class LocationSerializer {
    public static String serialize(Location location) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(location.getX()).append("|")
                .append(location.getY()).append("|")
                .append(location.getZ());
        return stringBuilder.toString();
    }

    public static LabWork deserialize(String stringLocation) {
        String[] splitString = stringLocation.split("|");
        Float xLocation = Float.parseFloat(splitString[12]);
        Integer yLocation = Integer.parseInt(splitString[13]);
        Long zLocation = Long.parseLong(splitString[14]);
        Location location = new Location(xLocation, yLocation, zLocation);
        return null;
    }
}
