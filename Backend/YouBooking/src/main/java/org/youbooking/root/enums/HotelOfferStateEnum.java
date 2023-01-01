package org.youbooking.root.enums;

public enum HotelOfferStateEnum {
    PENDING("Pending") ,
    ACCEPTED("Accepted") ,
    REJECTED("Rejected");

    private final String stateName;

    HotelOfferStateEnum(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
