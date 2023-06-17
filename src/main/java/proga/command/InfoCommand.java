package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.NoArgsCommand;

public class InfoCommand implements NoArgsCommand {

    private Receiver receiver;

    public InfoCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return this.receiver.infoAction();
    }

}
