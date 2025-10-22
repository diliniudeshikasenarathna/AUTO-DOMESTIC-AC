package com.rash.be.service;

import com.rash.be.dto.RegisterRequest;
import com.rash.be.dto.UserDto;
import com.rash.be.entity.User;

public interface UserService {
    public User registerUser(RegisterRequest req);
}
