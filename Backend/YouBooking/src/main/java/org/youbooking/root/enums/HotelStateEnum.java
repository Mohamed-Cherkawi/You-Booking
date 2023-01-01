package org.youbooking.root.enums;

public enum HotelStateEnum {
    OPEN("OPEN") ,
    CLOSED("CLOSED") ,
    RESERVED("RESERVED") ,
    UNDER_DEVELOPMENT("UNDER_DEVELOPMENT") ;

    private final String stateName;

    HotelStateEnum(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
