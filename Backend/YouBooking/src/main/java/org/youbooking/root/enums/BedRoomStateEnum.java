package org.youbooking.root.enums;

public enum BedRoomStateEnum {
    RESERVED("Reserved") ,
    AVAILABLE("Available") ,
    DISABLED("Disabled") ;

    private final String stateName;

    BedRoomStateEnum(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
