package com.rash.be.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomerUserDetailService {
    public UserDetails loadUserByUserName(String username);
}
