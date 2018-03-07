package models.centers;

public interface EmergencyCenter {

    String getName();
    Integer getAmountOfMaximumEmergencies();
    Boolean isForRetirement(Integer processedEmergencies);

}
