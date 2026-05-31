package com.ecommerce.restControllers;


import com.ecommerce.dto.UserDto;
import com.ecommerce.entities.User;
import com.ecommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class UserRestController {

    UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        userService.updateUser(id,userDto);
        return ResponseEntity.ok("User updated successfully");
    }

    @PatchMapping("/updateUserField/{id}")
    public ResponseEntity<String> updateUserField(@PathVariable Long id,@Valid @RequestBody Map<String, Object> updates) {
        userService.updateUserField(id, updates);
        return ResponseEntity.ok("User field updated successfully");
    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

}
