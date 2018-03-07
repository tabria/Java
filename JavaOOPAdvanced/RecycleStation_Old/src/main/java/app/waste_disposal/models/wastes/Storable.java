package app.waste_disposal.models.wastes;

import app.waste_disposal.annotations.Store;

@Store
public class Storable extends BaseWaste {

    public Storable(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
