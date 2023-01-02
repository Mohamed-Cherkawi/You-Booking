package org.youbooking.root.enums;

public enum AvailabilityStateEnum {
    ONLINE("ONLINE") ,
    OFFLINE("OFFLINE") ,
    IDLE("IDLE") ,
    BANNED("BANNED") ;

    private final String stateName;

    AvailabilityStateEnum(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
