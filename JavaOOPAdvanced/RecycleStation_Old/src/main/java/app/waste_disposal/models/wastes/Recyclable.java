package app.waste_disposal.models.wastes;

import app.waste_disposal.annotations.Recycle;

@Recycle
public class Recyclable extends BaseWaste {

    public Recyclable(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
