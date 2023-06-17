package proga.command;

import proga.aplication.CollectionWorker;
import proga.aplication.Receiver;
import proga.command.commandInterfaces.OneArgCommand;
import proga.inputUtils.InputReader;
import proga.models.LabWork;
import proga.serializers.LabWorkSerializer;

public class UpdateCommand implements OneArgCommand {

    private final Receiver receiver;
    private final CollectionWorker collectionWorker;

    public UpdateCommand(Receiver receiver, CollectionWorker collectionWorker) {
        this.receiver =  receiver;
        this.collectionWorker = collectionWorker;
    }


    @Override
    public String execute(String arg1) {
        long id = Long.parseLong(arg1);
        if (collectionWorker.checkIfIDFind((int) id)) {
            InputReader inputReader = new InputReader(this.collectionWorker);
            LabWork labWork = LabWorkSerializer.deserialize(LabWorkSerializer.serialize(inputReader.receiveLabWork()));
            return this.receiver.updateAction(id, labWork);
        } else {
            return "Element has not been updated because there are no element with entered ID.\n";
        }
    }
}
