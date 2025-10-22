package com.rash.be.service.impl;

import com.rash.be.entity.User;
import com.rash.be.repository.UserRepository;
import com.rash.be.service.CustomerUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsServiceImpl implements CustomerUserDetailService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException {
        User u=userRepository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(),
                u.getPassword(),
                u.getRoles().stream()
                        .map(r-> new SimpleGrantedAuthority(r.getName()))
                        .collect(Collectors.toSet())
        );
    }
}
