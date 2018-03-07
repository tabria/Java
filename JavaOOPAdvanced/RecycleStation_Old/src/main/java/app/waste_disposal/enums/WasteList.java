package app.waste_disposal.enums;

public enum WasteList {

    BURNABLE, RECYCLABLE, STORABLE, TOXICABLE;

    @Override
    public String toString() {
        String name = this.name().substring(1).toLowerCase();
        return this.name().charAt(0) + name;
    }
}
