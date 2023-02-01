package org.youbooking.root.services.interfaces;

import org.youbooking.root.entities.AppUser;
import org.youbooking.root.enums.RoleEnum;


import java.util.List;

public interface UserServiceInterface {
    List<AppUser> getAllUsers();
    AppUser saveUser(AppUser user);
    AppUser banUser(Long userId);
    AppUser unBanUser(Long userId);
    AppUser findUserByUsername(String username);
    AppUser findUserByRole(RoleEnum role);
    boolean isUsernameAlreadyExists(String username);
}