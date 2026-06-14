package com.ecommerce.services;

import com.ecommerce.dto.UserDto;
import com.ecommerce.entities.User;
import com.ecommerce.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
@Service
public class UserService {
    UserRepository userRepository;
    Logger logger = Logger.getLogger(UserService.class.getName());
    BCryptPasswordEncoder passwordEncoder;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDto userDto) {
        User user = new User();
        logger.info("New User object created");
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAddress(userDto.getPassword());
        user.setRole("USER");
        logger.info("User object populated with data from UserDto");
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        logger.info("Fetching user with id: " + id);
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public void updateUser( Long id,UserDto userDto) {
        logger.info("Updating user with id: " + id);
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());
        user.setRole(userDto.getRole());
        logger.info("User object updated with new data from UserDto");
        userRepository.save(user);
    }


    public void updateUserField( Long id, Map<String, Object> updates) {
        logger.info("Updating user fields with id: " + id);
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            switch (entry.getKey()) {
                case "username":
                    user.setUsername((String) entry.getValue());
                    break;
                case "email":
                    user.setEmail((String) entry.getValue());
                    break;
                case "password":
                    user.setPassword((String) entry.getValue());
                    break;
                case "address":
                    user.setAddress((String) entry.getValue());
                    break;
                case "role":
                    user.setRole((String) entry.getValue());
                    break;
            }
        }
        logger.info("User object updated with new field values from updates map");
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        logger.info("Deleting user with id: " + id);
        userRepository.deleteById(id);
    }


    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll();
    }

}
