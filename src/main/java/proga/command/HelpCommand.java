package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.NoArgsCommand;

public class HelpCommand implements NoArgsCommand {
    private final Receiver receiver;

    public HelpCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return this.receiver.helpAction();
    }
}
