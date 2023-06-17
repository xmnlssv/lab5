package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.NoArgsCommand;

public class RemoveLastCommand implements NoArgsCommand {
    Receiver receiver;

    public RemoveLastCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return this.receiver.removeLastAction();
    }
}
