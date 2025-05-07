package com.example.demo.Service;



import com.example.demo.Entity.Bank;
import com.example.demo.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    // Authenticate using ID and password
    public Bank findByIdAndPassword(Long id, String password) {
        return bankRepository.findByIdAndPassword(id, password);
    }

    // Update bank record with new balance
    public void save(Bank bank) {
        bankRepository.save(bank); // Will update if the ID is present
    }
}