package org.youbooking.root.enums;

public enum HotelOfferStateEnum {
    PENDING("PENDING") ,
    ACCEPTED("ACCEPTED") ,
    REJECTED("REJECTED");

    private final String stateName;

    HotelOfferStateEnum(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
