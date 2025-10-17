package com.rash.be.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AuthResponseDto {
    private String token;
    private String username;
    private String role;
}
