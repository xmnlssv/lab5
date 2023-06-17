package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.NoArgsCommand;

public class SaveCommand implements NoArgsCommand {
    private final Receiver receiver;

    public SaveCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return this.receiver.saveAction();
    }
}
