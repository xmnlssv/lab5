package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.NoArgsCommand;

public class ExitCommand implements NoArgsCommand {
    private final Receiver receiver;

    public ExitCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return this.receiver.exitAction();
    }
}
