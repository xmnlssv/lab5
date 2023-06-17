package proga.serializers;

import proga.models.*;

public class AuthorSerializer {
    public static String serialize(Person author) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(author.getName()).append(":")
                .append(author.getPassportID()).append(":")
                .append(author.getEyeColor()).append(":")
                .append(author.getHairColor()).append(":")
                .append(author.getNationality()).append(":")
                .append(author.getLocation()).append(":")
                .append(author.getLocation().getX()).append(":")
                .append(author.getLocation().getY()).append(":")
                .append(author.getLocation().getZ());
        return stringBuilder.toString();
    }

    public static Person deserialize(String stringAuthor) {
        String[] splitString = stringAuthor.split(":");
        String name = splitString[0];
        String passportID = splitString[1];
        EyeColor eyeColor = EyeColor.valueOf(splitString[2]);
        HairColor hairColor = HairColor.valueOf(splitString[3]);
        Float xLocation = Float.parseFloat(splitString[4]);
        Integer yLocation = Integer.parseInt(splitString[5]);
        Long zLocation = Long.parseLong(splitString[6]);
        Location location = new Location(xLocation, yLocation, zLocation);
        Country nationality = Country.valueOf(splitString[7]);
        Person author = new Person(name, passportID, eyeColor, hairColor, nationality, location);
        return author;
    }
}
