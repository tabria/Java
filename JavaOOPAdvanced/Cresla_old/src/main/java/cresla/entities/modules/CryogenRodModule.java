package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

public class CryogenRodModule extends BaseModule implements EnergyModule {

    private static final String MODULE_SUFFIX = "Module";
    private static final String ENERGY_OUTPUT = "Energy Output";

    private int energyOutput;

    public CryogenRodModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {

        String moduleType = this.getClass().getSimpleName().replace(MODULE_SUFFIX, "");
        int id = super.getId();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Module - %d\r\n", moduleType, id))
                .append(String.format("%s: %d",ENERGY_OUTPUT, this.energyOutput));

        return sb.toString();
    }



}
