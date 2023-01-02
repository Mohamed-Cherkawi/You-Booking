package org.youbooking.root.enums;

public enum BedTypeEnum {
    STANDARD_SINGLE("STANDARD_SINGLE") ,
    LARGE_SINGLE("LARGE_SINGLE") ,
    LARGE_DOUBLE("LARGE_DOUBLE") ,
    EXTRA_LARGE_DOUBLE("EXTRA_LARGE_DOUBLE") ;

    private final String typeName;

    BedTypeEnum(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
