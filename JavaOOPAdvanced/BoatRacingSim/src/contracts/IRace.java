package contracts;

import exeptions.DuplicateModelException;

import java.util.List;

public interface IRace
{
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats();

    void AddParticipant(IBoat boat) throws DuplicateModelException;

    List<IBoat> GetParticipants();
}
