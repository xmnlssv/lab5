package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.OneArgCommand;

public class RemoveGreaterCommand implements OneArgCommand {
    private final Receiver receiver;

    public RemoveGreaterCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(String arg) {
        long id = Long.parseLong(arg);
        return this.receiver.removeGreaterAction(id);
    }
}
