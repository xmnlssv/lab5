package proga;

import proga.aplication.CollectionWorker;
import proga.aplication.CommandReader;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String givenPathToFile = System.getenv("PATH999");
            CollectionWorker collectionWorker = new CollectionWorker(givenPathToFile);
            System.out.println("Type any command. Type [help] for receiving list of available commands " +
                    "and it's descriptions");
            System.out.println("Type [exit] during command entering or click [ctrl + D] at any moment " +
                    "to over the program");
            new CommandReader(CollectionWorker.getInstance(givenPathToFile)).run();
        } catch (NullPointerException nullPointerException) {
            System.err.println("You forgot type path to file with collection as an environment variable.");
            System.err.println("Restart the program with environment variable.");
        }
    }
}