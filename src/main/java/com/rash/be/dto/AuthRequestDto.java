package com.rash.be.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AuthRequestDto {
    private String username;

    private String password;
}
