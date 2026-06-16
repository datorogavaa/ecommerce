package com.ecommerce;

import com.ecommerce.entities.User;
import com.ecommerce.repositories.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public ApplicationRunner init(UserRepository userRepository,
                                  PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findUserByUsername("admin") == null) {

                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");

                admin.setFirstName("System");
                admin.setLastName("Admin");
                admin.setAddress("Admin");
                admin.setPhoneNumber("0000000000");
                admin.setEmail("admin@system.com");

                userRepository.save(admin);
            }
        };
    }
}