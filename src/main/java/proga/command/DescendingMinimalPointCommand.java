package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.NoArgsCommand;

public class DescendingMinimalPointCommand implements NoArgsCommand {
    private final Receiver receiver;

    public DescendingMinimalPointCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return this.receiver.descendingMinimalPointAction();

    }
}
