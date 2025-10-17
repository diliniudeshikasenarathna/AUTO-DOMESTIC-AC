package com.rash.be.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
    private Long id;
    private String username;
    private String fullName;
    private String role;  // ADMIN, STAFF
    private boolean active;
}
