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



	public void setAmount(long newBalance) {
		this.amount=newBalance ;
		// TODO Auto-generated method stub
		
	}
}