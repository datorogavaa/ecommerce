package com.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @NotEmpty
    private String address;


    
}
