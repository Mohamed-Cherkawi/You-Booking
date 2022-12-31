package org.youbooking.root.enums;

public enum RoleEnum {

    CLIENT("Client") ,
    HOTEL_OWNER("Hotel_Owner") ,
    ADMIN("Admin");

    private String roleName;

    RoleEnum(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
