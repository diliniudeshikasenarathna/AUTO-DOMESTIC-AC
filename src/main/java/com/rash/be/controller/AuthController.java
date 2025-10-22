package com.rash.be.controller;

import com.rash.be.auth.JwtUtil;
import com.rash.be.dto.AuthResponse;
import com.rash.be.dto.LoginRequest;
import com.rash.be.dto.RegisterRequest;
import com.rash.be.entity.User;
import com.rash.be.service.CustomerUserDetailService;
import com.rash.be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final CustomerUserDetailService customerUserDetailService;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req){
        User created=userService.registerUser(req);
        return ResponseEntity.ok("User registered: "+ created.getUsername());

    }
    public ResponseEntity<?> login(@RequestBody LoginRequest req){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
            );
        }catch (BadCredentialsException ex){
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        UserDetails userDetails= customerUserDetailService.loadUserByUserName(req.getUsername());
        String token =jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token));
    }


}
