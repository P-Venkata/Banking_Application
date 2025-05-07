package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bank") // Ensures table name is  "bank"
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String username;

    @Column(nullable = false)
    public String password;

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false)
    public String phone;

    // No-argument constructor (required by JPA)
    public Bank() {
    }

    // All-argument constructor
    public Bank(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}