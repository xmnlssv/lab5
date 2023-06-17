package proga.command;

import proga.aplication.Receiver;
import proga.command.commandInterfaces.OneArgCommand;
import proga.models.Person;
import proga.serializers.AuthorSerializer;

public class RemoveByAuthorCommand implements OneArgCommand {
    private final Receiver receiver;

    public RemoveByAuthorCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(String arg) {
        Person author = AuthorSerializer.deserialize(arg);
        return this.receiver.removeByAuthorAction(author);
    }
}
