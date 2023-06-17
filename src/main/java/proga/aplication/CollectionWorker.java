package proga.aplication;

import proga.models.LabWork;
import proga.serializers.CollectionSerializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The CollectionWorker class to work with a collection of lab work.
 */
public class CollectionWorker {
    private final ArrayList<LabWork> collection;
    private static CollectionWorker INSTANCE;
    private final String pathToFile;
    private final ZonedDateTime initTime;
    private final Map<String, String> commands;

    public static CollectionWorker getInstance(String pathToFile) {
        if (INSTANCE == null) {
            INSTANCE = new CollectionWorker(pathToFile);
        }
        return INSTANCE;
    }

    /**
     * Constructs a CollectionWorker object with an empty collection of lab works.
     *
     * @param givenPathToFile the path to file of the collection.
     */
    public CollectionWorker(String givenPathToFile) {
        this.pathToFile = givenPathToFile;
        initTime = ZonedDateTime.now();
        commands = new HashMap<>();
        commands.put("help", "get help on alternative commands");
        commands.put("info", "print all collection items into the string representation");
        commands.put("show", "output to the standard output stream all elements of the collection " +
                "in string representation");
        commands.put("add {element}", "add new item to collection");
        commands.put("update id {element}", "update the value of the collection element " +
                "whose ID matches the given one");
        commands.put("remove_by_id id", "remove an element from the collection by its ID");
        commands.put("clear", "remove all items from collection");
        commands.put("save", "save collection to file");
        commands.put("execute_script filename", "read and execute script from given file. " +
                "The same views are found in the script as in the interactive mode");
        commands.put("exit", "exit the program (without closing in the file)");
        commands.put("remove_last", "remove the last item from the collection");
        commands.put("remove_greater {element}", "remove all items from the collection that exceed the specified");
        commands.put("sort", "sort the collection in natural order");
        commands.put("remove_any_by_author author", "remove one item from the collection whose author field value" +
                " is equivalent to a given");
        commands.put("min_by_author", "output any object in the collection whose author field value is the minimum");
        commands.put("descending_minimal_point", "output the values of the field minimalPoint of all elements" +
                " in descending order");
        this.collection = CollectionSerializer.unmarshal(pathToFile);
    }

      public boolean checkIfIDFind(int id) {
            for (LabWork labWork: collection){
                if (labWork.getID() == id)
                    return true;

            }
            return false;
        }

    /**
     * Save a collection of lab works to the collection managed by this CollectionWorker.
     *
     * @return whether the collection is saved.
     */
    public String save() {
        try {
            String stringCollection = CollectionSerializer.marshal(this.collection);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.pathToFile));
            bufferedWriter.write(stringCollection);
            bufferedWriter.close();
            return "Collection has been saved!\n";
        } catch (IOException e) {
            return "Cannot save collection. Try again.\n";
        }
    }

    /**
     * Returns the collection of lab works by this CollectionWorker object.
     *
     * @return the collection of lab works
     */
    public ArrayList<LabWork> getCollection() {
        return collection;
    }

    public Map<String, String> getCommands() {
        return commands;
    }
    /**
     * Returns the init time of the collection.
     *
     * @return the init time of the collection
     */
    public ZonedDateTime getInitTime() {
        return initTime;
    }
}
