package org.youbooking.root.enums;

public enum BedRoomStateEnum {
    RESERVED("RESERVED") ,
    AVAILABLE("AVAILABLE") ,
    DISABLED("DISABLED") ;

    private final String stateName;

    BedRoomStateEnum(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
