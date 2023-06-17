package proga.models;

import java.util.Objects;

/**
 * Represents a person
 */
public class Person implements Comparable<Person> {
    /**
     * The name of the author. Cannot be null or an empty string.
     */
    private String name; // not null, not empty

    /**
     * The passportID of the author. Length of the string must not be less than 6,
     * Length of the string must not be greater than 37, The value of this field must be unique, the field can be null
     */
    private String passportID; // Length of the string must not be less than 6,
    // Length of the string must not be greater than 37, The value of this field must be unique, the field can be null

    /**
     * The eye color of the author. Cannot be null.
     */
    private EyeColor eyeColor; // not null

    /**
     * The hair color of the author. Cannot be null.
     */
    private HairColor hairColor; // not null

    /**
     * The nationality of the author. Cannot be null.
     */
    private Country nationality; // not null

    /**
     * The location of the author. Cannot be null.
     */
    private Location location; // not null

    public Person() {}
    public Person(LabWork.LabWorkBuilder labWorkBuilder) {
    }

    /**
     * Sets the person's name and passportID and eye color and hair color and nationality and location
     *
     * @param name        the name of the person
     * @param passportID  the passportID of the person
     * @param eyeColor    the eye color of the person
     * @param hairColor   the hair color of the person
     * @param nationality the nationality of the person
     * @param location    the location of the person
     */
    public Person(String name, String passportID, EyeColor eyeColor, HairColor hairColor, Country nationality,
                  Location location) {// throws WrongArgumentException {
//        checkArguments(name, passportID, eyeColor, hairColor, nationality, location);
        this.name = name;
        this.passportID = passportID;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    /**
     * Return the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the passportID of the person.
     *
     * @return the passportID of the person
     */
    public String getPassportID() {
        return passportID;
    }

    /**
     * Sets the passportID of the person.
     *
     * @param passportID the passportID of the person
     */
    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    /**
     * Return the eye color of the person.
     *
     * @return the eye color of the person
     */
    public EyeColor getEyeColor() {
        return eyeColor;
    }

    /**
     * Sets the eye color of the person.
     *
     * @param eyeColor the eye color of the person
     */
    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Return the hair color of the person.
     *
     * @return the hair color of the person
     */
    public HairColor getHairColor() {
        return hairColor;
    }

    /**
     * Sets the hair color of the person.
     *
     * @param hairColor the hair color of the person
     */
    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Return the nationality of the person.
     *
     * @return the nationality of the person
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality of the person.
     *
     * @param nationality the nationality of the person
     */
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    /**
     * Returns the location of the person.
     *
     * @return the location of the person
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the location of the person.
     *
     * @param location the location of the person
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Objects.equals(name, person.name)) return false;
        if (!Objects.equals(passportID, person.passportID)) return false;
        if (eyeColor != person.eyeColor) return false;
        if (hairColor != person.hairColor) return false;
        if (nationality != person.nationality) return false;
        return Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passportID != null ? passportID.hashCode() : 0);
        result = 31 * result + (eyeColor != null ? eyeColor.hashCode() : 0);
        result = 31 * result + (hairColor != null ? hairColor.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return a string representation of the person
     */
    @Override
    public String toString() {
        return "Author{" +
                ", name ='" + name + '\'' +
                ", passportID='" + passportID + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", nationality='" + nationality + '\'' +
                ", location='" + location + '\'' +
                '}';
    }


    @Override
    public int compareTo(Person o) {
        return this.getPassportID().length() - o.getPassportID().length();
    }

}

