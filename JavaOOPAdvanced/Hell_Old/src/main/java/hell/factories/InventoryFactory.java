package hell.factories;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;

public final class InventoryFactory {

    public static Inventory createInventory(){
        return new HeroInventory();
    }

}
