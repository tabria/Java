package bg.softuni.contracts;

import java.util.Collections;
import java.util.List;

public interface EmergencyCenter {

    String getName();

    Integer getAmountOfMaximumEmergencies();

    Integer getProcessedEmergencies();

    void addProcessedEmergencies();
    Boolean isForRetirement();

}
