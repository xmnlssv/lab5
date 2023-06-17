package proga.aplication;


import proga.command.*;
import proga.inputUtils.IDGenerator;
import proga.inputUtils.InputReader;

/**
 * Represents invoker.
 */
public class Invoker {
    private final CollectionWorker collectionWorker;

    public Invoker(CollectionWorker collectionWorker, InputReader inputReader) {
        this.collectionWorker = collectionWorker;
    }

    public Invoker(CollectionWorker collectionWorker) {
        this.collectionWorker = collectionWorker;
    }

    public String add(String arg) {
        return new AddCommand(new Receiver(this.collectionWorker)).execute(arg);
    }

    public String clear() {
        return new ClearCommand(new Receiver(this.collectionWorker)).execute();
    }

    public String descendingMinimalPoint() {
        return new DescendingMinimalPointCommand(new Receiver(this.collectionWorker)).execute();
    }

    public String executeScript(String arg) {
        return new ExecuteScriptCommand(new Receiver(this.collectionWorker)).execute(arg);
    }
    public String exit() {
        return new ExitCommand(new Receiver(this.collectionWorker)).execute();
    }

    public String help() {
        return new HelpCommand(new Receiver(this.collectionWorker)).execute();
    }

    public String info() {
        return new InfoCommand(new Receiver(this.collectionWorker)).execute();
    }

    public String minByAuthor() {
        return new MinByAuthorCommand(new Receiver(this.collectionWorker)).execute();
    }

    public String removeByAuthor(String arg) {
        return new RemoveByAuthorCommand(new Receiver(this.collectionWorker)).execute(arg);
    }

    public String removeById(String arg) {
        return new RemoveByIdCommand(new Receiver(this.collectionWorker)).execute(arg);
    }

    public String removeGreater(String arg) {
        return new RemoveGreaterCommand(new Receiver(this.collectionWorker)).execute(arg);
    }

    public String removeLast() {
        return new RemoveLastCommand(new Receiver(this.collectionWorker)).execute();
    }

    public String save() {
        return new SaveCommand(new Receiver(this.collectionWorker)).execute();
    }

    public String show() {
        return new ShowCommand(new Receiver(this.collectionWorker)).execute();
    }

    public String sort() {
        return new SortCommand(new Receiver(this.collectionWorker)).execute();
    }

    public String update(String arg1) {
        return new UpdateCommand(new Receiver(this.collectionWorker), this.collectionWorker).execute(arg1);
    }
}
