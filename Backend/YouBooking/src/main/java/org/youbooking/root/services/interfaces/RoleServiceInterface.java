package org.youbooking.root.services.interfaces;

import org.youbooking.root.entities.Role;
import org.youbooking.root.enums.RoleEnum;


public interface RoleServiceInterface {
    Role findRoleByName(RoleEnum roleName);
}
