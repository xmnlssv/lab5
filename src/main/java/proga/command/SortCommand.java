package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.NoArgsCommand;

public class SortCommand implements NoArgsCommand {
    private final Receiver receiver;

    public SortCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return this.receiver.sortAction();
    }
}
