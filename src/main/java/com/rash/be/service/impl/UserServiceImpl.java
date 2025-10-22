package com.rash.be.service.impl;

import com.rash.be.dto.RegisterRequest;
import com.rash.be.dto.UserDto;
import com.rash.be.entity.Role;
import com.rash.be.entity.User;
import com.rash.be.repository.RoleRepository;
import com.rash.be.repository.UserRepository;
import com.rash.be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(RegisterRequest req) {
        if(userRepository.existsByUsername(req.getUsername())){
            throw new RuntimeException("Username already taken");
        }
        if(userRepository.existsByEmail(req.getEmail())){
            throw new RuntimeException("Email already in use");
        }

        User user=new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));


        Role userRole=roleRepository.findByName("ROLE_USER")
                .orElseThrow(()-> new RuntimeException("User role not found"));
        user.setRoles(Set.of(userRole));
        return userRepository.save(user);


    }
}
