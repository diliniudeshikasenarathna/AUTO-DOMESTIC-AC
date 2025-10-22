package com.rash.be.auth;

import com.rash.be.service.CustomerUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor

public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final CustomerUserDetailService customerUserDetailService;


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String header = req.getHeader("Authorization");
        String token= null;
        if(header != null && header.startsWith("Bearer")){
            token=header.substring(7);
        }
        if(token!=null && jwtUtil.validateToken(token) && SecurityContextHolder.getContext().getAuthentication() == null){
            String username=jwtUtil.getUsernameFromToken(token);
            UserDetails userDetail=customerUserDetailService.loadUserByUserName(username);
            UsernamePasswordAuthenticationToken auth= new UsernamePasswordAuthenticationToken(
                    userDetail, null, userDetail.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(req,res);
    }
}
