package proga.aplication;

import proga.inputUtils.InputReader;
import proga.serializers.AuthorSerializer;
import proga.serializers.LabWorkSerializer;

import java.util.*;


public class CommandReader {
    private String command = "";
    private final CollectionWorker collectionWorker;
    //private final Map<String, String> tutorial;

    public CommandReader(CollectionWorker collectionWorker) {
        this.collectionWorker = collectionWorker;
//        InputReader inputReader = new InputReader(this.collectionWorker);
//        String[] splitCommand = command.trim().toLowerCase().split(" ", 2);
//        Invoker invoker = new Invoker(this.collectionWorker);
//        tutorial = new HashMap<>();
//        tutorial.put("help", invoker.help());
//        tutorial.put("info", invoker.info());
//        tutorial.put("show", invoker.show());
//        tutorial.put("add", invoker.add(LabWorkSerializer.serialize(inputReader.receiveLabWork())));
//        tutorial.put("update id {element}", invoker.update(splitCommand[1]));
//        tutorial.put("remove_by_id id", invoker.removeById(splitCommand[1]));
//        tutorial.put("clear", invoker.clear());
//        tutorial.put("save", invoker.save());
//        tutorial.put("execute_script filename", invoker.executeScript(splitCommand[1]));
//        tutorial.put("exit", invoker.exit());
//        tutorial.put("remove_last", invoker.removeLast());
//        tutorial.put("descending_minimal_point", invoker.descendingMinimalPoint());
//        tutorial.put("remove_greater {element}", invoker.removeGreater(splitCommand[1]));
//        tutorial.put("sort", invoker.sort());
//        tutorial.put("remove_any_by_author author", invoker.removeByAuthor(AuthorSerializer.serialize
//                (inputReader.receiveAuthor())));
//        tutorial.put("min_by_author", invoker.minByAuthor());
    }

    public void run() {
        try {
            try (Scanner commandReader = new Scanner(System.in)){
                Invoker invoker = new Invoker(this.collectionWorker);
                while(!command.equals("exit")) {
                    System.out.println("Enter a command: ");
                    command = commandReader.nextLine();
                    String[] splitCommand = command.trim().toLowerCase().split(" ", 2);
                    InputReader inputReader = new InputReader(this.collectionWorker);
//                    System.out.println(tutorial.get(command));
                    try {
                        switch (splitCommand[0]) {
                            case "":
                                break;
                            case "help":
                                System.out.println(invoker.help());
                                break;
                            case "info":
                                System.out.println(invoker.info());
                                break;
                            case "show":
                                System.out.println(invoker.show());
                                break;
                            case "add":
                                System.out.println(invoker.add(LabWorkSerializer
                                        .serialize(inputReader.receiveLabWork())));
                                break;
                            case "update":
                                System.out.println(invoker.update(splitCommand[1]));
                                break;
                            case "remove_by_id":
                                System.out.println(invoker.removeById(splitCommand[1]));
                                break;
                            case "clear":
                                System.out.println(invoker.clear());
                                break;
                            case "save":
                                System.out.println(invoker.save());
                                break;
                            case "execute_script":
                                System.out.println(invoker.executeScript(splitCommand[1]));
                                break;
                            case "exit":
                                System.out.println(invoker.exit());
                                break;
                            case "min_by_author":
                                System.out.println(invoker.minByAuthor());
                                break;
                            case "remove_greater":
                                System.out.println(invoker.removeGreater(splitCommand[1]));
                                break;
                            case "remove_last":
                                System.out.println(invoker.removeLast());
                                break;
                            case "descending_minimal_point":
                                System.out.println(invoker.descendingMinimalPoint());
                                break;
                            case "remove_any_by_author":
                                System.out.println(invoker.removeByAuthor(AuthorSerializer
                                        .serialize(inputReader.receiveAuthor())));
                                break;
                            case "sort":
                                System.out.println(invoker.sort());
                                break;
                            default:
                                System.out.println("Unknown command. Write help for getting list of available" +
                                        "commands and it's descriptions.");
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Argument of command is absent. Write help for getting list of available " +
                                "commands and it's descriptions.");
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println("You entered incorrect id. Enter id number");
                    }
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program will be finished now.");
            System.exit(0);
        }
    }
}
