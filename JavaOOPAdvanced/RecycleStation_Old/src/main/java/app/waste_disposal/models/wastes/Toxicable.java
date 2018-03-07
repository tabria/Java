package app.waste_disposal.models.wastes;

import app.waste_disposal.annotations.Store;
import app.waste_disposal.annotations.Toxic;

@Toxic
public class Toxicable extends BaseWaste {

    public Toxicable(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
