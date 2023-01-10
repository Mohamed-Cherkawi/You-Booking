package org.youbooking.root.services.dtos;

import lombok.Getter;
import lombok.Setter;
import org.youbooking.root.enums.RoleEnum;

@Getter @Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String cin;
    private RoleEnum role;
}