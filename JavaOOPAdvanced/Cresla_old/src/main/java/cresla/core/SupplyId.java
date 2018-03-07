package cresla.core;

import cresla.annotations.InjectID;
import cresla.interfaces.Identifiable;

public class SupplyId implements Identifiable {

    private static final int ID_DEFAULT_VALUE =0;

    private int id;

    public SupplyId() {
        this.id = ID_DEFAULT_VALUE;
    }


    @Override
    public int getId() {
        return ++this.id;
    }
}
