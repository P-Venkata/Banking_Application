package com.example.demo.Service;


import com.example.demo.Entity.Bank;
import com.example.demo.FeignClient.BalanceEnquiryClient;
import com.example.demo.Repository.BankRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BalanceEnquiryClient balanceEnquiryClient;

    public String withdraw(Long id, String password, Long amount) {
        // Step 1: Verify account details
        Bank bank = bankRepository.findByIdAndPassword(id, password);
        if (bank == null) {
            return "Invalid account details";
        }

        // Step 2: Get the current balance from BalanceEnquiry microservice
        Long currentBalance = balanceEnquiryClient.getBalance(id, password);
        if (currentBalance == null || currentBalance < amount) {
            return "Insufficient balance for withdrawal";
        }

        // Step 3: Perform the withdrawal
        bank.setAmount(currentBalance - amount);
        bankRepository.save(bank);  // Save updated balance

        return "Withdrawal successful! New balance: " + bank.getAmount();
    }
}