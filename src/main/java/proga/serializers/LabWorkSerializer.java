package proga.serializers;

import proga.aplication.DateAdapter;
import proga.models.*;

import java.time.ZonedDateTime;

public class LabWorkSerializer {
    public static String serialize(LabWork labWork) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(labWork.getID()).append(",")
                .append(labWork.getName()).append(",")
                .append(labWork.getCoordinates().getX()).append(",")
                .append(labWork.getCoordinates().getY()).append(",")
                .append(labWork.getCreationDate()).append(",")
                .append(labWork.getMinimalPoint()).append(",")
                .append(labWork.getDifficulty()).append(",")
                .append(labWork.getAuthor().getName()).append(",")
                .append(labWork.getAuthor().getPassportID()).append(",")
                .append(labWork.getAuthor().getEyeColor()).append(",")
                .append(labWork.getAuthor().getHairColor()).append(",")
                .append(labWork.getAuthor().getNationality()).append(",")
                .append(labWork.getAuthor().getLocation().getX()).append(",")
                .append(labWork.getAuthor().getLocation().getY()).append(",")
                .append(labWork.getAuthor().getLocation().getZ());
        return stringBuilder.toString();
    }

    public static LabWork deserialize(String stringLabWork) {
        String[] splitString = stringLabWork.split(",");
        long id = Long.parseLong(splitString[0]);
        String name = splitString[1];
        Double xCoordinate = Double.parseDouble(splitString[2]);
        Long yCoordinate = Long.parseLong(splitString[3]);
        Coordinates coordinates = new Coordinates(xCoordinate, yCoordinate);
        ZonedDateTime zonedDateTime;
        zonedDateTime = DateAdapter.unmarshal(splitString[4]);
        double minimalPoint = Double.parseDouble(splitString[5]);
        Difficulty difficulty = Difficulty.valueOf(splitString[6]);
        String authorName = splitString[7];
        String passportID = splitString[8];
        EyeColor eyeColor = EyeColor.valueOf(splitString[9]);
        HairColor hairColor = HairColor.valueOf(splitString[10]);
        Country nationality = Country.valueOf(splitString[11]);
        Float xLocation = Float.parseFloat(splitString[12]);
        Integer yLocation = Integer.parseInt(splitString[13]);
        Long zLocation = Long.parseLong(splitString[14]);
        Location location = new Location(xLocation, yLocation, zLocation);
        Person author = new Person(authorName, passportID, eyeColor, hairColor, nationality, location);
        LabWork labWork = new LabWork(id, name, coordinates, zonedDateTime, minimalPoint, difficulty, author);
        return labWork;
    }
}
