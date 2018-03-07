package app.waste_disposal.models.wastes;

import app.waste_disposal.annotations.Burn;

@Burn
public class Burnable extends BaseWaste {

    public Burnable(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
