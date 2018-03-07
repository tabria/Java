package cresla.entities.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class HeatAbsorbingModule extends BaseModule implements AbsorbingModule {

    private static final String MODULE_SUFFIX = "Module";
    private static final String ENERGY_OUTPUT = "Heat Absorbing";

    private int heatAbsorbing;

    protected HeatAbsorbingModule(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }
    @Override
    public String toString() {

        String moduleType = this.getClass().getSimpleName().replace(MODULE_SUFFIX, "");
        int id = super.getId();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Module - %d\r\n", moduleType, id))
                .append(String.format("%s: %d",ENERGY_OUTPUT, this.heatAbsorbing));

        return sb.toString();
    }
}
