package com.example.demo.Service;

import com.example.demo.Entity.Bank;
import com.example.demo.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public String createAccount(Bank bank) {
        try {
            bankRepository.save(bank);
            return "Account created successfully!";
        } catch (DataIntegrityViolationException e) {
            return "Email already exists. Please use a different email.";
        } catch (Exception e) {
            return "Something went wrong. Please try again.";
        }
    }
}