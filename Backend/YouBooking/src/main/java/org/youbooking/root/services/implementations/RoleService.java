package org.youbooking.root.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.youbooking.root.entities.Role;
import org.youbooking.root.enums.RoleEnum;
import org.youbooking.root.repositories.RoleRepository;
import org.youbooking.root.services.interfaces.RoleServiceInterface;

@Service @RequiredArgsConstructor
public class RoleService implements RoleServiceInterface {
    private final RoleRepository roleRepository;


    @Override
    public Role findRoleByName(RoleEnum roleName) {
        return roleRepository.findRoleByName(roleName);
    }
}
