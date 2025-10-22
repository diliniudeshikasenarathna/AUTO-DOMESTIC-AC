package com.rash.be.auth;

import com.rash.be.entity.Role;
import com.rash.be.entity.User;
import com.rash.be.repository.RoleRepository;
import com.rash.be.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName("ROLE_USER").isEmpty()){
            roleRepository.save(new Role(null,"ROLE_USER"));
        }
        if(roleRepository.findByName("ROLE_ADMIN").isEmpty()){
            roleRepository.save(new Role(null,"ROLE_ADMIN"));
        }

        if(userRepository.findByUsername("admin").isEmpty()){
            Role adminRole=roleRepository.findByName("ROLE_ADMIN").get();
            Role userRole=roleRepository.findByName("ROLE_USER").get();
            User admin=new User();
            admin.setUsername("admin");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("adminpassword"));
            admin.getRoles().add(adminRole);
            admin.getRoles().add(userRole);
            userRepository.save(admin);
            System.out.println("Created default admin (admin/adminpassword)");

        }

    }
}
