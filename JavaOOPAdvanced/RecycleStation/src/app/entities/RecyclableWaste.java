package app.entities;

import app.waste_disposal.annotations.Recyclable;

@Recyclable
public class RecyclableWaste extends BaseWaste {

    public RecyclableWaste(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
