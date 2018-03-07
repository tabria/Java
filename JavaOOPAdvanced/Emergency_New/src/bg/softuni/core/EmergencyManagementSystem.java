package bg.softuni.core;

import bg.softuni.contracts.Emergency;
import bg.softuni.contracts.EmergencyCenter;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.contracts.Register;
import bg.softuni.factories.EmergencyRegisterFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmergencyManagementSystem implements ManagementSystem {

    private static final String PROPERTY_TYPE = "Property";
    private static final String HEALTH_TYPE = "Health";
    private static final String ORDER_TYPE = "Order";
    private static final String REGISTER_EMERGENCY_MESSAGE = "Registered Public %s Emergency of level %s at %s.";
    private static final String REGISTER_CENTER_MESSAGE = "Registered %s Service Emergency Center - %s.";

    private Map<String, Register<Emergency>> registerEmergencies;
    private Map<String, Register<EmergencyCenter>> registerCenters;
    private Map<String, Register<EmergencyCenter>> retiredCenters;
    private Map<String, Long> processedEmergencies;
    private int countProcessed;



    public EmergencyManagementSystem() {
        this.registerEmergencies = new LinkedHashMap<>();
        this.registerCenters = new LinkedHashMap<>();
        this.retiredCenters = new LinkedHashMap<>();
        this.processedEmergencies = new LinkedHashMap<>();
        this.countProcessed = 0;
        this.InitRegisterEmergencies();
        this.InitRegisterCenters();
        this.InitRetiredCenters();
        this.InitProcessedEmergencies();

    }

    private void InitRegisterEmergencies(){
        this.registerEmergencies.put(PROPERTY_TYPE, EmergencyRegisterFactory.create());
        this.registerEmergencies.put(HEALTH_TYPE, EmergencyRegisterFactory.create());
        this.registerEmergencies.put(ORDER_TYPE, EmergencyRegisterFactory.create());
    }

    private void InitProcessedEmergencies(){
        this.processedEmergencies.put(PROPERTY_TYPE, 0L);
        this.processedEmergencies.put(HEALTH_TYPE, 0L);
        this.processedEmergencies.put(ORDER_TYPE, 0L);
    }

    private void InitRegisterCenters(){
        this.registerCenters.put(PROPERTY_TYPE, EmergencyRegisterFactory.create());
        this.registerCenters.put(HEALTH_TYPE, EmergencyRegisterFactory.create());
        this.registerCenters.put(ORDER_TYPE, EmergencyRegisterFactory.create());
    }
    private void InitRetiredCenters(){
        this.retiredCenters.put(PROPERTY_TYPE, EmergencyRegisterFactory.create());
        this.retiredCenters.put(HEALTH_TYPE, EmergencyRegisterFactory.create());
        this.retiredCenters.put(ORDER_TYPE, EmergencyRegisterFactory.create());
    }

    @Override
    public String registerPropertyEmergency(Emergency emergency) {
        this.registerEmergencies.get(PROPERTY_TYPE).enqueueEmergency(emergency);
        return String.format(REGISTER_EMERGENCY_MESSAGE,PROPERTY_TYPE, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerHealthEmergency(Emergency emergency) {
        this.registerEmergencies.get(HEALTH_TYPE).enqueueEmergency(emergency);
        return String.format(REGISTER_EMERGENCY_MESSAGE, HEALTH_TYPE, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerOrderEmergency(Emergency emergency) {
        this.registerEmergencies.get(ORDER_TYPE).enqueueEmergency(emergency);
        return String.format(REGISTER_EMERGENCY_MESSAGE, ORDER_TYPE, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerFireServiceCenter(EmergencyCenter emergencyCenter) {
        this.registerCenters.get(PROPERTY_TYPE).enqueueEmergency(emergencyCenter);
        return String.format(REGISTER_CENTER_MESSAGE, "Fire", emergencyCenter.getName());
    }

    @Override
    public String registerMedicalServiceCenter(EmergencyCenter emergencyCenter)     {
        this.registerCenters.get(HEALTH_TYPE).enqueueEmergency(emergencyCenter);
        return String.format(REGISTER_CENTER_MESSAGE, "Medical", emergencyCenter.getName());
}

    @Override
    public String registerPoliceServiceCenter(EmergencyCenter emergencyCenter) {
        this.registerCenters.get(ORDER_TYPE).enqueueEmergency(emergencyCenter);
        return String.format(REGISTER_CENTER_MESSAGE, "Police", emergencyCenter.getName());
    }

    @Override
    public String processEmergencies(String type)
    {
        Register<Emergency> emergencyRegister = this.registerEmergencies.get(type);
        Register<EmergencyCenter> emergencyCenterRegister = this.registerCenters.get(type);
        while(true){
            Emergency emergency = null;
            EmergencyCenter emergencyCenter = null;
            if (emergencyRegister.isEmpty()){
                break;
            }
            if (emergencyCenterRegister.isEmpty()){
                break;
            }
            emergency = emergencyRegister.peekEmergency();
            emergencyCenter = emergencyCenterRegister.peekEmergency();
            if (!emergencyCenter.isForRetirement()){
                Long extraProperty = this.processedEmergencies.get(type) + emergency.getExtraProperty();
                this.processedEmergencies.put(type, extraProperty);
                this.countProcessed++;
                emergencyCenter.addProcessedEmergencies();
                emergencyRegister.dequeueEmergency();
                if (!emergencyCenter.isForRetirement()){
                    emergencyCenterRegister.dequeueEmergency();
                    emergencyCenterRegister.enqueueEmergency(emergencyCenter);
                } else {
                    this.retiredCenters.get(type).enqueueEmergency(emergencyCenter);
                    emergencyCenterRegister.dequeueEmergency();

                }


            }
        }

        if(emergencyRegister.isEmpty()){
            return String.format("Successfully responded to all %s emergencies.", type);
        } else {
            return String.format("%s Emergencies left to process: %d.", type, emergencyRegister.getCurrentSize());
        }
    }

    @Override
    public String emergencyReport() {

        StringBuilder sb = new StringBuilder();
        sb.append("PRRM Services Live Statistics\r\n")
                .append(String.format("Fire Service Centers: %d\r\n",this.registerCenters.get(PROPERTY_TYPE).getCurrentSize()))
                .append(String.format("Medical Service Centers: %d\r\n",this.registerCenters.get(HEALTH_TYPE).getCurrentSize()))
                .append(String.format("Police Service Centers: %d\r\n",this.registerCenters.get(ORDER_TYPE).getCurrentSize()))
                .append(String.format("Total Processed Emergencies: %d\r\n", this.countProcessed))
                .append(String.format("Currently Registered Emergencies: %d\r\n",getTotalEmergencies(this.registerEmergencies)))
                .append(String.format("Total Property Damage Fixed: %d\r\n", this.processedEmergencies.get(PROPERTY_TYPE)))
                .append(String.format("Total Health Casualties Saved: %d\r\n", this.processedEmergencies.get(HEALTH_TYPE)))
                .append(String.format("Total Special Cases Processed: %d", this.processedEmergencies.get(ORDER_TYPE)));

        return sb.toString();
    }

    private Integer getTotalEmergencies(Map<String, Register<Emergency>> emergencies) {
        Integer countEmergencies = 0;
        for (Map.Entry<String, Register<Emergency>> emergencySet : emergencies.entrySet()) {
            countEmergencies += emergencySet.getValue().getCurrentSize();
        }
        return countEmergencies;
    }
}
