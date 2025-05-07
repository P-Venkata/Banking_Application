package com.example.demo.Service;

import com.example.demo.Entity.Bank;
import com.example.demo.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountService {

    @Autowired
    private BankRepository bankRepository;

    public boolean deleteAccount(Long id, String password) {
        Bank bank = bankRepository.findByIdAndPassword(id, password);

        if (bank != null) {
            bankRepository.delete(bank);
            return true;
        } else {
            return false;
        }
    }
}