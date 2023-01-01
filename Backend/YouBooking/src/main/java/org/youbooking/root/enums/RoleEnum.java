package org.youbooking.root.enums;

public enum RoleEnum {

    CLIENT("CLIENT") ,
    HOTEL_OWNER("HOTEL_OWNER") ,
    ADMIN("ADMIN");

    private final String roleName;

    RoleEnum(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
