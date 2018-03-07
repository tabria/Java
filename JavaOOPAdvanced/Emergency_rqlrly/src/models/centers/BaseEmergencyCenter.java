package models.centers;

public abstract class BaseEmergencyCenter implements EmergencyCenter {

    private String name;

    private Integer amountOfMaximumEmergencies;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    @Override
    public Boolean isForRetirement(Integer processedEmergencies) {
        return this.getAmountOfMaximumEmergencies() <= processedEmergencies;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }
}
