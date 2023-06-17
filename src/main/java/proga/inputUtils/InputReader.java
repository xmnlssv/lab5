package proga.inputUtils;

import proga.aplication.CollectionWorker;
import proga.models.*;
import proga.models.helpers.LabWorkArgumentChecker;
import proga.models.helpers.PersonArgumentChecker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class InputReader {
    private final CollectionWorker collectionWorker;
//    private static Map<Integer, EyeColor> mapEyeColor;
//    private static Map<Integer, HairColor> mapHairColor;
//    private static Map<Integer, Difficulty> mapDifficulty;
//    private static Map<Integer, Country> mapNationality;
    private static final Scanner SCANNER = new Scanner(System.in);

    public InputReader(CollectionWorker collectionWorker) {
        this.collectionWorker = collectionWorker;
    }

//    private static void initializeMapEyeColor() {
//        mapEyeColor = new HashMap<>();
//        mapEyeColor.put(1, EyeColor.BLUE);
//        mapEyeColor.put(2, EyeColor.YELLOW);
//        mapEyeColor.put(3, EyeColor.ORANGE);
//        mapEyeColor.put(4, EyeColor.WHITE);
//    }
//
//    private static void initializeMapHairColor() {
//        mapHairColor = new HashMap<>();
//        mapHairColor.put(1, HairColor.GREEN);
//        mapHairColor.put(2, HairColor.BLUE);
//        mapHairColor.put(3, HairColor.YELLOW);
//        mapHairColor.put(4, HairColor.ORANGE);
//        mapHairColor.put(5, HairColor.WHITE);
//    }
//
//    private static void initializeMapDifficulty() {
//        mapDifficulty = new HashMap<>();
//        mapDifficulty.put(1, Difficulty.EASY);
//        mapDifficulty.put(2, Difficulty.NORMAL);
//        mapDifficulty.put(3, Difficulty.IMPOSSIBLE);
//        mapDifficulty.put(4, Difficulty.INSANE);
//    }
//
//    private static void initializeMapNationality() {
//        mapNationality = new HashMap<>();
//        mapNationality.put(1, Country.UNITED_KINGDOM);
//        mapNationality.put(2, Country.FRANCE);
//        mapNationality.put(3, Country.INDIA);
//        mapNationality.put(4, Country.SOUTH_KOREA);
//    }

    public String receiveName() {
        String name = "";
        while (true) {
            System.out.println("Enter a name of lab work:");
            name = InputReader.SCANNER.nextLine();
            if (LabWorkArgumentChecker.checkName(name)) {
                break;
            } else {
                System.out.println("Value of name is incorrect. It should not empty and not null. Try again.");
            }
        }
        return name;
    }

    public Double receiveX() {
        Scanner scanner = new Scanner(System.in);
        Double x = null;
        while (true) {
            System.out.println("Enter x coordinate. It can be greater than -112 and cannot be null.");
            x = InputReader.SCANNER.nextDouble();
            if (LabWorkArgumentChecker.checkXCoordinate(x)) {
                break;
            } else {
                System.out.println("Value is incorrect. It can be greater than -112 and cannot be null.");
            }
        }
        return x;
    }

    public Long receiveY() {
        Long y = 0L;
        while (true) {
            System.out.println("Enter a y-coordinate.");
            y = InputReader.SCANNER.nextLong();
            if (LabWorkArgumentChecker.checkYCoordinate(y)) {
                break;
            } else {
                System.out.println("Value is incorrect. y-coordinate cannot be null.");
            }
        }
        return y;
    }

    public Coordinates receiveCoordinates() {
        return new Coordinates(receiveX(), receiveY());
    }

    public Float receiveXLocation() {
        Float x = 0f;
        while (true) {
            System.out.println("Enter a x-location.");
            x = InputReader.SCANNER.nextFloat();
            if (PersonArgumentChecker.checkXLocation(x)) {
                break;
            } else {
                System.out.println("Value is incorrect. x-location cannot be null.");
            }
        }
        return x;
    }

    public Integer receiveYLocation() {
        Integer y = 0;
        while (true) {
            System.out.println("Enter a y-location.");
            y = InputReader.SCANNER.nextInt();
            if (PersonArgumentChecker.checkYLocation(y)) {
                break;
            } else {
                System.out.println("Value is incorrect. y-location cannot be null.");
            }
        }
        return y;
    }

    public Long receiveZLocation() {
        Long z = 0L;
        while (true) {
            System.out.println("Enter a z-location.");
            z = InputReader.SCANNER.nextLong();
            if (PersonArgumentChecker.checkZLocation(z)) {
                break;
            } else {
                System.out.println("Value is incorrect. z-location cannot be null.");
            }
        }
        return z;
    }

    public Location receiveLocation() {
        return new Location(receiveXLocation(), receiveYLocation(), receiveZLocation());
    }

    public EyeColor receiveEyeColor() {
//        InputReader.initializeMapEyeColor();
        while (true) {
            try {
                System.out.println("Choose variant of eye color. Enter color or the number corresponding" +
                        " to the desired option.");
                System.out.print("Variants: \n1. BLUE; \n2. YELLOW; \n3. ORANGE; \n4. WHITE." +
                        " \nEnter your variant here: ");
                String eyeChoose = InputReader.SCANNER.nextLine().toUpperCase(Locale.ROOT);
//                if (eyeChoose.matches("\\d+")) {
//                    return mapEyeColor.get(Integer.parseInt(eyeChoose));
//                }
//                return EyeColor.valueOf(eyeChoose);
                switch (eyeChoose) {
                    case "1":
                    case "BLUE":
                        return EyeColor.BLUE;
                    case "2":
                    case "YELLOW":
                        return EyeColor.YELLOW;
                    case "3":
                    case "ORANGE":
                        return EyeColor.ORANGE;
                    case "4":
                    case "WHITE":
                        return EyeColor.WHITE;
                    default:
                        System.out.println("You should to choose the color from list or it's number. Try again.");
                        break;
                }
            } catch (IllegalArgumentException illegalArgumentException) {
               System.out.println("You entered incorrect eye color. Choose the value from list.");
            }
        }
    }

    public HairColor receiveHairColor() {
//        InputReader.initializeMapHairColor();
        while (true) {
            try {
                System.out.println("Choose variant of hair color. Enter color or the number corresponding" +
                        " to the desired option.");
                System.out.print("Variants: \n1. GREEN; \n2. BLUE; \n3. YELLOW; \n4. ORANGE; \n5. WHITE." +
                        " \nEnter your variant here: ");
                String hairChoose = InputReader.SCANNER.nextLine().toUpperCase(Locale.ROOT);
//                if (hairChoose.matches("\\d+")) {
//                    return mapHairColor.get(Integer.parseInt(hairChoose));
//                }
//                return HairColor.valueOf(hairChoose);
                switch (hairChoose) {
                    case "1":
                    case "GREEN":
                        return HairColor.GREEN;
                    case "2":
                    case "BLUE":
                        return HairColor.BLUE;
                    case "3":
                    case "YELLOW":
                        return HairColor.YELLOW;
                    case "4":
                    case "ORANGE":
                        return HairColor.ORANGE;
                    case "5":
                    case "WHITE":
                        return HairColor.WHITE;
                    default:
                        System.out.println("You should to choose the color from list or it's number. Try again.");
                        break;
                }
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("You entered incorrect difficulty. Choose the value from list.");
            }
        }
    }

    public double receiveMinimalPoint() {
        double minimalPoint = 0.0;
        while (true) {
            System.out.println("Enter a minimal point coordinate.");
            minimalPoint = InputReader.SCANNER.nextDouble();
            if (LabWorkArgumentChecker.checkMinimalPoint(minimalPoint)) {
                break;
            } else {
                System.out.println("Value is incorrect. It can be greater than 0.");
            }
        }
        return minimalPoint;
    }

    public Difficulty receiveDifficulty() {
        String difficultyChoose = null;
//        InputReader.initializeMapDifficulty();
        while (true) {
            try {
                System.out.println("Choose variant of difficulty. Enter Difficulty or the number corresponding" +
                        " to the desired option.");
                System.out.print("Variants: \n1. EASY; \n2. NORMAL; \n3. IMPOSSIBLE; \n4. INSANE." +
                        " \nEnter your variant here: ");
                difficultyChoose = InputReader.SCANNER.nextLine().toUpperCase();
//                if (difficultyChoose.matches("\\d+")) {
//                    return mapDifficulty.get(Integer.parseInt(difficultyChoose));
//                }
//                return Difficulty.valueOf(difficultyChoose);
                switch (difficultyChoose) {
                    case "1":
                    case "EASY":
                        return Difficulty.EASY;
                    case "2":
                    case "NORMAL":
                        return Difficulty.NORMAL;
                    case "3":
                    case "IMPOSSIBLE":
                        return Difficulty.IMPOSSIBLE;
                    case "4":
                    case "INSANE":
                        return Difficulty.INSANE;
                    default:
                        System.out.println("You should to choose the color from list or it's number. Try again.");
                        break;
                }
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("You entered incorrect difficulty. Choose the value from list.");
            }
        }
    }

    public Country receiveNationality() {
        // InputReader.initializeMapNationality();
        while (true) {
            try {
                System.out.println("Choose variant of nationality. Enter Country or the number corresponding " +
                        "to the desired option.");
                System.out.print("Variants: \n1. UNITED_KINGDOM; \n2. FRANCE; \n3. INDIA; \n4. SOUTH_KOREA." +
                        " \nEnter your variant here: ");
                String nationalityChoose = InputReader.SCANNER.nextLine().toUpperCase(Locale.ROOT);
//                if (nationalityChoose.matches("\\d+")) {
//                    return mapNationality.get(Integer.parseInt(nationalityChoose));
//                }
//                return Country.valueOf(nationalityChoose);
                switch (nationalityChoose) {
                    case "1":
                    case "UNITED_KINGDOM":
                        return Country.UNITED_KINGDOM;
                    case "2":
                    case "FRANCE":
                        return Country.FRANCE;
                    case "3":
                    case "INDIA":
                        return Country.INDIA;
                    case "4":
                    case "SOUTH_KOREA":
                        return Country.SOUTH_KOREA;
                    default:
                        System.out.println("You should to choose the color from list or it's number. Try again.");
                        break;
                }
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("You entered incorrect difficulty. Choose the value from list.");
            }
        }
    }

    public String receiveAuthorName() {
        String authorName = null;
        while (true) {
            System.out.println("Enter a author name of lab work:");
            authorName = InputReader.SCANNER.nextLine();
            if (PersonArgumentChecker.checkName(authorName)) {
                break;
            } else {
                System.out.println("Value of author name is incorrect. It should not empty and not null. Try again.");
            }
        }
        return authorName;
    }

    public String receivePassportID() {
        String passportID = "";
        while (true) {
            System.out.println("Enter a passportID of lab work:");
            passportID = InputReader.SCANNER.nextLine();
            if (PersonArgumentChecker.checkName(passportID)) {
                break;
            } else {
                System.out.println("String length must be at least 6. String length must not be longer than 37. " +
                        "The value of this field must be unique. Value of passportID is incorrect." +
                        " It should not empty and not null. Try again.");
            }
        }
        return passportID;
    }

    public Person receiveAuthor() {
        return new Person(receiveAuthorName(), receivePassportID(), receiveEyeColor(), receiveHairColor(),
                receiveNationality(), receiveLocation());
    }

    public LabWork receiveLabWork() {
        return new LabWork.LabWorkBuilder()
                .id()
                .name(receiveName())
                .coordinates(receiveCoordinates())
                .creationDate()
                .minimalPoint(receiveMinimalPoint())
                .difficulty(receiveDifficulty())
                .author(receiveAuthor())
                .build();
    }
}
