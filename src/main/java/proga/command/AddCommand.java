package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.OneArgCommand;
import proga.models.LabWork;
import proga.serializers.LabWorkSerializer;

public class AddCommand implements OneArgCommand {

    private final Receiver receiver;

    public AddCommand(Receiver receiver) {
        this.receiver = receiver;
    }


    @Override
    public String execute(String arg) {
        LabWork labWork = LabWorkSerializer.deserialize(arg);
        return this.receiver.addAction(labWork);
    }

}
