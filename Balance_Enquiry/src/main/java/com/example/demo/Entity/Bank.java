package com.example.demo.Entity;



import jakarta.persistence.*;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Long amount;

    public Bank() {}

    public Bank(String username, String password, String email, String phone, Long amount) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Long getAmount() {
        return amount;
    }
}