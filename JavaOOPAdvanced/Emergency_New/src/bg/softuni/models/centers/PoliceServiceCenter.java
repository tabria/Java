package bg.softuni.models.centers;

import bg.softuni.contracts.Emergency;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PoliceServiceCenter extends BaseEmergencyCenter {

    public PoliceServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
    }


    @Override
    public Boolean isForRetirement() {
        return super.getAmountOfMaximumEmergencies() == super.getProcessedEmergencies();
    }
}
