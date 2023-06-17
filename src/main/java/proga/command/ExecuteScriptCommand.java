package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.OneArgCommand;

public class ExecuteScriptCommand implements OneArgCommand {
    private final Receiver receiver;

    public ExecuteScriptCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(String arg) {
        return this.receiver.executeScriptAction(arg);
    }
}
