package contracts;

public interface IBoat extends IModelable {
    double CalculateRaceSpeed(IRace race);

    String getBoatType();
}
