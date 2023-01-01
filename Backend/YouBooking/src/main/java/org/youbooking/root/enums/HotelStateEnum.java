package org.youbooking.root.enums;

public enum HotelStateEnum {
    OPEN("Open") ,
    CLOSED("Closed") ,
    UNDER_DEVELOPMENT("Under_Development") ;

    private final String stateName;

    HotelStateEnum(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
