package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.OneArgCommand;

public class RemoveByIdCommand implements OneArgCommand {
    private final Receiver receiver;

    public RemoveByIdCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(String arg) {
        long id = Long.parseLong(arg);
        return this.receiver.removeByIDAction(id);
    }
}
