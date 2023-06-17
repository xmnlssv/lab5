package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.NoArgsCommand;

public class ShowCommand implements NoArgsCommand {

    private final Receiver receiver;

    public ShowCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return this.receiver.showAction();
    }
}
