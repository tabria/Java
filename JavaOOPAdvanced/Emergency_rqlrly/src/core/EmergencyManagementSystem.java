package core;

import collection.EmergencyRegister;
import collection.Register;
import models.emergencies.Emergency;
import models.centers.EmergencyCenter;

import java.util.HashMap;
import java.util.Map;

public class EmergencyManagementSystem implements ManagementSystem {


    private static final String PROPERTY_TYPE = "Property";
    private static final String HEALTH_TYPE = "Health";
    private static final String ORDER_TYPE = "Order";

    private static final String FIRE_TYPE = "Fire";
    private static final String MEDICAL_TYPE = "Medical";
    private static final String POLICE_TYPE ="Police";


    private static final String EMERGENCY_REGISTER_MESSAGE = "Registered Public %s Emergency of level %s at %s.";

    private static final String EMERGENCY_CENTER_REGISTER_MESSAGE = "Registered %s Service Emergency Center - %s.";

    private static final String PROCESS_SUCCESS ="Successfully responded to all %s emergencies.";
    private static final String NOT_PROCESSED_FULLY = "%s Emergencies left to process: %s.";

    private static final String EMERGENCY_REPORT_HEADER = "PRRM Services Live Statistics\r\n";
    private static final String STATUS_CENTER_INFO = "%s Service Centers: %d\r\n";
    private static final String TOTAL_PROCESSED_EMERGENCIES ="Total Processed Emergencies: %d\r\n";
    private static final String REGISTERED_EMERGENCY_LEFT = "Currently Registered Emergencies: %d\r\n";
    private static final String TOTAL_DAMAGE_FIXED = "Total Property Damage Fixed: %d\r\n";
    private static final String TOTAL_CASUALTIES_SAVE ="Total Health Casualties Saved: %d\r\n";
    private static final String TOTAL_SPECIAL_CASES ="Total Special Cases Processed: %d\r\n";

    private Map<String, Register<Emergency>> registerEmergencies;
    private Map<String, Register<EmergencyCenter>> registerCenters;

    private Map<String, Long> processedEmergencies;
    private Integer countProcessedEmergencies;


    public EmergencyManagementSystem() {
        this.initRegisterEmergencies();
        this.initRegisterCenters();
        this.initProcessedEmergencies();
        this.countProcessedEmergencies = 0;
    }

    private void initRegisterEmergencies(){
        this.registerEmergencies = new HashMap<>();
        this.registerEmergencies.put(PROPERTY_TYPE, new EmergencyRegister<>());
        this.registerEmergencies.put(HEALTH_TYPE, new EmergencyRegister<>());
        this.registerEmergencies.put(ORDER_TYPE, new EmergencyRegister<>());
    }

    private void initRegisterCenters(){
        this.registerCenters = new HashMap<>();
        this.registerCenters.put(PROPERTY_TYPE, new EmergencyRegister<>());
        this.registerCenters.put(HEALTH_TYPE, new EmergencyRegister<>());
        this.registerCenters.put(ORDER_TYPE, new EmergencyRegister<>());
    }

    private void initProcessedEmergencies(){
        this.processedEmergencies = new HashMap<>();
        this.processedEmergencies.put(PROPERTY_TYPE, 0L);
        this.processedEmergencies.put(HEALTH_TYPE, 0L);
        this.processedEmergencies.put(ORDER_TYPE, 0L);
    }

    @Override
    public String registerPropertyEmergency(Emergency emergency) {
        this.registerEmergencies.get(PROPERTY_TYPE).enqueueEmergency(emergency);
        return String.format(EMERGENCY_REGISTER_MESSAGE, PROPERTY_TYPE, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerHealthEmergency(Emergency emergency) {
        this.registerEmergencies.get(HEALTH_TYPE).enqueueEmergency(emergency);
        return String.format(EMERGENCY_REGISTER_MESSAGE, HEALTH_TYPE, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerOrderEmergency(Emergency emergency) {
        this.registerEmergencies.get(ORDER_TYPE).enqueueEmergency(emergency);
        return String.format(EMERGENCY_REGISTER_MESSAGE, ORDER_TYPE, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerFireServiceCenter(EmergencyCenter center) {
        this.registerCenters.get(PROPERTY_TYPE).enqueueEmergency(center);
        return String.format(EMERGENCY_CENTER_REGISTER_MESSAGE, FIRE_TYPE, center.getName());
    }

    @Override
    public String registerMedicalServiceCenter(EmergencyCenter center) {
        this.registerCenters.get(HEALTH_TYPE).enqueueEmergency(center);
        return String.format(EMERGENCY_CENTER_REGISTER_MESSAGE, MEDICAL_TYPE, center.getName());
    }

    @Override
    public String registerPoliceServiceCenter(EmergencyCenter center) {
        this.registerCenters.get(ORDER_TYPE).enqueueEmergency(center);
        return String.format(EMERGENCY_CENTER_REGISTER_MESSAGE, POLICE_TYPE, center.getName()) ;
    }

    @Override
    public String processEmergencies(String type) {

        Register<Emergency> emergencies  = this.registerEmergencies.get(type);
        Register<EmergencyCenter> centers = this.registerCenters.get(type);
        while(true){
            if (emergencies.isEmpty() || centers.isEmpty()){
                break;
            }
            EmergencyCenter center = centers.peekEmergency();
            if (!center.isForRetirement(this.countProcessedEmergencies)){
                Long calculateExtraProperty = this.processedEmergencies.get(type) + emergencies.peekEmergency().getExtraProperty();
                this.processedEmergencies.put(type ,calculateExtraProperty);
                this.countProcessedEmergencies++;
                emergencies.dequeueEmergency();
            } else {
                centers.dequeueEmergency();
            }
        }

        Integer emergenciesLeft = this.registerEmergencies.get(type).count();
        if (emergenciesLeft > 0){
            return String.format(NOT_PROCESSED_FULLY, type, emergenciesLeft);
        } else {
            return String.format(PROCESS_SUCCESS, type);
        }
    }

    @Override
    public String emergencyReport() {

        Integer activeFireServiceCenters = this.registerCenters.get(PROPERTY_TYPE).count();
        Integer activeMedicalServiceCenters = this.registerCenters.get(HEALTH_TYPE).count();
        Integer activePoliceServiceCenters = this.registerCenters.get(ORDER_TYPE).count();

        Integer totalProcessedEmergencies = this.countProcessedEmergencies;

        Integer registeredEmergenciesLeft = this.registerEmergencies.get(PROPERTY_TYPE).count() + this.registerEmergencies.get(HEALTH_TYPE).count() + this.registerEmergencies.get(ORDER_TYPE).count();

        StringBuilder stat = new StringBuilder();
        stat.append(EMERGENCY_REPORT_HEADER)
                .append(String.format(STATUS_CENTER_INFO, FIRE_TYPE, activeFireServiceCenters))
                .append(String.format(STATUS_CENTER_INFO, MEDICAL_TYPE, activeMedicalServiceCenters))
                .append(String.format(STATUS_CENTER_INFO, POLICE_TYPE, activePoliceServiceCenters))
                .append(String.format(TOTAL_PROCESSED_EMERGENCIES, totalProcessedEmergencies))
                .append(String.format(REGISTERED_EMERGENCY_LEFT, registeredEmergenciesLeft))
                .append(String.format(TOTAL_DAMAGE_FIXED, this.processedEmergencies.get(PROPERTY_TYPE)))
                .append(String.format(TOTAL_CASUALTIES_SAVE, this.processedEmergencies.get(HEALTH_TYPE)))
                .append(String.format(TOTAL_SPECIAL_CASES, this.processedEmergencies.get(ORDER_TYPE)));

        return stat.toString();
    }
}
