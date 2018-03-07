package bg.softuni.models.centers;

import bg.softuni.contracts.Emergency;
import bg.softuni.contracts.EmergencyCenter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseEmergencyCenter implements EmergencyCenter {
    private String name;

    private Integer amountOfMaximumEmergencies;

    private Integer processedEmergencies;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
        this.processedEmergencies = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    public abstract Boolean isForRetirement();

    public Integer getProcessedEmergencies() {
        return this.processedEmergencies;
    }

    public void addProcessedEmergencies() {
        this.processedEmergencies++;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }


}
