package proga.serializers;

import proga.models.Coordinates;

public class CoordinatesSerializer {
    public static String serialize(Coordinates coordinates) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(coordinates.getX()).append("'")
                .append(coordinates.getY()).append("'");
        return stringBuilder.toString();
    }

    public static Coordinates deserialize(String stringCoordinates) {
        String[] splitString = stringCoordinates.split("'");
        Double xCoordinate = Double.parseDouble(splitString[0]);
        Long yCoordinate = Long.parseLong(splitString[1]);
        Coordinates coordinates = new Coordinates(xCoordinate, yCoordinate);
        return coordinates;
    }
}
