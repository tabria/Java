package database;

import contracts.IBoat;
import contracts.IEngine;
import contracts.IRepository;

public class BoatSimulatorDatabase {
    private IRepository<IBoat> boats;
    private IRepository<IEngine> engines;

    @SuppressWarnings("unchecked")
    public BoatSimulatorDatabase() {
        this.boats = new Repository<IBoat>();
        this.engines = new Repository<IEngine>();
    }

    public IRepository<IBoat> getBoats() {
        return this.boats;
    }

    public IRepository<IEngine> getEngines() {
        return this.engines;
    }
}
