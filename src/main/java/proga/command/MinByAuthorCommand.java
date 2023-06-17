package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.NoArgsCommand;

public class MinByAuthorCommand implements NoArgsCommand {
    Receiver receiver;

    public MinByAuthorCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return this.receiver.minByAuthorAction();
    }
}
