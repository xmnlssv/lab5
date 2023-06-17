package proga.aplication;

import proga.command.*;
import proga.inputUtils.IDGenerator;
import proga.inputUtils.InputReader;
import proga.models.LabWork;
import proga.models.Person;
import proga.serializers.AuthorSerializer;
import proga.serializers.LabWorkSerializer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Represents receiver.
 */
public class Receiver {
    private final CollectionWorker collectionWorker;
    public static final Set<String> CALL_STACK = new LinkedHashSet<>();

    public Receiver(CollectionWorker collectionWorker) {
        this.collectionWorker = collectionWorker;
    }

    public String addAction(LabWork labWork) {
        ArrayList<LabWork> collection = this.collectionWorker.getCollection();
        collection.add(labWork);
        IDGenerator.saveId(labWork.getID());
        return "Element has been added!\n";
    }

    public String clearAction() {
        ArrayList<LabWork> collection = this.collectionWorker.getCollection();
        if (collection.size() == 0) {
            return "The collection is already empty\n";
        } else {
            collection.clear();
            IDGenerator.removeAllIds();
        }
        return "Element has been cleared!\n";
    }

    public String descendingMinimalPointAction() {
        ArrayList<LabWork> collection = this.collectionWorker.getCollection();
        collection.sort(new Comparator<>() {
            @Override
            public int compare(LabWork o1, LabWork o2) {
                return (int) (o2.getMinimalPoint() - o1.getMinimalPoint());
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (LabWork labWork : collection) {
            stringBuilder.append(labWork.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public String executeScriptAction(String pathToScript) {
        if (!CALL_STACK.contains(pathToScript)) {
            CALL_STACK.add(pathToScript);
            // do script
            StringBuilder results = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(pathToScript));
                String[] splitCommand;
                String command;
                InputReader inputReader = new InputReader(this.collectionWorker);
                while ((command = reader.readLine()) != null) {
                    splitCommand = command.trim().toLowerCase().split(" ", 2);
                    switch (splitCommand[0]) {
                        case "help":
                            results.append(new HelpCommand(new Receiver(this.collectionWorker)).execute())
                                    .append("\n");
                            break;
                        case "info":
                            results.append(new InfoCommand(new Receiver(this.collectionWorker)).execute())
                                    .append("\n");
                            break;
                        case "show":
                            results.append(new ShowCommand(new Receiver(this.collectionWorker)).execute())
                                    .append("\n");
                            break;
                        case "add":
                            results.append(new AddCommand(new Receiver(this.collectionWorker))
                                            .execute(LabWorkSerializer.serialize(inputReader.receiveLabWork())))
                                    .append("\n");
                            break;
                        case "update":
                            results.append(new UpdateCommand(new Receiver(this.collectionWorker), this.collectionWorker)
                                            .execute(splitCommand[1])).append("\n");
                            break;
                        case "remove_by_id":
                            results.append(new RemoveByIdCommand(new Receiver(this.collectionWorker))
                                    .execute(splitCommand[1])).append("\n");
                            break;
                        case "clear":
                            results.append(new ClearCommand(new Receiver(this.collectionWorker)).execute())
                                    .append("\n");
                            break;
                        case "save":
                            results.append(new SaveCommand(new Receiver(this.collectionWorker)).execute())
                                    .append("\n");
                            break;
                        case "execute_script":
                            results.append(new ExecuteScriptCommand(new Receiver(this.collectionWorker))
                                    .execute(splitCommand[1])).append("\n");
                            System.out.println("This script cannot to contain this command.");
                            break;
                        case "exit":
                            results.append(new ExitCommand(new Receiver(this.collectionWorker)).execute())
                                    .append("\n");
                        case "min_by_author":
                            results.append(new MinByAuthorCommand(new Receiver(this.collectionWorker)).
                                    execute()).append("\n");
                            break;
                        case "remove_greater":
                            results.append(new RemoveGreaterCommand(new Receiver(this.collectionWorker))
                                            .execute(splitCommand[1])).append("\n");
                            break;
                        case "remove_last":
                            results.append(new RemoveLastCommand(new Receiver(this.collectionWorker))
                                            .execute()).append("\n");
                            break;
                        case "descending_minimal_point":
                            results.append(new DescendingMinimalPointCommand(
                                    new Receiver(this.collectionWorker))
                                    .execute()).append("\n");
                            break;
                        case "remove_by_author":
                            results.append(new RemoveByAuthorCommand(new Receiver(this.collectionWorker))
                                            .execute(AuthorSerializer.serialize(inputReader.receiveAuthor())))
                                    .append("\n");
                            break;
                        case "sort":
                            results.append(new SortCommand(new Receiver(this.collectionWorker)).execute())
                                    .append("\n");
                            break;
                        default:
                            reader.readLine();
                            break;
                    }
                }
            } catch (FileNotFoundException fileNotFoundException) {
                return "File with script not found. Check path to script and try again.\n";
            } catch (IOException ioException) {
                return "File reading problems. Try to check file permissions or syntax and try again.\n";
            }
            CALL_STACK.remove(pathToScript);
            return results.toString();
        } else {
            return "Ring recursion detected. Script executing aborted.\n";
        }
    }
    public String exitAction() {
        System.out.println("Finishing a program...");
        System.exit(0);
        return "Program finished!\n";
    }

    public String helpAction() {
        Map<String, String> command = collectionWorker.getCommands();
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : command.entrySet()) {
            String key = String.format("%-43s", entry.getKey());
            String value = String.format(" : %1$s", entry.getValue());
            result.append(key).append(value).append("\n");
        }
        return result.toString();
    }

    public String infoAction() {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<LabWork> collection = this.collectionWorker.getCollection();
        stringBuilder.append("Type of collection: ").append(collection.getClass()).append("\n");
        stringBuilder.append("Date of initialization: ").append(this.collectionWorker.getInitTime()).append("\n");
        stringBuilder.append("Amount of elements: ").append(collection.size()).append("\n");
        return stringBuilder.toString();
    }

    public String minByAuthorAction() {
        try {
            ArrayList<LabWork> collection = this.collectionWorker.getCollection();
            Collections.sort(collection);
            return "Minimal item of collection:" + collection.get(0).toString();
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return "Missing items in the collection. Please add items.";
        }
    }

    public String removeByAuthorAction(Person author) {
        ArrayList<LabWork> collection = this.collectionWorker.getCollection();
        boolean found = false;
        for (LabWork labWork : collection) {
            if (labWork.getAuthor().equals(author)) {
                collection.remove(labWork);
                IDGenerator.removeId(labWork.getID());
                found = true;
                System.out.println(labWork.getAuthor().toString());
                break;
            }
        }

        if (found) {
            return "Element removed!\n";
        } else {
            return "Element has not been removed, because entered Author is not exists\n";
        }
    }

    public String removeByIDAction(long id) {
        ArrayList<LabWork> collection = this.collectionWorker.getCollection();
        boolean found = false;
        for (LabWork labWork : collection) {
            if (labWork.getID() == id) {
                collection.remove(labWork);
                IDGenerator.removeId(id);
                found = true;
                break;
            }
        }
        if (found == true) {
            return "Element has been removed!\n";
        } else {
            return "Element has not been removed, because entered ID is not exists\n";
        }
    }

    public String removeGreaterAction(long id) {
        ArrayList<LabWork> collection = this.collectionWorker.getCollection();
        Iterator<LabWork> labWorkIterator = collection.iterator();
        while(labWorkIterator.hasNext()) {
            LabWork nextLabWork = labWorkIterator.next();
            if (nextLabWork.getID() > id) {
                labWorkIterator.remove();
                IDGenerator.removeId(nextLabWork.getID());
            }
        }
        return "All items in the collection that have an id greater than the specified id are removed\n";
    }

    public String removeLastAction() {
        ArrayList<LabWork> collection = this.collectionWorker.getCollection();
        if (collection.size() != 0) {
            for (LabWork labWork : collection) {
                if (collection.get(collection.size() - 1).equals(labWork)) {
                    collection.remove(labWork);
                    IDGenerator.removeId(labWork.getID());
                    return "Last element removed!\n";
                }
            }
        }
        return "Element has not been removed, because collection is empty\n";
    }

    public String saveAction() {
        return this.collectionWorker.save();
    }

    public String showAction() {
        ArrayList<LabWork> collection = this.collectionWorker.getCollection();
        StringBuilder stringBuilder = new StringBuilder();
        for (LabWork labWork : collection) {
            stringBuilder.append(labWork.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public String sortAction() {
        ArrayList<LabWork> collection = this.collectionWorker.getCollection();
        Collections.sort(collection);
        return "Collection sorted!\n";
    }

    public String updateAction(long id, LabWork updatedLabWork) {
        ArrayList<LabWork> collection = this.collectionWorker.getCollection();
        for (LabWork labWork : collection) {
            if (labWork.getID() == id) {
                collection.remove(labWork);
                updatedLabWork.setID(id);
                collection.add(updatedLabWork);
                return "Element has been updated!\n";
            }
        }
        return "";
    }
}
