package com.example.demo.Controller;


import com.example.demo.Entity.Bank;
import com.example.demo.FeignClient.BalanceEnquiryClient; // Import the BalanceEnquiryClient
import com.example.demo.Repository.BankRepository;
import com.example.demo.Service.WithdrawService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/withdraw")
public class WithdrawController {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BalanceEnquiryClient balanceEnquiryClient; // Inject the Feign client

    @PostMapping("/withdrawal")
    public ResponseEntity<Object> withdraw(@RequestParam Long id, @RequestParam String password, @RequestParam Long amount) {
        // Step 1: Verify account details
        Bank bank = bankRepository.findByIdAndPassword(id, password);

        if (bank == null) {
            return ResponseEntity.ok("Invalid account details");
        }
 
        Long currentBalance = balanceEnquiryClient.getBalance(id, password);

        // Step 3: Check if the withdrawal amount is valid (insufficient balance check)
        if (currentBalance == null || currentBalance < amount) {
            return ResponseEntity.ok("Insufficient balance for withdrawal");
        }

        // Step 4: Perform the withdrawal by updating the account balance
        bank.setAmount(currentBalance - amount);
        bankRepository.save(bank); // Save the updated balance

        return ResponseEntity.ok("Withdrawal successful! New balance: " + bank.getAmount());
    }
}